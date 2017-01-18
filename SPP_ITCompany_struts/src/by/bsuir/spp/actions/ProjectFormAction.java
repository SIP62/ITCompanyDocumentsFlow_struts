package by.bsuir.spp.actions;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Project;
import by.bsuir.spp.service.ProjectDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProjectFormAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int projectid;
	private int user_id;
	private String user;
	private String role;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {

		ProjectDataService projectDataService = new ProjectDataService();
		Project project = projectDataService.getProjectData(projectid);

		companyModel.setProject(project);
		return SUCCESS;
	}
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
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
