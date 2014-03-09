package com.juicywx.share;

import java.sql.Connection;

public class Jdbc {
	private static class Internal{
		private static Jdbc instance = new Jdbc();
	}
	private static SimpleConnectionPool pool;
	private Jdbc(){
		pool = new SimpleConnectionPool("jdbc:mysql://localhost:3306/juicywx","root","");
	}
	public static Jdbc getInstance(){
		return Internal.instance;
	}
	public  Connection open(){
		return pool.getConnection();
	}
	public void close(Connection connection){
		pool.pushConnectionBackToPool(connection);
	}
	
}
