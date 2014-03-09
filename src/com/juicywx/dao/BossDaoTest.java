package com.juicywx.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.juicywx.beans.Boss;

public class BossDaoTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		BossDao boss =new BossDao();
		boss.updateBoss("123","456");
		assertEquals("123", boss.getBoss("123").getPassword());			
				
		
	}

}
