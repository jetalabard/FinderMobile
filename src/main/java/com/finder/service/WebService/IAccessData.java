package com.finder.service.WebService;

import com.finder.business.Agency;
import com.finder.business.Collaborator;
import com.finder.business.Pole;
import com.finder.business.Project;

import java.io.IOException;
import java.util.List;

/**
 * Created by jerem on 17/03/2018.
 */

public interface IAccessData {

    public List<Agency> getAgencies();

    public List<Pole> getPoles();

    public List<Project> getProjects();

    public List<Collaborator> getCollaborators();

    boolean verify(String mail, String password) throws IOException;
}
