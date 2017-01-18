package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddEmployeeService;
import by.bsuir.spp.service.EmployeeListService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddEmployeeAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String addEmployeeMessage;
	private String errorAddEmployeeMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		System.out.println("from AddEmployeeAction: id_role = " + companyModel.getEmployee().getUsers().getRoles().getId());
		
		AddEmployeeService addEmployeeService = new AddEmployeeService();
		boolean isAdded = addEmployeeService.addEmployee(companyModel.getEmployee());
	
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		companyModel.setEmployeeList(employeeList);
		
		if(isAdded) {
			setAddEmployeeMessage(MessageManager.getProperty("message.addclient"));
			
			return SUCCESS;
			
		} else {
			setErrorAddEmployeeMessage(MessageManager.getProperty("message.addclienterror"));
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

	public String getAddEmployeeMessage() {
		return addEmployeeMessage;
	}

	public void setAddEmployeeMessage(String addEmployeeMessage) {
		this.addEmployeeMessage = addEmployeeMessage;
	}

	public String getErrorAddEmployeeMessage() {
		return errorAddEmployeeMessage;
	}

	public void setErrorAddEmployeeMessage(String errorAddEmployeeMessage) {
		this.errorAddEmployeeMessage = errorAddEmployeeMessage;
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
