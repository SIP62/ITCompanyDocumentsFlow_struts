package by.bsuir.spp.actions;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AuthentificationService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private Users users;
	private String errorLoginPassMessage;
	
	public String execute() {
		String login = users.getLogin();
		String pass = users.getPassword();
		AuthentificationService authentificationService = new AuthentificationService();
		Users users = authentificationService.checkLogin(login, pass);
		if(users == null){
			setErrorLoginPassMessage(MessageManager.getProperty("message.loginerror")); 
			return ERROR;
		}
		else {
			setUser_id(users.getId());
			setUser(users.getName());
			setRole(users.getRoles().getRole());
			System.out.println("from LoginAction: role= " + role);
			return SUCCESS;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getErrorLoginPassMessage() {
		return errorLoginPassMessage;
	}

	public void setErrorLoginPassMessage(String errorLoginPassMessage) {
		this.errorLoginPassMessage = errorLoginPassMessage;
	}
	
	
	
	

}
