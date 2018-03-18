package com.Uca.Finder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.finder.business.User;
import com.finder.controller.RequestAgencyAsyncTask;
import com.finder.controller.TestConnection;

import java.util.concurrent.ExecutionException;

public class SplashScreenActivity extends AbstractActivity implements RequestAgencyAsyncTask.LoadingTaskFinishedListener {

    private ProgressBar mProgress;
    private User user;
    private RequestAgencyAsyncTask task;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mProgress = findViewById(R.id.progressBar);
        mProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashScreenActivity.this, "Chargement...", Toast.LENGTH_LONG).show();
            }
        });
        final TestConnection test = new TestConnection(this);
        if(!test.isNetworkAvailable())
        {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showDialogConnection();
                }
            });
        }
        else{
            if (savedInstanceState == null)
            {
                task = new RequestAgencyAsyncTask(mProgress, this,this);
                task.execute();
            }
        }

    }
    @Override
    public void onTaskFinished(){
        completeSplash();
    }

    private void completeSplash()
    {
        try {
            user =task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        startApp();
        finish();
    }

    /**
     * lance l'activité de login avec l'utilisateur en cache s'il existe
     */
    private void startApp()
    {
        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
        if(user == null){
           user = new User("","");
        }
        i.putExtra("Id", user.getId());
        i.putExtra("Password", user.getPassword());
        startActivity(i);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }


    private void showMessageIfNoConnectionElseLoadApplication() {
        TestConnection test = new TestConnection(this);

            if(!test.isNetworkAvailable())
            {
                this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showDialogConnection();
                    }
                });
            }
            else
            {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
    }

    private void showDialogConnection() {
        Dialog d = new Dialog(this, "Problème Connexion", "Connectez vous et rééssayez.", false);
        alertDialog  = d.setPositiveButton("Rééssayer", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                showMessageIfNoConnectionElseLoadApplication();
            }
        }).setNegativeButton("Annuler", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                SplashScreenActivity.this.finish();
            }
        }).create();
        alertDialog.show();
    }
}
