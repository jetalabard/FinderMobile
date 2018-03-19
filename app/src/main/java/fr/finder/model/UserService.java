package fr.finder.model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.finder.business.AgencyBDD;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;

/**
 * Created by Gilo on 17/03/2018.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("/login")
    Call<JSONObject> login(@Field("username") String username, @Field("password") String password);

    @GET("/agency")
    Call<ArrayList<AgencyBDD>> gets();
}
