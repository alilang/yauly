package com.buxianglong.loader;

public class LoaderTest {

	public static void main(String[] args)throws Exception {
		//String loader =Class.forName("java.lang.String").getClassLoader().toString();
		//System.out.println(loader);
//		ClassLoader cl = LoaderTest.class.getClassLoader();
//		cl.toString();
//		System.out.println(cl);
		Class a=Class.forName("java.lang.Runtime");
		a=LoaderTest.class;
		ClassLoader cl = a.getClassLoader();
		System.out.println(cl.toString());
		
		Object obj;

	}

}
