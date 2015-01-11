package impl.miw.persistence.reservation;

import impl.miw.persistence.city.CityDAO;
import impl.miw.persistence.time.TimeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.Reservation;
import com.miw.persistence.ReservationDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad PAYMENT.
 * 
 */
public class ReservationDAO implements ReservationDataService {
	
	@SuppressWarnings("resource")
	public Integer newReservation(Reservation reservation) throws Exception {
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
					+ "priority_boarding,bike,insurance,price,id_payment,id_user) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			ps.setDouble(18, reservation.getPrice());
			ps.setInt(19, reservation.getIdPayment());
			ps.setInt(20, reservation.getIdUser());
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
			return null;
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				return null;
			}
		}
		return codeReservation;
	}

	@Override
	public Reservation getReservation(Integer code) throws Exception {
		// Inicializamos la reserva.
		Reservation resultado = new Reservation();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		CityDAO cityDao = new CityDAO();
		TimeDAO timeDao = new TimeDAO();

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			// Obtener la reserva
			ps = con.prepareStatement("select * from reservation where code=?");
			ps.setInt(1, code);
			rs = ps.executeQuery();
			boolean empty = true;
			while (rs.next()) {
				// Guardamos el horario obtenido
				resultado.setCode(rs.getInt("code"));
				resultado.setCityFrom((cityDao.getCitiesByIdRoute(rs.getInt("id_departure_route")).get("from")));
				resultado.setCityTo((cityDao.getCitiesByIdRoute(rs.getInt("id_departure_route")).get("to")));
				resultado.setPrice(rs.getDouble("price"));
				resultado.setDepartureDate(rs.getString("departure_date"));
				resultado.setReturnDate(rs.getString("return_date"));
				resultado.setOneWayTrip(rs.getBoolean("one_way_trip"));
				resultado.setDepartureTime(timeDao.getTimeById(rs.getInt("id_departure_time")));
				if (!resultado.isOneWayTrip())
					resultado.setReturnTime(timeDao.getTimeById(rs.getInt("id_return_time")));
				resultado.setNumberAdults(rs.getInt("number_adults"));
				resultado.setNumberDisables(rs.getInt("number_disables"));
				resultado.setNumberPets(rs.getInt("number_pets"));
				resultado.setNumberSeniors(rs.getInt("number_seniors"));
				resultado.setNumberStudents(rs.getInt("number_students"));
				resultado.setNumberYouths(rs.getInt("number_youths"));
				resultado.setExtraBaggage(rs.getBoolean("extra_baggage"));
				resultado.setPriorityBoarding(rs.getBoolean("priority_boarding"));
				resultado.setBike(rs.getBoolean("bike"));
				resultado.setInsurance(rs.getBoolean("insurance"));
				empty = false;
			}
			// Si no retorna nada de DB devolvemos null
			if (empty)
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		return resultado;
	}

	@SuppressWarnings("resource")
	@Override
	public boolean deleteReservationByCode(Integer code, Integer idUser) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		Integer paymentId = null;
		Integer idUserFetched = null;
		
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			// Obtener la el id del pago para eliminarlo posteriormente
			ps = con.prepareStatement("select id_payment, id_user from reservation where code=?");
			ps.setInt(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				// Guardamos el id del pago
				paymentId= rs.getInt("id_payment");
				idUserFetched = rs.getInt("id_user");
			}
			if (paymentId == null){
				// No existe reserva con este id
				System.out.println("[ReservationDAO] No existe reserva con código="+code);
				return false;
			}
			if (idUser != idUserFetched){
				// Si el usuario que intenta eliminar la reserva es distinto del propietario
				// de la reserva correspondiente al código introducido, retornar falso.
				System.out.println("[ReservationDAO] El usuario id="+idUser+" no es propietario de la reserva. (Es de id_user="+idUserFetched+")");
				return false;
			}
			System.out.println("[ReservationDAO] Proceder a borrar pago id="+paymentId);
			// Eliminar el pago encontrado. Gracias a la propiedad ON DELETE CASCADE
			// se eliminará la reserva.
			ps = con.prepareStatement("delete from payment where id=?");
			ps.setInt(1, paymentId);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		return true;
	}

	@Override
	public Vector<Reservation> getReservationsByIdUser(Integer idUser) throws Exception {
		Vector<Reservation> resultado = new Vector<Reservation>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		CityDAO cityDao = new CityDAO();
		TimeDAO timeDao = new TimeDAO();
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			// Obtener la reserva
			ps = con.prepareStatement("select * from reservation where id_user=?");
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			boolean empty = true;
			while (rs.next()) {
				Reservation reservation = new Reservation();
				// Guardamos el horario obtenido
				reservation.setCode(rs.getInt("code"));
				reservation.setCityFrom((cityDao.getCitiesByIdRoute(rs.getInt("id_departure_route")).get("from")));
				reservation.setCityTo((cityDao.getCitiesByIdRoute(rs.getInt("id_departure_route")).get("to")));
				reservation.setPrice(rs.getDouble("price"));
				reservation.setDepartureDate(rs.getString("departure_date"));
				reservation.setReturnDate(rs.getString("return_date"));
				reservation.setOneWayTrip(rs.getBoolean("one_way_trip"));
				reservation.setDepartureTime(timeDao.getTimeById(rs.getInt("id_departure_time")));
				if (!reservation.isOneWayTrip())
					reservation.setReturnTime(timeDao.getTimeById(rs.getInt("id_return_time")));
				reservation.setNumberAdults(rs.getInt("number_adults"));
				reservation.setNumberDisables(rs.getInt("number_disables"));
				reservation.setNumberPets(rs.getInt("number_pets"));
				reservation.setNumberSeniors(rs.getInt("number_seniors"));
				reservation.setNumberStudents(rs.getInt("number_students"));
				reservation.setNumberYouths(rs.getInt("number_youths"));
				reservation.setExtraBaggage(rs.getBoolean("extra_baggage"));
				reservation.setPriorityBoarding(rs.getBoolean("priority_boarding"));
				reservation.setBike(rs.getBoolean("bike"));
				reservation.setInsurance(rs.getBoolean("insurance"));
				// Meter la reserva al vector
				System.out.println("[ReservationDAO] Reserva:" + reservation);
				resultado.add(reservation);
				System.out.println("[ReservationDAO] ArrayList Reserva:" + resultado);
				empty = false;
			}
			// Si no retorna nada de DB devolvemos null
			if (empty)
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		return resultado;
	
	}
}