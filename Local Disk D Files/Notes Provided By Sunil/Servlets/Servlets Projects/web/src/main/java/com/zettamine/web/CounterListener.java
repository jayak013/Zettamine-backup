package com.zettamine.web;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class CounterListener implements HttpSessionListener {
	public static int tc=0;
	public static int cc=0;
	public void sessionCreated(HttpSessionEvent se) {
		tc=tc+1;
		cc=cc+1;
		System.out.println("session created....");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		if(cc>0)
			cc = cc-1;	
		System.out.println("session destroyed....");
	}

}
