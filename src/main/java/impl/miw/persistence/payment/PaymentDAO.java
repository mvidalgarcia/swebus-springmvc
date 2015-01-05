package impl.miw.persistence.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.Payment;
import com.miw.persistence.PaymentDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad PAYMENT.
 * 
 */
public class PaymentDAO implements PaymentDataService {
	
	@SuppressWarnings("resource")
	public Integer newPayment(Payment payment) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Integer idPayment=null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			//Creamos el usuario
			ps = con.prepareStatement("insert into payment(type,card_number,username,pin_code,email,mobile) "
					+ "values (?,?,?,?,?,?)");
			ps.setString(1, payment.getType());
			ps.setLong(2, payment.getCardNumber());
			ps.setString(3, payment.getUserName());
			if (payment.getPinCode() == null)
				ps.setInt(4, -1);
			else
				ps.setInt(4, payment.getPinCode());
			ps.setString(5, payment.getEmail());
			if (payment.getMobile() == null)
				ps.setInt(6,  -1);
			else
				ps.setInt(6,  payment.getMobile());
			ps.executeUpdate();
			
			
			//Obtener ID del pago que se acaba de meter en BD
			ps = con.prepareStatement("select max(id) as maximo from payment");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 idPayment = rs.getInt("maximo");
			}
			System.out.println("[PaymentDAO] Registrado nuevo pago id="+idPayment+": " + payment);		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("[PaymentDAO] Se ha producido un error al registrar el pago: " + payment);
			throw (e);
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		// Retornamos el id del pago
		return idPayment;
	}

}