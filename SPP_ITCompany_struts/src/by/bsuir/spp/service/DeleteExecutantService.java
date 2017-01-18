package by.bsuir.spp.service;

import by.bsuir.spp.dao.DeleteExecutantDAO;

public class DeleteExecutantService {
	DeleteExecutantDAO ded = new DeleteExecutantDAO();

	public boolean removeExecutant(int projectid, int employeeid) {
		String projectId = "" + projectid;
		String employeeId = "" + employeeid;
		return ded.deleteExecutant(projectId, employeeId);
	}

}
