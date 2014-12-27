package impl.miw.persistence.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.User;
import com.miw.persistence.UserDataService;

/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad USER.
 * 
 */
public class UserDAO implements UserDataService {
	/**
	 * M�todo que accede a la base de datos para recuerar la lista de libros
	 * presentes en la base de datos.
	 */
	public boolean isUser(User user) throws Exception {
		/*
		// Inicializamos el Vector de retorno.
		Vector<Book> resultado = new Vector<Book>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "dflanvin", "amazin");

			ps = con.prepareStatement("select * from libro");
			rs = ps.executeQuery();

			while (rs.next()) {
				// Completamos los datos del Libro en la entidad
				Book libro = new Book();
				libro.setId(rs.getInt("id"));
				libro.setTitle(rs.getString("titulo"));
				libro.setDescription(rs.getString("descripcion"));
				libro.setAuthor(rs.getString("autor"));
				libro.setFamily(rs.getInt("familia"));
				libro.setBasePrice(rs.getDouble("precioBase"));
				// La a�adimos al Vector de resultado
				resultado.add(libro);
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
		// Retornamos el vector de resultado.
		return resultado;
		*/
		return false;
	}

	public synchronized User newUser(User user) throws Exception {
/*
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "dflanvin", "amazin");

			ps = con.prepareStatement("select max(id) as maximo from libro");
			rs = ps.executeQuery();
			Integer id=0;
			while (rs.next()) {
				 id = rs.getInt("maximo");
			}
			
			System.out.println("M�ximo id encontrado: "+id);
			
			book.setId(id);
			//Creamos el libro
			ps = con.prepareStatement("insert into libro values (?,?,?,?,?,?)");
			ps.setInt(1, id+1);
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getDescription());
			ps.setString(4, book.getAuthor());
			ps.setInt(5, book.getFamily());
			ps.setDouble(6,  book.getBasePrice());
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
		*/
		// Retornamos el vector de resultado.
		return user;
	}

}