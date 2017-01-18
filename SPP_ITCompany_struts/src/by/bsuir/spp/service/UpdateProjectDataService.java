package by.bsuir.spp.service;

import by.bsuir.spp.dao.UpdateProjectDataDAO;
import by.bsuir.spp.entities.Project;

public class UpdateProjectDataService {
	UpdateProjectDataDAO updd = new UpdateProjectDataDAO();
	

	public boolean updateProjectData(Project project) {

		return updd.updateProjectInDB(project);
	}

}
