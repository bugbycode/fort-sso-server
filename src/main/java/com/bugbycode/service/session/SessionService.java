package com.bugbycode.service.session;

import com.bugbycode.module.session.SsoSession;

public interface SessionService {

	public SsoSession query(int resId,String userName,String account);
	
	public SsoSession query(String randomId);
	
	public int insert(SsoSession session);
	
	public int delete(int id);
}
