package by.bsuir.spp.actions;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddProjectProposalService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProjectProposalAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String addProjectProposalMessage;
	private String errorProjectProposalMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		AddProjectProposalService addProjectProposalService = new AddProjectProposalService();
		boolean isProposalAdded = addProjectProposalService.addProjectProposal(companyModel.getProjectProposal());

		if (isProposalAdded) {
			setAddProjectProposalMessage(MessageManager.getProperty("message.newprojectproposal"));
			return SUCCESS;
		} else {
			setErrorProjectProposalMessage(MessageManager.getProperty("message.projectproposalerror"));
			return ERROR;
		}
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
	
	public String getAddProjectProposalMessage() {
		return addProjectProposalMessage;
	}

	public void setAddProjectProposalMessage(String addProjectProposalMessage) {
		this.addProjectProposalMessage = addProjectProposalMessage;
	}

	public String getErrorProjectProposalMessage() {
		return errorProjectProposalMessage;
	}

	public void setErrorProjectProposalMessage(String errorProjectProposalMessage) {
		this.errorProjectProposalMessage = errorProjectProposalMessage;
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
