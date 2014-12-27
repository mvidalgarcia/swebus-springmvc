package impl.miw.persistence.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.miw.model.User;
import com.miw.persistence.UserDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad USER.
 * 
 */
public class UserDAO implements UserDataService {
	/**
	 * Método que accede a la base de datos para comprobar las credenciales del usuario
	 * que se está identificando en el sistema.
	 */
	public boolean isUser(User user) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");

			ps = con.prepareStatement("select email, password from user where email=?");
			ps.setString(1, user.getEmail());
			rs = ps.executeQuery();
			while (rs.next()) {
				// Comprobamos si coinciden las passwords
				if (user.getPassword().equals(rs.getString("password"))){
					System.out.println("Usuario con email: "+ user.getEmail() + " se ha identificado.");
					return true;
				}
				else
					System.out.println("Usuario con email: "+ user.getEmail() + ", no coincide la pass.");
					return false;
			}

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
		// De otro modo, es que no coincice la password o que el usuario con ese email no existe.
		System.out.println("No existe usuario con email: "+ user.getEmail());
		return false;
	}

	public synchronized boolean newUser(User user) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			//Creamos el usuario
			ps = con.prepareStatement("insert into user(firstname,lastname,email,phone,gender,address,zipcode,"
					+ "city,county,idcard,password) values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getPhone());
			ps.setString(5, user.getGender());
			ps.setString(6,  user.getAddress());
			ps.setInt(7,  user.getZipCode());
			ps.setString(8,  user.getCity());
			ps.setString(9,  user.getCounty());
			ps.setString(10,  user.getIdCard());
			ps.setString(11,  user.getPassword());
			ps.executeUpdate();
			System.out.println("Registrado nuevo usuario: " + user);

		}
		catch (SQLException e) {
			System.out.println("No se ha registrado el usuario porque el email: " + user.getEmail() + " ya existe.");
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Se ha producido un erro al registrar el usuario: " + user);
			throw (e);
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		// Retornamos verdadero
		return true;
	}

}