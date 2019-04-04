package com.bugbycode.controller.session;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bugbycode.module.session.SsoSession;
import com.bugbycode.service.session.SessionService;
import com.util.random.SessionUtil;

@Controller
@RequestMapping("/session")
public class SessionController {

	@Autowired
	private SessionService sessionService;
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(int resId,String account) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		JSONObject json = new JSONObject();
		int code = 0;
		String msg = "新建成功";
		SsoSession session = new SsoSession();
		try {
			String random = SessionUtil.random();
			while(true) {
				SsoSession tmp = sessionService.query(random);
				if(tmp == null) {
					break;
				}
				random = SessionUtil.random();
			}
			session.setResId(resId);
			session.setAccount(account);
			session.setUserName(userName);
			session.setCreateTime(new Date());
			session.setRandomId(random);
			SsoSession s = sessionService.query(resId, userName, account);
			if(s != null) {
				sessionService.delete(s.getId());
			}
			sessionService.insert(session);
		}catch (Exception e) {
			code = 1;
			msg = e.getMessage();
		}
		json.put("msg", msg);
		json.put("random", session.getRandomId());
		json.put("code", code);
		return json.toString();
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String query(String random) {
		JSONObject json = new JSONObject();
		SsoSession s = sessionService.query(random);
		json.put("data", s);
		return json.toString();
	}
}
