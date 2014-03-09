package com.juicywx.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.ui.ModelMap;

import com.juicywx.beans.Boss;
import com.juicywx.share.Jdbc;

public class BossDao {
public Boss getBoss(String name) throws SQLException, ClassNotFoundException{
	    Boss boss= new Boss();

		Connection connection = Jdbc.getInstance().open();
		Statement stat =  connection.createStatement();

		String sql = "select id,name,password from boss where `name` = '"+ name + "'";

		ResultSet result = stat.executeQuery(sql);
		
		if (result.next()) {
			int user_id = result.getInt("id");
			String user_name = result.getString("name");
			String user_pass = result.getString("password");
			boss.setId(user_id) ;
			boss.setName(user_name);
			boss.setPassword(user_pass);
			
		}
		Jdbc.getInstance().close(connection);
		return boss;
		
	}
public boolean  insBoss(String name,String password) throws SQLException, ClassNotFoundException{
	
	Connection connection = Jdbc.getInstance().open();
	Statement stat =  connection.createStatement();

	String sql = "insert into boss (`id`,`name`,`password`) values (NULL,'"+name+"','"+password+"')";

	Boolean result= stat.execute(sql);
	if(stat.getUpdateCount()>0)
		result=true;
	else
		result=false;
	Jdbc.getInstance().close(connection);
	return result;
	}

public boolean  updateBoss(String name,String password) throws SQLException, ClassNotFoundException{
	
	Connection connection = Jdbc.getInstance().open();
	Statement stat =  connection.createStatement();

	String sql = "UPDATE `boss` SET `password`='"+password+"' WHERE `name` = '"+ name + "'";

	int result= stat.executeUpdate(sql);
	Jdbc.getInstance().close(connection);
	boolean updateres;
	if(stat.getUpdateCount()>0)
		updateres = true;
	else
		updateres = false;
	Jdbc.getInstance().close(connection);
	return updateres;
		}
	
	
}


