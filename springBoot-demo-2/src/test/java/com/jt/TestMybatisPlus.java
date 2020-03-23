package com.jt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest
public class TestMybatisPlus {

	@Autowired
	private UserMapper userMapper;

	/**
	 *规则:自己的Mapper方法 不要与MP中的接口重名
	 * 查询练习
	 * 1.根据用户名查询数据.
	 */
	@Test
	public void test01() {
		User user = new User();
		user.setName("如花");  //=判断

		//条件构造器  将对象中不为null的属性当做where条件
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<User>(user);
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	//查询女性用户,并且是人类  age>0 and age<150
	@Test
	public void test02() {
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.eq("sex", "女")
		.gt("age", 0)
		.lt("age", 150);
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	@Test
	public void test03() {
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.eq("sex", "女")
		.between("age", 0, 150);
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	@Test
	public void testIn() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.in("id",ids);
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	//测试name属性为null的元素
	@Test
	public void testNull() {
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.isNull("name");
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	//测试name 属性包含精的送给你当老婆
	@Test
	public void testLike() {
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.like("name", "精")
		.eq("sex", "女");
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	//测试排序  默认是升序  要求按照age降序
	@Test
	public void testOrderBy() {
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.orderByDesc("age");
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}


	/**
	 * 要求:
	 * 	年龄: age>18 and sex=女 or 女神仙
	 */
	@Test
	public void testOR() {
		QueryWrapper<User> queryWrapper = 
				new QueryWrapper<>();
		queryWrapper.gt("age", 18)
		.eq("sex", "女")
		.or()
		.eq("sex", "女")
		.gt("age", 150);
		List<User> userList = 
				userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}

	//修改操作  55号数据
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(55)
		.setName("苏妲己")
		.setSex("女")
		.setAge(18);
		//只有id当where条件,其他属性当set条件
		userMapper.updateById(user);
	}

	//修改操作  name为null的元素 改为范爷
	@Test
	public void testUpdate2() {
		//entity: 要修改的数据
		User user = new User();
		user.setName("范冰冰")
			.setAge(18)
			.setSex("女");
		
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.isNull("name");
		userMapper.update(user, updateWrapper);
		
	}






}
