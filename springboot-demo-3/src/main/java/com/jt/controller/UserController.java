package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.SysResult;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询user列表数据.userList.jsp页面展现
	 * 页面取值:${userList}
	 * jsp四大作用域:  page域  request域 Session域 application域
	 * 	
	 * 
	 */
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "userList";
	}
	
	
	//跳转到ajax页面
	@RequestMapping("/ajax")
	public String ajax() {
		
		return "ajax";
	}
	
	//接收ajax请求  http://localhost:8090/findAjaxUser
	//为了和js交互性更好 需要添加系统级的VO对象
	@RequestMapping("findAjaxUser")
	@ResponseBody
	public SysResult findAjaxList(){
		try {
			List<User> userList = userService.findAll();
			return new SysResult(200, "服务器处理正确", userList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new SysResult(201, "系统正在维护,请稍后重试!!!(大SB别等了,后台错了!!!)", null);
		}
	}
	
	
	
	
	
	
}
