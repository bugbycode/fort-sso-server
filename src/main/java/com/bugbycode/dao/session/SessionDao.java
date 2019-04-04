package com.bugbycode.dao.session;

import java.util.Map;

import com.bugbycode.module.session.SsoSession;

public interface SessionDao {

	public SsoSession findOne(Map<String,Object> param);
	
	public int insert(SsoSession session);
	
	public int delete(int id);
}
