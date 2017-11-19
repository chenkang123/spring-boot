package cn.timebusker.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Hacker implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
		arg3.invokeSuper(arg0, arg2);
		System.out.println("****  Oh,what a poor programmer.....");
		return null;
	}

}
