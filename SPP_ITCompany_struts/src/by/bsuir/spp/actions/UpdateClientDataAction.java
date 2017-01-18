package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.ClientListService;
import by.bsuir.spp.service.UpdateClientDataService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateClientDataAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String updatePrivateDataMessage;
	private String updateClientDataMessage;
	private String errorUpdateClientDataMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		UpdateClientDataService updateClientDataService = new UpdateClientDataService();
		boolean isUpdated = updateClientDataService.updateClientData(companyModel.getClient());
		
		ClientListService clientListService = new ClientListService();
		List<Client> clientList = clientListService.getClientList();
		companyModel.setClientList(clientList);
		
		if(isUpdated) {
			if (user_id == companyModel.getClient().getUsers().getId()) {
				setUpdatePrivateDataMessage(MessageManager.getProperty("message.updateprivatedata"));
			} else {
				setUpdateClientDataMessage(MessageManager.getProperty("message.updateemployeedata"));
			}
			return SUCCESS;
			
		} else {
			setErrorUpdateClientDataMessage(MessageManager.getProperty("message.updateemployeedataerror"));
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
	
	public String getUpdateClientDataMessage() {
		return updateClientDataMessage;
	}

	public void setUpdateClientDataMessage(String updateClientDataMessage) {
		this.updateClientDataMessage = updateClientDataMessage;
	}

	public String getErrorUpdateClientDataMessage() {
		return errorUpdateClientDataMessage;
	}

	public void setErrorUpdateClientDataMessage(String errorUpdateClientDataMessage) {
		this.errorUpdateClientDataMessage = errorUpdateClientDataMessage;
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
