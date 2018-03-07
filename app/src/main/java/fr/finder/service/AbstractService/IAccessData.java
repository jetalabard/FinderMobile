package fr.finder.service.AbstractService;

import java.util.List;

import fr.finder.business.Agency;
import fr.finder.business.Collaborator;
import fr.finder.business.Pole;
import fr.finder.business.Project;

/**
 * Created by jerem on 07/03/2018.
 */

public interface IAccessData
{

    List<Agency> getAgencies();

    List<Pole> getPoles();

    List<Project> getProjects();

    List<Collaborator> getCollaborators();

}
