package fr.finder.finder;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import fr.finder.model.ModelUser;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {
    EditText editUsername;
    EditText editPassword;
    Button btnLogin;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUsername = (EditText)findViewById(R.id.editUsername);
        editPassword = (EditText)findViewById(R.id.editPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        context = this;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = editUsername.getText().toString();
                final String password = editPassword.getText().toString();
                new AsyncTask<Void, Void, Void>(){

                    boolean isUser;
                    ModelUser modelUser = new ModelUser();

                    @Override
                    protected Void doInBackground(Void[] params) {

                        try {
                            isUser = modelUser.verify(username, password);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return null;

                    }

                    @Override
                    protected void onPostExecute(Void result) {

                        if (isUser == false) {

                            Toast.makeText(context, "Login ou mot de passe incorrect", Toast.LENGTH_LONG).show();

                        }
                        else {

                            // add session
                            Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                            startActivity(intent);

                        }

                    }

                }.execute();
            }
        });
    }


}

