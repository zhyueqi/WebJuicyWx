package com.juicywx.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.juicywx.beans.VipUser;
import com.juicywx.share.Jdbc;

public class VipUserDao {
	public boolean addVipUser(VipUser vu) throws SQLException {
		Connection connection = Jdbc.getInstance().open();
		Statement stat = connection.createStatement();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO `vipuser`(`id`, `vipNo`, `openId`, `name`, `sex`, `city`, `points`, `createTime`, `exchange`, `checkOutMoney`) VALUES ");
		sqlBuilder.append("(");
		sqlBuilder.append("NULL");
		catValue(sqlBuilder, vu.getVipNo());
		catValue(sqlBuilder, vu.getOpenId());
		catValue(sqlBuilder, vu.getName());
		catValue(sqlBuilder, vu.getSex() + "");
		catValue(sqlBuilder, vu.getCity());
		catValue(sqlBuilder, vu.getPoints() + "");
		catValue(sqlBuilder, dateToString(vu.getCreateTime()));
		catValue(sqlBuilder, vu.getExchange() + "");
		catValue(sqlBuilder, vu.getCheckOutMoney() + "");
		sqlBuilder.append(")");

		Boolean result = false;
		stat.execute(sqlBuilder.toString());
		if (stat.getUpdateCount() > 0) {
			result = true;
		}
		Jdbc.getInstance().close(connection);

		return result;
	}

	public List<VipUser> getList() {

		return null;
	}

	private void catValue(StringBuilder builder, String piece) {
		builder.append(",'");
		builder.append(piece);
		builder.append("'");
	}

	/**
	 * java.util.Date 'yyyy-MM-dd HH:mm:ss' 24 hours <br>
	 * Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
	 * 
	 * @param Date
	 * @return String
	 */

	public static String dateToString(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = formatter.format(time);
		return ctime;
	}

	/**
	 * 'yyyy-MM-dd HH:mm:ss' 24 hours <br>
	 * cast '2002-05-11 17:24:21' to Date Object
	 * 
	 * @param String
	 * @return java.util.Date
	 */
	public static Date StringToDate(String time) throws ParseException {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ctime = formatter.parse(time);
		return ctime;
	}
}
