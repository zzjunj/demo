package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;
//@Mapper	//将接口交给spring容器管理 代理对象
public interface UserMapper extends BaseMapper<User>{
	
	List<User> findAll();

	List<User> findByAge(int minAge, int maxAge);

	List<User> findUser(User user);
	
	void deleteUsers(int[] ids);
	
	
	
	
	
}
