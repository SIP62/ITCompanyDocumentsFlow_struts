package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddProjectInfoDAO;
import by.bsuir.spp.entities.Info;

public class AddProjectInfoService {
	AddProjectInfoDAO apid = new AddProjectInfoDAO();

	public boolean addProjectInfo(Info info, int projectid, int author_id) {

		info.getEmployee().setId(author_id);
		info.getProject().setId(projectid);
		
		System.out.println("from AddProjectInfoService: projectid= " + info.getProject().getId());
		System.out.println("from AddProjectInfoService: author_id= " + info.getEmployee().getId());
		
		return apid.insertProjectInfo(info);
	}

}
