package cn.timebusker.service;

import com.alibaba.api.ApiService;

public class ApiServiceImpl implements ApiService {

	@Override
	public void api(String message) {
		System.out.println("api"+message);
	}

}
