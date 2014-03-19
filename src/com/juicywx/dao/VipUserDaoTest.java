package com.juicywx.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.juicywx.beans.VipUser;

public class VipUserDaoTest {

	@Test
	public void test() throws SQLException {
		VipUserDao vud =new VipUserDao();
		VipUser vu = new VipUser();
		vu.setName("zh");
		vu.setSex(1);
		vu.setOpenId("2324dedwx");
		vu.setPoints(11);
		vu.setExchange(1);
		vu.setCreateTime(new Date());
		vu.setCity("changzhou");
		vu.setCheckOutMoney(123);
		vu.setVipNo("001");
		assertEquals(true,vud.addVipUser(vu));
	}

}
