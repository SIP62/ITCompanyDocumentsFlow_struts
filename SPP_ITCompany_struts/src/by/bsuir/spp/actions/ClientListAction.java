package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.service.ClientListService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientListAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	
	private CompanyModel companyModel = new CompanyModel();
	
	public String execute() {
		
		ClientListService clientListService = new ClientListService();
		List<Client> clientList = clientListService.getClientList();
		companyModel.setClientList(clientList);
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
