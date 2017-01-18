package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Project;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.DeleteExecutantService;
import by.bsuir.spp.service.EmployeeListService;
import by.bsuir.spp.service.ProjectDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteExecutantAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int projectid;
	private int employeeid;
	private int user_id;
	private String user;
	private String role;
	private String errorDeleteMessage;
	
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {

		DeleteExecutantService deleteExecutantService = new DeleteExecutantService();
		boolean isDeleted = deleteExecutantService.removeExecutant(projectid, employeeid);
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		companyModel.setEmployeeList(employeeList);
		
		ProjectDataService projectDataService = new ProjectDataService();
		Project project = projectDataService.getProjectData(projectid);
		companyModel.setProject(project);

		if(isDeleted) {
			return SUCCESS;
		} else {
			setErrorDeleteMessage(MessageManager.getProperty("message.deleteerror"));
			return ERROR;
		}
	}
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
	
	public String getErrorDeleteMessage() {
		return errorDeleteMessage;
	}

	public void setErrorDeleteMessage(String errorDeleteMessage) {
		this.errorDeleteMessage = errorDeleteMessage;
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
