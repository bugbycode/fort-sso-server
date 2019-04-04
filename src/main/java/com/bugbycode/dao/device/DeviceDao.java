package com.bugbycode.dao.device;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.bugbycode.module.device.DeviceObj;

public interface DeviceDao {
	
	public List<DeviceObj> query(Map<String,Object> param,RowBounds rb);
	
	public int count(Map<String,Object> param);
	
	public List<String> queryAccount(int ruleId);
}
