package com.juicywx.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juicywx.share.Jdbc;

@Controller
public class WxImp {
	@RequestMapping("/helloWorld")
	public String login(String name,ModelMap model) throws SQLException, ClassNotFoundException{

		Connection connection = Jdbc.getInstance().open();
		Statement stat =  connection.createStatement();

		String sql = "select id,name,password from boss where `name` = '"+ name + "'";

		ResultSet result = stat.executeQuery(sql);
		// get rows length
		// result.last();
		// int length = result.getRow();
		// result.first();

		while (result.next()) {
			int user_id = result.getInt("user_id");
			String user_name = result.getString("user_name");
			String user_pass = result.getString("user_pass");
			model.addAttribute("user_id", user_id);
			model.addAttribute("user_name", user_name);
			model.addAttribute("user_pass", user_pass);

		}
		Jdbc.getInstance().close(connection);
		return "helloWorld";
	}
}
