package com.jt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest //SpringBoot的测试类
class SpringBootDemo2ApplicationTests {
	
	//spring容器中动态获取
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void findAll() {
		
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
	}
	
	// age<18 age>30
	@Test
	public void testFindAge() {
		
		List<User> userList = 
				userMapper.findByAge(18,30);
		System.out.println(userList);
	}
	
	
	/**
	 * 根据对象中不为null的属性查询
	 * sql: select * from user where id = 1 
	 * 	and age = 19;
	 */
	@Test
	public void testFindUser() {
		User user = new User();
		user.setAge(18);
		List<User> userList = 
				userMapper.findUser(user);
		System.out.println(userList);
	}
	
	
	@Test
	public void testDeleteUsers() {
		int[] ids = {53,54};
		userMapper.deleteUsers(ids);
	}
	
	
}
