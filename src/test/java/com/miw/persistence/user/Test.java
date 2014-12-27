package com.miw.persistence.user;

import impl.miw.persistence.user.UserDAO;

import com.miw.model.User;

public class Test {

	public static void main(String[] args) throws Exception {
		
		UserDAO udao = new UserDAO();
		
		/* IDENTIFICAR USUARIO */
		User u = new User();
		u.setEmail("monedero@podemos.es");
		u.setPassword("mypasswd");
		System.out.println("Se ha identificado? " + udao.isUser(u));
		
		/* REGISTRAR USUARIO */
		User monedero = new User();
		monedero.setFirstName("Juan Carlos");
		monedero.setLastName("Monedero");
		monedero.setEmail("monedero@podemos.es");
		monedero.setPhone(666666666);
		monedero.setGender("female");
		monedero.setAddress("Calle Podemista, 18329");
		monedero.setZipCode(0000);
		monedero.setCity("Madrit");
		monedero.setCounty("Chueca");
		monedero.setIdCard("019101920X");
		monedero.setPassword("monederoJC");
		System.out.println("Se ha registrado? " + udao.newUser(monedero));
	}

}
