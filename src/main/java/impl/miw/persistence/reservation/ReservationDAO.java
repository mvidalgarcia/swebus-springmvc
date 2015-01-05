package impl.miw.persistence.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.Reservation;
import com.miw.persistence.ReservationDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad PAYMENT.
 * 
 */
public class ReservationDAO implements ReservationDataService {
	
	@SuppressWarnings("resource")
	public boolean newReservation(Reservation reservation) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Integer codeReservation=null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			//Creamos el usuario
			ps = con.prepareStatement("insert into reservation(id_departure_route,id_return_route,departure_date,"
					+ "return_date,id_departure_time,id_return_time,one_way_trip,number_adults,number_youths,"
					+ "number_students,number_seniors,number_disables,number_pets,extra_baggage,"
					+ "priority_boarding,bike,insurance,id_payment,id_user) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, reservation.getDepartureTime().getIdRoute());
			if (reservation.getReturnTime() != null){
				ps.setInt(2, reservation.getReturnTime().getIdRoute());
				ps.setInt(6, reservation.getReturnTime().getId());
			}
			else {
				ps.setInt(2, -1);
				ps.setInt(6, -1);
			}
			ps.setString(3, reservation.getDepartureDate());
			ps.setString(4, reservation.getReturnDate());
			ps.setInt(5, reservation.getDepartureTime().getId());
			ps.setBoolean(7, reservation.isOneWayTrip());
			ps.setInt(8, reservation.getNumberAdults());
			ps.setInt(9, reservation.getNumberYouths());
			ps.setInt(10, reservation.getNumberStudents());
			ps.setInt(11, reservation.getNumberSeniors());
			ps.setInt(12, reservation.getNumberDisables());
			ps.setInt(13, reservation.getNumberPets());
			ps.setBoolean(14, reservation.isExtraBaggage());
			ps.setBoolean(15, reservation.isPriorityBoarding());
			ps.setBoolean(16, reservation.isBike());
			ps.setBoolean(17, reservation.isInsurance());
			ps.setInt(18, reservation.getIdPayment());
			ps.setInt(19, reservation.getIdUser());
			ps.executeUpdate();
			
			//Obtener ID de la reserva que se acaba de meter en BD
			ps = con.prepareStatement("select max(code) as maximo from reservation");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 codeReservation = rs.getInt("maximo");
			}
			System.out.println("[ReservationDAO] Registrada nueva reserva id="+codeReservation+": " + reservation);		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ReservationDAO] Se ha producido un error al registrar la reserva: " + reservation);
			return false;
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
}