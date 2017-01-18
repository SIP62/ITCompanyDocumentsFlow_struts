package by.bsuir.spp.service;

import java.util.List;

import by.bsuir.spp.dao.ProjectInfoDAO;
import by.bsuir.spp.entities.Info;

public class ProjectInfoService {
	ProjectInfoDAO pid = new ProjectInfoDAO();

	public List<Info> getInfoData(int projectid) {
		String projectId = "" + projectid;
		return pid.viewProjectInfo(projectId);
	}

}
