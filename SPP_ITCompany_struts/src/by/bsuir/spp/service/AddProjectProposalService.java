package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddProjectProposalDAO;
import by.bsuir.spp.entities.ProjectProposal;

public class AddProjectProposalService {
	AddProjectProposalDAO appd = new AddProjectProposalDAO();

	public boolean addProjectProposal(ProjectProposal projectProposal) {
	
		return appd.addProjectProposalToDB(projectProposal);
	}

}
