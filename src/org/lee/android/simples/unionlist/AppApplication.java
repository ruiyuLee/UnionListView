package org.lee.android.simples.unionlist;

import org.lee.android.volley.VolleyLoader;

import android.app.Application;

public class AppApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		VolleyLoader.initialize(this);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

}
