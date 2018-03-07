package fr.finder.controller;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.widget.ProgressBar;

import fr.finder.business.User;
import fr.finder.service.ImplementationService.ServiceCache;

/**
 * Created by jerem on 16/02/2018.
 */

public class RequestAgencyAsyncTask extends AsyncTask<String, Integer, User> {

    public interface LoadingTaskFinishedListener {
        void onTaskFinished(); // If you want to pass something back to the listener add a param to this method
    }

    private final ProgressBar progressBar;
    private final Activity activity;

    private final LoadingTaskFinishedListener finishedListener;

    /**
     * A Loading task that will load some resources that are necessary for the app to start
     * @param progressBar - the progress bar you want to update while the task is in progress
     * @param finishedListener - the listener that will be told when this task is finished
     */
    public RequestAgencyAsyncTask(ProgressBar progressBar, LoadingTaskFinishedListener finishedListener,Activity activity) {
        this.progressBar = progressBar;
        this.finishedListener = finishedListener;
        this.activity = activity;
    }

    @Override
    protected User doInBackground(String... params)
    {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ///recupère l'utilisateur en cache s'il existe
        return new ServiceCache(this.activity).getIdentity();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(User result) {
        super.onPostExecute(result);
        finishedListener.onTaskFinished();
    }

}
