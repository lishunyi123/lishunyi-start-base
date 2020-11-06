package com.lishunyi.base.context;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/6 10:36
 **/
public class LsyContextHandler {

	private static final ThreadLocal<LsyRequestHeader> THREAD_LOCAL = new ThreadLocal<>();

	public static LsyRequestHeader getRequestHeader() {
		LsyRequestHeader lsyRequestHeader = THREAD_LOCAL.get();
		if (null == lsyRequestHeader) {
			lsyRequestHeader = new LsyRequestHeader();
			THREAD_LOCAL.set(lsyRequestHeader);
		}
		return lsyRequestHeader;
	}

	public static void setRequestHeader(LsyRequestHeader requestHeader) {
		THREAD_LOCAL.set(requestHeader);
	}

	public static void remove() {
		THREAD_LOCAL.remove();
	}
}
