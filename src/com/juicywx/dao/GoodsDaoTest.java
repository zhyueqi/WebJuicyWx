package com.juicywx.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.juicywx.beans.Goods;

public class GoodsDaoTest {

	// public void test() throws SQLException {
	// GoodsDao gd = new GoodsDao();
	// List<Goods> list = gd.goodsList();
	// assertEquals(1, list.size());
	// }
	@Test
	public void test() throws SQLException {
		GoodsDao gd = new GoodsDao();
		assertEquals(1, gd.goodsSize(GoodsDao.SALE_ON));
	}

	@Test
	public void test2() throws SQLException {
		GoodsDao gd = new GoodsDao();
		List<Goods> list = gd.goodsList(GoodsDao.SALE_ON, 0, 10);
		assertEquals(1, list.size());
	}

	@Test
	public void test3() throws SQLException {
		Goods goods = new Goods();
		GoodsDao gd = new GoodsDao();
		goods.setName("juice");
		goods.setPrice(6);
		goods.setWeight(1);
		goods.setSaleNo(2);
		goods.setBriefInfo("y");
		goods.setPicUrl("y");
		goods.setOnSale(1);
		gd.addGoods(goods);
		assertEquals("1",goods.getName());
	}
}
