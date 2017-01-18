package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddExecutantDAO;

public class AddExecutantService {
	AddExecutantDAO aed = new AddExecutantDAO();

	public boolean addExecutant(int projectid, int employeeid) {
		String projectId = "" + projectid;
		String employeeId = "" + employeeid;
		return aed.insertExecutantInProject(projectId, employeeId);
	}

}
