package com.juicywx.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.juicywx.beans.Goods;
import com.juicywx.share.Jdbc;

public class GoodsDao {
	public static final int SALE_ON = 1;
	public static final int SALE_OFF = 0;

	public int goodsSize(int onSale) throws SQLException {

		Connection connection = Jdbc.getInstance().open();
		Statement stat = connection.createStatement();

		String sql = "SELECT `id`, `name`, `price`, `weight`, `saleNo`, `briefInfo`, `picUrl`, `onSale` FROM `goods` WHERE `onSale`='"
				+ onSale + "'";

		ResultSet result = stat.executeQuery(sql);

		int temp;
		result.last();
		temp = result.getRow();
		Jdbc.getInstance().close(connection);

		return temp;

	}

	public List<Goods> goodsList(int onSale, int start, int length)
			throws SQLException {
		Connection connection = Jdbc.getInstance().open();
		Statement stat = connection.createStatement();

		String sql = "SELECT `id`, `name`, `price`, `weight`, `saleNo`, `briefInfo`, `picUrl`, `onSale` FROM `goods` WHERE `onSale`='"
				+ onSale + "' limit " + start + "," + length + "";

		ResultSet result = stat.executeQuery(sql);

		Goods goods = null;
		List<Goods> list = new LinkedList<>();

		while (result.next()) {
			goods = new Goods();
			list.add(goods);
			goods.setId(result.getInt(1));
			goods.setName(result.getString(2));
			goods.setPrice(result.getInt(3));
			goods.setWeight(result.getInt(4));
			goods.setSaleNo(result.getInt(5));
			goods.setBriefInfo(result.getString(6));
			goods.setPicUrl(result.getString(7));
			goods.setOnSale(result.getInt(8));
		}
		Jdbc.getInstance().close(connection);
		return list;
	}

	public boolean addGoods(Goods goods) throws SQLException {
		Connection connection = Jdbc.getInstance().open();
		Statement stat = connection.createStatement();
		String sql = "insert into goods (`id`,`name`,`price`,`weight`,`saleNo`,`briefInfo`,`picUrl`,`onSale`) values (NULL,'"
				+ goods.getName()
				+ "','"
				+ goods.getPrice()
				+ "','"
				+ goods.getWeight()
				+ "','"
				+ goods.getSaleNo()
				+ "','"
				+ goods.getBriefInfo()
				+ "','"
				+ goods.getPicUrl()
				+ "','"
				+ goods.getOnSale() + "')";

		Boolean result = stat.execute(sql);
		if (stat.getUpdateCount() > 0)
			result = true;
		else
			result = false;
		Jdbc.getInstance().close(connection);
		return result;

	}

}
