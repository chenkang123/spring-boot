package cn.timebusker.service;

import org.springframework.stereotype.Service;

import com.alibaba.api.ApiService;

@Service("HelloWorldService")
public class ApiServiceImpl implements ApiService {

	@Override
	public void api(String message) {
		System.out.println("api"+message);
	}

}
