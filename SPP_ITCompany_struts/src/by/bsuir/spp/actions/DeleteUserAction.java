package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.DeleteUserService;
import by.bsuir.spp.service.UsersListService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteUserAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id_users;
	private int user_id;
	private String user;
	private String role;
	private String errorDeleteMessage;
	
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		System.out.println("from DeleteUserAction: id_users = " + id_users);
		
		DeleteUserService deleteUserService = new DeleteUserService();
		boolean isDeleted = deleteUserService.removeUser(id_users);
		
		UsersListService usersListService = new UsersListService();
		List<Users> userList = usersListService.getUsersList();
		companyModel.setUserList(userList);

		if(isDeleted) {
			return SUCCESS;
		} else {
			setErrorDeleteMessage(MessageManager.getProperty("message.deleteerror"));
			return ERROR;
		}
	}
	
	public int getId_users() {
		return id_users;
	}

	public void setId_users(int id_users) {
		this.id_users = id_users;
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
