package com.bugbycode.dao.device.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.bugbycode.dao.base.BaseDao;
import com.bugbycode.dao.device.DeviceDao;
import com.bugbycode.module.device.DeviceObj;

@Repository("deviceDao")
public class DeviceDaoImpl extends BaseDao implements DeviceDao {

	@Override
	public List<DeviceObj> query(Map<String, Object> param, RowBounds rb) {
		return getSqlSession().selectList("sso.query", param, rb);
	}

	@Override
	public int count(Map<String, Object> param) {
		return getSqlSession().selectOne("sso.count", param);
	}

	@Override
	public List<String> queryAccount(int ruleId) {
		return getSqlSession().selectList("sso.queryAccount",ruleId);
	}

}
