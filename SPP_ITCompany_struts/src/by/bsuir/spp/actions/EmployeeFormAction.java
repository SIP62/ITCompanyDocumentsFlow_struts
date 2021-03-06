package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.service.EmployeeDataService;
import by.bsuir.spp.service.RolesListService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeFormAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int id_users;
	private String user;
	private String role;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		System.out.println("from EmployeeFormAction: id_users = " 
				+ id_users);
		
		RolesListService rolesListService = new RolesListService();
		List<Roles> rolesList = rolesListService.getRolesList();
		companyModel.setRolesList(rolesList);
		
		EmployeeDataService employeeDataService = new EmployeeDataService();
		Employee employee = employeeDataService.getEmployeeData(id_users);
		companyModel.setEmployee(employee);
		
		System.out.println("from EmployeeFormAction: user name = " 
				+ companyModel.getEmployee().getUsers().getName());

		return SUCCESS;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

	public int getId_users() {
		return id_users;
	}

	public void setId_users(int id_users) {
		this.id_users = id_users;
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
