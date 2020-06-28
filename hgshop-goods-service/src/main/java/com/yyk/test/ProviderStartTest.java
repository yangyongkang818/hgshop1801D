package com.yyk.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderStartTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.err.println("开始运行提供者");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml","classpath:applicationContext-dubbo-provider.xml");
		
		context.start();
		
		System.err.println("运行提供者完毕");
		
		System.in.read();
	}

}
