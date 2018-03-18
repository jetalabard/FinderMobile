package com.finder.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Test if phone is connect to internet
 */
public class TestConnection
{
	/**
	 * parent activity
	 */
	private Activity activity;
	private AlertDialog alertDialog;


	/**
	 * constructor
	 * @param act
	 */
	public TestConnection(Activity act) {
		this.activity = act;
	}

	/**
	 * network is available ?
	 * @return
	 */
	public boolean isNetworkAvailable()
	{
		ConnectivityManager connectivityManager = (ConnectivityManager) this.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

}
