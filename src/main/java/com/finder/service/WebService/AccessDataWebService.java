package com.finder.service.WebService;

import com.finder.business.Agency;
import com.finder.business.Collaborator;
import com.finder.business.Pole;
import com.finder.business.Project;
import com.finder.model.IWebServiceUser;
import com.finder.model.WebServiceModel;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;


/**
 * Created by jerem on 06/03/2018.
 */

public class AccessDataWebService extends WebServiceModel implements IAccessData
{
    private IWebServiceUser userWebService;

    public AccessDataWebService()
    {
        WebServiceModel model = new WebServiceModel();
        userWebService = model.getUser();
    }

    @Override
    public List<Agency> getAgencies() {
        return null;
    }

    @Override
    public List<Pole> getPoles() {
        return null;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public List<Collaborator> getCollaborators() {
        return null;
    }



    @Override
    public boolean verify(String mail, String password) throws IOException {

        Call<JSONObject> call = userWebService.login(mail, password);

        return call.execute().isSuccessful();

    }

}
