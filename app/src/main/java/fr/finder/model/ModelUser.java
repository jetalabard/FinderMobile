package fr.finder.model;


import okhttp3.Headers;
import retrofit2.Response;
import retrofit2.Call;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;


public class ModelUser extends Model {

    public ModelUser() {

        webservice = getClient();

    }

    public boolean verify(String mail, String password) throws IOException {

        Call<JSONObject> call = webservice.login(mail, password);
        retrofit2.Response<JSONObject> resp = call.execute();
        if (resp.isSuccessful()){
            cookieSession = resp.headers().get("Set-Cookie");
            return true;
        }
        return false;
    }

}