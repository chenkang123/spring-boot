package cn.timebusker.jdkproxy;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.aopalliance.intercept.Invocation;

public class PlayServiceHandler implements InvocationHandler {

	// 被代理的对象
	private PlayService playService;

	public PlayServiceHandler(PlayService playService) {
		super();
		this.playService = playService;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		method.invoke(playService, args);

		return null;
	}

}
