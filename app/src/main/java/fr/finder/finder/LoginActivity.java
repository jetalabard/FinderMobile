package fr.finder.finder;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.finder.business.Agency;
import fr.finder.business.AgencyBDD;
import fr.finder.model.ModelAgency;
import fr.finder.model.ModelUser;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {
    EditText editUsername;
    EditText editPassword;
    Button btnLogin;
    private Context context;
    ArrayList<AgencyBDD> getsAgency;


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
                            new AsyncTask<Void, Void, Void>(){

                                ModelAgency modelAgency = new ModelAgency();
                                AgencyBDD agencyBDD;

                                @Override
                                protected Void doInBackground(Void[] params) {

                                    getsAgency = modelAgency.gets();
                                    for(int i=0; i<getsAgency.size(); i++) {
                                        agencyBDD = getsAgency.get(i);
                                        System.out.println(agencyBDD.get_id());
                                    }
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(Void aVoid) {
                                    Bundle data = new Bundle();
                                    data.putParcelableArrayList("search.resultSet", getsAgency);
                                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                                    intent.putExtra("agencies", getsAgency);
                                    startActivity(intent);
                                }
                            }.execute();


                        }

                    }

                }.execute();
            }
        });
    }


}

/*

ModelAgency modelAgency = new ModelAgency();
String getsAgency;
@Override
                                protected Void doInBackground(Void[] params) {

                                    getsAgency = modelAgency.gets();
                                    try {
                                        JSONArray jsnobject = new JSONArray(getsAgency);
                                        for(int i=0; i<jsnobject.length(); i++) {
                                            JSONObject agency = jsnobject.getJSONObject(i);
                                            JSONObject item = agency.getJSONObject("_id");
                                            System.out.println(item.toString());

                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
 */