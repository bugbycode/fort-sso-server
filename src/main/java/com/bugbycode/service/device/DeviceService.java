package com.bugbycode.service.device;

import java.util.Map;

import com.bugbycode.module.device.DeviceObj;
import com.util.page.SearchResult;

public interface DeviceService {
	
	public SearchResult<DeviceObj> query(Map<String,Object> param,int startIndex,int pageSize);
	
}
