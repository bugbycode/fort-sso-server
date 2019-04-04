package com.bugbycode.controller.device;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bugbycode.module.device.DeviceObj;
import com.bugbycode.service.device.DeviceService;
import com.util.StringUtil;
import com.util.page.SearchResult;

@Controller
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/query")
	@ResponseBody
	public String query(
			@RequestParam(name="keyword",defaultValue="")
			String keyWord,
			@RequestParam(name="startIndex",defaultValue="-1")
			int startIndex,
			@RequestParam(name="pageSize",defaultValue="10")
			int pageSize) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		JSONObject json = new JSONObject();
		Map<String,Object> param = new HashMap<String,Object>();
		if(StringUtil.isNotBlank(keyWord)) {
			param.put("keyword", keyWord);
		}
		param.put("userName", userName);
		SearchResult<DeviceObj> sr = deviceService.query(param, startIndex, pageSize);
		json.put("data", sr.getList());
		json.put("page", sr.getPage());
		return json.toString();
	}
}
