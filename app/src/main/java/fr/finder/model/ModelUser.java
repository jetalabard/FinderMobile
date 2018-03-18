package fr.finder.model;


import retrofit2.Call;


import org.json.JSONObject;

import java.io.IOException;


public class ModelUser extends Model {

    public ModelUser() {

        webservice = getClient();

    }

    public boolean verify(String mail, String password) throws IOException {

        Call<JSONObject> call = webservice.login(mail, password);

        return call.execute().isSuccessful();

    }


}