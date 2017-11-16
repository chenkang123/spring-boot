package cn.timebusker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.api.ApiService;

/**
 * 快速启动 spring-boot
 */
@RestController
public class HelloController {

	@Autowired
	private ApiService apiService;
	
	
	@RequestMapping("/hello")
	public String hello() {
		apiService.api("hello,api");
		return "hello";
	}
	
}
