package com.bugbycode.service.session.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugbycode.dao.session.SessionDao;
import com.bugbycode.module.session.SsoSession;
import com.bugbycode.service.session.SessionService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService{

	@Autowired
	private SessionDao sessionDao;
	
	@Override
	public SsoSession query(int resId, String userName, String account) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("resId", resId);
		param.put("userName", userName);
		param.put("account", account);
		return sessionDao.findOne(param);
	}

	@Override
	public SsoSession query(String randomId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("randomId", randomId);
		return sessionDao.findOne(param);
	}

	@Override
	public int insert(SsoSession session) {
		return sessionDao.insert(session);
	}

	@Override
	public int delete(int id) {
		return sessionDao.delete(id);
	}

}
