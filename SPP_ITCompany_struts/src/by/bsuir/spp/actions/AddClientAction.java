package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddClientService;
import by.bsuir.spp.service.ClientListService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddClientAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String addClientMessage;
	private String errorAddClientMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		AddClientService addClientService = new AddClientService();
		boolean isAdded = addClientService.addClient(companyModel.getClient());
		
		ClientListService clientListService = new ClientListService();
		List<Client> clientList = clientListService.getClientList();
		companyModel.setClientList(clientList);
		
		if(isAdded) {
			setAddClientMessage(MessageManager.getProperty("message.addclient"));
			
			return SUCCESS;
			
		} else {
			setErrorAddClientMessage(MessageManager.getProperty("message.addclienterror"));
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

	public String getAddClientMessage() {
		return addClientMessage;
	}

	public void setAddClientMessage(String addClientMessage) {
		this.addClientMessage = addClientMessage;
	}

	public String getErrorAddClientMessage() {
		return errorAddClientMessage;
	}

	public void setErrorAddClientMessage(String errorAddClientMessage) {
		this.errorAddClientMessage = errorAddClientMessage;
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
