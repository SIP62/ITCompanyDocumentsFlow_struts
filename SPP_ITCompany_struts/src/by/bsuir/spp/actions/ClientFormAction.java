package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.service.ClientDataService;
import by.bsuir.spp.service.RolesListService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientFormAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int id_users;
	private String user;
	private String role;
	private int id_roles;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		RolesListService rolesListService = new RolesListService();
		List<Roles> rolesList = rolesListService.getRolesList();
		for (Roles rl: rolesList) {
			if (rl.getRole().equals("client")) {
				setId_roles(rl.getId());
				break;
			}
		}
		
		ClientDataService clientDataService = new ClientDataService();
		Client client = clientDataService.getClientData(id_users);
		companyModel.setClient(client);

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
	
	public int getId_roles() {
		return id_roles;
	}

	public void setId_roles(int id_roles) {
		this.id_roles = id_roles;
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
