package impl.miw.persistence.time;

import impl.miw.persistence.city.CityDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.City;
import com.miw.model.Time;
import com.miw.persistence.CityDataService;
import com.miw.persistence.TimeDataService;


/**
 * Clase que implementa las operaciones de acceso a la base de datos para la
 * entidad TIME.
 * 
 */
public class TimeDAO implements TimeDataService {
	/**
	 * Método que accede a la base de datos para obtener todas las ciudades
	 */
	public Vector<Time> getTimesByRoute(String cityFrom, String cityTo) throws Exception {
		
		// Inicializamos el Vector de retorno.
		Vector<Time> resultado = new Vector<Time>();
		CityDAO cityDao = new CityDAO();
		Integer idRoute = null;
		Double priceRoute = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			// Obtener el id de la ruta
			ps = con.prepareStatement("select id,price from route where id_from=? and id_to=?");
			ps.setInt(1, cityDao.getIdByCityName(cityFrom));
			ps.setInt(2, cityDao.getIdByCityName(cityTo));
			rs = ps.executeQuery();
			while (rs.next()) {
				// Guardamos el id de la ruta obtenida
				idRoute = rs.getInt("id");
				priceRoute = rs.getDouble("price");
			}
			
			// Obtener los horarios de la ruta
			ps = con.prepareStatement("select * from time where id_route=?");
			ps.setInt(1, idRoute);
			rs = ps.executeQuery();
			while (rs.next()) {
				Time time = new Time();
				time.setId(rs.getInt("id"));
				time.setIdRoute(rs.getInt("id_route"));
				time.setHourDeparture(rs.getInt("hour_departure"));
				time.setHourArrival(rs.getInt("hour_arrival"));
				time.setPrice(priceRoute);
				resultado.add(time);
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
	public Time getTimeById(Integer id) throws Exception {
		// Inicializamos el Vector de retorno.
		Time resultado = new Time();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/swebus";

			// Obtenemos la conexión a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "mvidalgarcia", "swebus");
			
			// Obtener el horario
			ps = con.prepareStatement("select * from time where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				// Guardamos el horario obtenido
				resultado.setId(rs.getInt("id"));
				resultado.setIdRoute(rs.getInt("id_route"));
				resultado.setHourDeparture(rs.getInt("hour_departure"));
				resultado.setHourArrival(rs.getInt("hour_arrival"));
			}
			ps = con.prepareStatement("select price from route where id=?");
			ps.setInt(1, resultado.getIdRoute());
			rs = ps.executeQuery();
			while (rs.next()) {
				// Guardamos el precio
				resultado.setPrice(rs.getDouble("price"));
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