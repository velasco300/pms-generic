package com.zzz.pms.pmsgeneric.utils;

import com.zzz.pms.pmsgeneric.utils.Watch;

public class ThreadParam {

	private static final ThreadLocal<Watch> param = new ThreadLocal<Watch>();

	public static void set(Watch w) {
		param.set(w);
	}

	public static Watch get() {
		return param.get();
	}

	public static void remove() {
		param.remove();
	}

}
