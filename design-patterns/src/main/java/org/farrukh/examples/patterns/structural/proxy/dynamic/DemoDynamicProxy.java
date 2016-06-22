package org.farrukh.examples.patterns.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DemoDynamicProxy {

	public static void main(String[] args) {

		IMethods methods = (IMethods) Proxy.newProxyInstance(IMethods.class.getClassLoader(), new Class[] { IMethods.class }, new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (args != null) {
					for (int i = 0; i < args.length; i++) {
						System.out.println("\t" + args[i]);
					}
				}
				return null;
			}
		});
		System.out.println("about to call methodB");
		methods.methodB("hello");
		System.out.println("finish calling methodB");
		methods.methodA(47);
		methods.methodC(47, "hello");
	}

}
