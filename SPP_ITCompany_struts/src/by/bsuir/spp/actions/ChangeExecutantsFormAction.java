package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Project;
import by.bsuir.spp.service.EmployeeListService;
import by.bsuir.spp.service.ProjectDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChangeExecutantsFormAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int projectid;
	private String user;
	private String role;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		companyModel.setEmployeeList(employeeList);
		
		ProjectDataService projectDataService = new ProjectDataService();
		Project project = projectDataService.getProjectData(projectid);
		companyModel.setProject(project);
		return SUCCESS;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
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
