package cn.timebusker.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		// 真实对象
		PlayService play = new HumanPlay();

		InvocationHandler handler = new PlayServiceHandler(play);

		PlayService proxy = (PlayService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
				play.getClass().getInterfaces(), handler);
		proxy.play();

	}

}
