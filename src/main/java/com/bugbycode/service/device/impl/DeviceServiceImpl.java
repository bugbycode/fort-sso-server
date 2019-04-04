package com.bugbycode.service.device.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugbycode.dao.device.DeviceDao;
import com.bugbycode.module.device.DeviceObj;
import com.bugbycode.service.device.DeviceService;
import com.util.page.Page;
import com.util.page.SearchResult;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDao deviceDao;
	
	@Override
	public SearchResult<DeviceObj> query(Map<String, Object> param, int startIndex, int pageSize) {
		SearchResult<DeviceObj> sr = new SearchResult<DeviceObj>();
		int totalCount = deviceDao.count(param);
		Page page = new Page(pageSize, startIndex);
		page.setTotalCount(totalCount);
		List<DeviceObj> list = new ArrayList<DeviceObj>();
		if(totalCount > 0) {
			RowBounds rb = new RowBounds(page.getStartIndex(), page.getPageSize());
			list.addAll(deviceDao.query(param, rb));
			for(DeviceObj device : list) {
				Set<String> accSet = new HashSet<String>();
				accSet.addAll(deviceDao.queryAccount(device.getRuleId()));
				device.setAccountList(accSet);
			}
		}
		sr.setList(list);
		sr.setPage(page);
		return sr;
	}

}
