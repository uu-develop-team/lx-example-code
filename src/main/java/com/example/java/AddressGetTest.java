package com.example.java;

import java.net.InetAddress;

public class AddressGetTest {

	public static void main(String[] args) throws Exception {
		InetAddress ia = InetAddress.getByName("www.baidu.com");
		InetAddress ia1 = InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress());
		System.out.println(ia1.getHostName());
	}
}
