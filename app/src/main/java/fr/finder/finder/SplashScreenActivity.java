package fr.finder.finder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import fr.finder.business.User;
import fr.finder.controller.RequestAgencyAsyncTask;

public class SplashScreenActivity extends Activity implements RequestAgencyAsyncTask.LoadingTaskFinishedListener {

    private ProgressBar mProgress;
    private User user;
    private RequestAgencyAsyncTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashScreenActivity.this, "Chargement...", Toast.LENGTH_LONG).show();
            }
        });
        if (savedInstanceState == null) {
                task = new RequestAgencyAsyncTask(mProgress, this,this);
                        task.execute();
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

    private void startApp() {
        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
        if(user == null){
           user = new User("","");
        }
        i.putExtra("Id", user.getId());
        i.putExtra("Password", user.getPassword());
        startActivity(i);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
