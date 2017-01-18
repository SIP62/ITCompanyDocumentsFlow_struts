package by.bsuir.spp.service;

import by.bsuir.spp.dao.ProjectDataDAO;
import by.bsuir.spp.entities.Project;

public class ProjectDataService {
	ProjectDataDAO pdd = new ProjectDataDAO();

	public Project getProjectData(int projectid) {
		String projectId = "" + projectid;
		Project project = pdd.viewProjectData(projectId);
		return project;
	}

}
