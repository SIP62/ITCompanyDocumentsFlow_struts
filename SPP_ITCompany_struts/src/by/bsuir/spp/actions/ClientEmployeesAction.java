package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.ClientEmployee;
import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.service.ClientEmployeesService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientEmployeesAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private int clientid;
	private String clientname;
	
	private CompanyModel companyModel = new CompanyModel();
	
	public String execute() {
		
		ClientEmployeesService clientEmployeesService = new ClientEmployeesService();
		List<ClientEmployee> clientEmployeeList = clientEmployeesService.getClientEmployeeData(clientid);
		
		companyModel.setClientEmployeeList(clientEmployeeList);;
		return SUCCESS;
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
	
	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
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
