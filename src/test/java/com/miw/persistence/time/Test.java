package com.miw.persistence.time;

import java.util.Vector;
import impl.miw.persistence.time.TimeDAO;
import com.miw.model.Time;

public class Test {

	public static void main(String[] args) throws Exception {
		
		TimeDAO timeDao = new TimeDAO();
		
		/* OBTENER HORARIOS DE UNA RUTA */
		Vector<Time> resultados = new Vector<Time>();
		resultados = timeDao.getTimesByRoute("Linkoping", "Malmo");
		System.out.println("Horarios Linkoping-Malmo");
		for(Time res : resultados){
			System.out.println(res);
		}
		resultados = timeDao.getTimesByRoute("Malmo", "Stockholm");
		System.out.println("Horarios Malmo-Stockholm");
		for(Time res : resultados){
			System.out.println(res);
		}
		System.out.println("------");
		/* OBTENER HORARIO A PARTIR DEL ID */
		Time resultado = new Time();
		resultado = timeDao.getTimeById(16);
		System.out.println(resultado);
		resultado = timeDao.getTimeById(1);
		System.out.println(resultado);
		resultado = timeDao.getTimeById(22);
		System.out.println(resultado);
	}

}
