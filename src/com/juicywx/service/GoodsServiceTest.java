package com.juicywx.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.juicywx.beans.Goods;

public class GoodsServiceTest {

	@Test
	public void test() {
		GoodsService gs = new GoodsService(2);
		List<Goods> list = null;
		list = gs.page(2);		
		assertEquals(3,list.get(0).getId());
	}

}
