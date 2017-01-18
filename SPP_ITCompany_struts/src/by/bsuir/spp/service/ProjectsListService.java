package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.dao.ProjectListFullDAO;
import by.bsuir.spp.dao.ProjectListOfClientDAO;
import by.bsuir.spp.dao.ProjectListOfEmployeeDAO;
import by.bsuir.spp.entities.Project;

public class ProjectsListService {
	
	
	public List<Project> getProjectsList(int user_id, String role) {
		List<Project> projectsList = new ArrayList<Project>();
		
		String userId = "" + user_id;
		switch(role) {
			case "client":
				ProjectListOfClientDAO plocd = new ProjectListOfClientDAO();
				projectsList = plocd.viewProjectsList(userId);
				break;
			case "programmer":
			case "team_leader":	
				ProjectListOfEmployeeDAO ploed = new ProjectListOfEmployeeDAO();
				projectsList = ploed.viewProjectsList(userId);
				break;
			case "client_manager":
			case "project_manager":
			case "HR":	
				ProjectListFullDAO plfd = new ProjectListFullDAO();
				projectsList = plfd.viewProjectsList();
				break;
			default:
				projectsList = null;
		}
		return projectsList;
	}

}
