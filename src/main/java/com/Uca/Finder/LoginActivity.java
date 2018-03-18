package com.Uca.Finder;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.finder.business.User;
import com.finder.service.Cache.ServiceCache;
import com.finder.service.Facade.ServiceFacade;

import java.io.IOException;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AbstractActivity
{
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

        String username;
        String password;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                username= "";
                password = "";
            } else {
                username= extras.getString("Id");
                password= extras.getString("Password");
            }
        } else
            {
                username= (String) savedInstanceState.getSerializable("Id");
                password= (String) savedInstanceState.getSerializable("Password");
        }
        editPassword.setText(password);
        editUsername.setText(username);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = editUsername.getText().toString();
                final String password = editPassword.getText().toString();
                new AsyncTask<Void, Void, Void>(){

                    boolean isUser;

                    @Override
                    protected Void doInBackground(Void[] params) {

                        try {
                            isUser = new ServiceFacade(LoginActivity.this).verify(username,password);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(isUser){
                            //save valid user in cache
                            new ServiceCache(LoginActivity.this).addIdentity(new User(username,password));
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

