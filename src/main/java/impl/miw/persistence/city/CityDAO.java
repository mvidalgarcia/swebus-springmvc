package impl.miw.persistence.city;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import com.miw.model.City;
import com.miw.persistence.CityDataService;


/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad CITY.
 * 
 */
public class CityDAO implements CityDataService {
	/**
	 * Método que accede a la base de datos para obtener todas las ciudades
	 */
	public Vector<City> getCities() throws Exception {
		// Inicializamos el Vector de retorno.
		Vector<City> resultado = new Vector<City>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");

			ps = con.prepareStatement("select * from city");
			rs = ps.executeQuery();
			while (rs.next()) {
				// Completamos los datos de la ciudad en la entidad
				City city = new City(rs.getInt("id"), rs.getString("name"));
				resultado.add(city);
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
		return resultado;
	}

	@Override
	public Integer getIdByCityName(String cityName) throws Exception {
		Integer resultado = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");

			ps = con.prepareStatement("select id from city where name=?");
			ps.setString(1, cityName);
			rs = ps.executeQuery();
			while (rs.next()) {
				resultado = rs.getInt("id");
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
		return resultado;
	}

	@SuppressWarnings({ "resource"})
	@Override
	public HashMap<String, String> getCitiesByIdRoute(Integer idRoute) throws Exception {
		HashMap<String, String> resultado = new HashMap<String, String>() ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");

			ps = con.prepareStatement("select id_from, id_to from route where id=?");
			ps.setInt(1, idRoute);
			rs = ps.executeQuery();
			Integer idCityFrom = null,idCityTo = null;
			while (rs.next()) {
				idCityFrom = rs.getInt("id_from");
				idCityTo = rs.getInt("id_to");
			}			
			// Obtener ciudad de origen
			ps = con.prepareStatement("select name from city where id=?");
			ps.setInt(1, idCityFrom);
			rs = ps.executeQuery();
			while (rs.next()) {
				//System.out.println("[CityDAO] city_from:"+rs.getString("name"));
				resultado.put("from", rs.getString("name"));
			}
			
			// Obtener ciudad de destino
			ps = con.prepareStatement("select name from city where id=?");
			ps.setInt(1, idCityTo);
			rs = ps.executeQuery();
			while (rs.next()) {
				resultado.put("to", rs.getString("name"));
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
		return resultado;
	}
	
	


}