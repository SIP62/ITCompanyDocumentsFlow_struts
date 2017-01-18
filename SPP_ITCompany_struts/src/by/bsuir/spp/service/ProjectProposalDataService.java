package by.bsuir.spp.service;

import by.bsuir.spp.dao.ProjectProposalDataDAO;
import by.bsuir.spp.entities.ProjectProposal;

public class ProjectProposalDataService {
	ProjectProposalDataDAO ppdd = new ProjectProposalDataDAO();

	public ProjectProposal getProjectProposalData(int projectProposalid) {
		String projectProposalId = "" + projectProposalid;
		ProjectProposal projectProposal = ppdd.viewProjectProposalData(projectProposalId);
		return projectProposal;
	}

}
