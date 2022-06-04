package com.cracker.cookie;

import java.util.UUID;

import org.junit.Test;

/**
 * 随机字符串
 *
 */
public class UUIDTest {
	
	@Test
	public void test() {
		UUID uuid = UUID.randomUUID();
		String string = uuid.toString();
		String all = string.replaceAll("-", "");
		System.out.println(all);
	}
}
