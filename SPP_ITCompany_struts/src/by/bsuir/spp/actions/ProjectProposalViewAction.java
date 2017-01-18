package by.bsuir.spp.actions;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.ProjectProposal;
import by.bsuir.spp.service.ProjectProposalDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProjectProposalViewAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int projectProposalid;
	private int user_id;
	private String user;
	private String role;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		ProjectProposalDataService projectProposalDataService = new ProjectProposalDataService();
		ProjectProposal projectProposal = projectProposalDataService.getProjectProposalData(projectProposalid);
		
		companyModel.setProjectProposal(projectProposal);
		return SUCCESS;
	}
	
	public int getProjectProposalid() {
		return projectProposalid;
	}

	public void setProjectProposalid(int projectProposalid) {
		this.projectProposalid = projectProposalid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public CompanyModel getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}

	@Override
	public CompanyModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
