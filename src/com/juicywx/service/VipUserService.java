package com.juicywx.service;

import com.juicywx.beans.VipUser;

public class VipUserService {
	public void registVip(String openId){
		VipUser vuser  = new VipUser();
		vuser.setOpenId(openId);
		
	}
}
