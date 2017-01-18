package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.EmployeeListService;
import by.bsuir.spp.service.UpdateEmployeeDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateEmployeeDataAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String updatePrivateDataMessage;
	private String updateEmployeeDataMessage;
	private String errorUpdateEmployeeDataMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		System.out.println("from UpdateEmployeeDataAction: user ID = " 
				+ companyModel.getEmployee().getUsers().getId() + " user Status = " 
				+ companyModel.getEmployee().getUsers().getRoles().getId());

		UpdateEmployeeDataService updateEmployeeDataService = new UpdateEmployeeDataService();
		boolean isUpdated = updateEmployeeDataService.updateEmployeeData(companyModel.getEmployee());
		
		EmployeeListService employeeListService = new EmployeeListService();
		List<Employee> employeeList = employeeListService.getEmployeeList();
		companyModel.setEmployeeList(employeeList);
		
		System.out.println("from UpdateEmployeeDataAction: user name = " 
				+ companyModel.getEmployee().getUsers().getName());
		
		if(isUpdated) {
			if (user_id == companyModel.getEmployee().getUsers().getId()) {
				setUpdatePrivateDataMessage(MessageManager.getProperty("message.updateprivatedata"));
			} else {
				setUpdateEmployeeDataMessage(MessageManager.getProperty("message.updateemployeedata"));
			}
			return SUCCESS;
			
		} else {
			setErrorUpdateEmployeeDataMessage(MessageManager.getProperty("message.updateemployeedataerror"));
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
	

	public String getUpdatePrivateDataMessage() {
		return updatePrivateDataMessage;
	}

	public void setUpdatePrivateDataMessage(String updatePrivateDataMessage) {
		this.updatePrivateDataMessage = updatePrivateDataMessage;
	}

	public String getUpdateEmployeeDataMessage() {
		return updateEmployeeDataMessage;
	}

	public void setUpdateEmployeeDataMessage(String updateEmployeeDataMessage) {
		this.updateEmployeeDataMessage = updateEmployeeDataMessage;
	}

	public String getErrorUpdateEmployeeDataMessage() {
		return errorUpdateEmployeeDataMessage;
	}

	public void setErrorUpdateEmployeeDataMessage(
			String errorUpdateEmployeeDataMessage) {
		this.errorUpdateEmployeeDataMessage = errorUpdateEmployeeDataMessage;
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
