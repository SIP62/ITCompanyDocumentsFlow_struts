package by.bsuir.spp.actions;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.UpdateProjectDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateProjectAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private int id_project;
	private int user_id;
	private String user;
	private String role;
	private String updateProjectDataMessage;
	private String errorUpdateProjectDataMessage;
	
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {

		UpdateProjectDataService updateProjectDataService = new UpdateProjectDataService();
		boolean isUpdated = updateProjectDataService.updateProjectData(companyModel.getProject());

		if(isUpdated) {
			setUpdateProjectDataMessage(MessageManager.getProperty("message.updateprojectdata"));
	
			return SUCCESS;
			
		} else {
			setErrorUpdateProjectDataMessage(MessageManager.getProperty("message.updateprojectdataerror"));
			return ERROR;
		}
	}
/*	
	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}
*/
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
	
	public String getUpdateProjectDataMessage() {
		return updateProjectDataMessage;
	}

	public void setUpdateProjectDataMessage(String updateProjectDataMessage) {
		this.updateProjectDataMessage = updateProjectDataMessage;
	}

	public String getErrorUpdateProjectDataMessage() {
		return errorUpdateProjectDataMessage;
	}

	public void setErrorUpdateProjectDataMessage(
			String errorUpdateProjectDataMessage) {
		this.errorUpdateProjectDataMessage = errorUpdateProjectDataMessage;
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
