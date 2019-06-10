package com.wc;

public class WatchDogNative {
	static
	{
		System.loadLibrary("watchdog");
	}
	public final static native boolean closedev();
	public final static native boolean opendev();
}
