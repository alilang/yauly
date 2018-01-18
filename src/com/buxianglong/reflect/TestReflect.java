package com.buxianglong.reflect;

import java.lang.reflect.Method;

public class TestReflect {

	public static void main(String[] args) throws Exception{
		 Class testClass = Class.forName("com.buxianglong.reflect.A");
		 Method method = testClass.getMethod("print");
		 method.invoke(testClass, null);
	}

}
