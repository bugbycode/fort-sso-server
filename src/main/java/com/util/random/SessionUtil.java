package com.util.random;

public class SessionUtil {
	
	private static final String rand = "ABBCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String random() {
		char[] arr = rand.toCharArray();
		int min = 0;
		int max = arr.length - 1;
		StringBuilder build = new StringBuilder();
		for(int index = 0;index < 10;index++) {
			int random = (int) (Math.random() * max - min + 1);
			build.append(arr[random]);
		}
		return build.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(random());
	}
}
