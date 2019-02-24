package com.walker.util;

public class UriUtility {
	
	public static String getEndpoint(String uri) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("uri:  " + uri);
		
		String[] strings = uri.split("/");
			System.out.println("split:  " + strings);
		int lastIndex = strings.length-1;
			System.out.println("lastIndex");
		System.out.println(strings[lastIndex]);
		return strings[lastIndex];
	}
}
