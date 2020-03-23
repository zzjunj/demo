package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
	
	private Integer status;	//状态信息 200正常  201失败
	private String msg;		//服务器通知客户端的信息
	private Object data;	//服务器返回的数据
}
