package com.bugbycode.dao.session.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bugbycode.dao.base.BaseDao;
import com.bugbycode.dao.session.SessionDao;
import com.bugbycode.module.session.SsoSession;

@Repository("sessionDao")
public class SessionDaoImpl extends BaseDao implements SessionDao {

	@Override
	public SsoSession findOne(Map<String, Object> param) {
		return getSqlSession().selectOne("session.findOne", param);
	}

	@Override
	public int insert(SsoSession session) {
		return getSqlSession().insert("session.insert", session);
	}

	@Override
	public int delete(int id) {
		return getSqlSession().delete("session.delete", id);
	}

}
