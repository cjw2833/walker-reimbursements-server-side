package com.walker.enums;

public enum Options {
	LOGIN,
	CREATE,
	UPDATE,
	EMP,
	FM,
	BASE,
	NOT_FOUND;
	
	public static Options getOptions(String str) {
		System.out.println(str);
		if (str == null) return BASE;
		
		for(Options opt : Options.values()) {
			if(str.toUpperCase().equals(opt.name())) {
				return opt;
			}
		}
		return NOT_FOUND;
	}
}
