package business;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dao.AbstractBaseDao;

public class Service {

	public static AbstractBaseDao createDao(Class<? extends AbstractBaseDao> type) {
		AbstractBaseDao baseDao = null;
		try {
			baseDao = (AbstractBaseDao) type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return baseDao;
	}

	public <T> T createProxy(Class<T> type) {

		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		};
		Proxy.newProxyInstance(type.getClassLoader(), new Class[] { type }, h);
		return null;
	}
}
