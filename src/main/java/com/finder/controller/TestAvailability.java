package com.finder.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import com.Uca.Finder.Dialog;

public class TestAvailability extends AsyncTask<String, String, Boolean> {
	
	
	private Activity activity;
	private AlertDialog alertDialog;

	public TestAvailability(Activity act) {
		this.activity =act;
	}

	@Override
	protected Boolean doInBackground(String... params)
	{
		Log.v("TestAvailability", "doInBackground");
		return showMessageIfNoConnectionElseLoadApplication();
	}
	

	private boolean showMessageIfNoConnectionElseLoadApplication() {
		TestConnection test = new TestConnection(activity);
		if(test.isNetworkAvailable())
		{
			return true;
		}
		else
		{
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					showDialogConnection();
				}
			});
			return false;
		}
	}
	
	private void showDialogConnection() {
		Dialog d = new Dialog(activity, "Problème Connexion", "Connectez vous et réessayez.", false);
		alertDialog  = d.setPositiveButton("Réessayer", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showMessageIfNoConnectionElseLoadApplication();
			}
		}).setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
				activity.finish();
			}
		}).create();
		alertDialog.show();
	}

}
