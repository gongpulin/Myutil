package com.gpl.reflect;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

public class Spring {

	public static Object invoke(String className, String methodName,
			Object[] args) {

		Object obj = null;

		try {

			Class clazz = Class.forName(className);

			// 根据类的名称实例化一个类

			Method[] methods = clazz.getMethods();

			// 获取类的所有方法

			for (Method m : methods) {

				// 和传入的方法名进行对比，找到相应的方法

				if (m.getName().equals(methodName)) {

					// 找到方法 方法反射调用

					obj = m.invoke(clazz.newInstance(), args);

				}

			}

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IllegalArgumentException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (InvocationTargetException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (InstantiationException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return obj;

	}

}
