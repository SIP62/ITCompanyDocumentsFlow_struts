package by.bsuir.spp.actions;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddRecruitService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddRecruitAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String addRecruitMessage;
	private String errorRecruitMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	public String execute() {
		
		AddRecruitService addRecruitService = new AddRecruitService();
		boolean isRecruitAdded = addRecruitService.addRecruit(companyModel.getRecruit());
		
		if (isRecruitAdded) {
			setAddRecruitMessage(MessageManager.getProperty("message.newrecruit"));
			return SUCCESS;
		} else {
			setErrorRecruitMessage(MessageManager.getProperty("message.recruiterror"));
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
	
	public String getAddRecruitMessage() {
		return addRecruitMessage;
	}

	public void setAddRecruitMessage(String addRecruitMessage) {
		this.addRecruitMessage = addRecruitMessage;
	}

	public String getErrorRecruitMessage() {
		return errorRecruitMessage;
	}

	public void setErrorRecruitMessage(String errorRecruitMessage) {
		this.errorRecruitMessage = errorRecruitMessage;
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
