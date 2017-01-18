package by.bsuir.spp.actions;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.RegistrationService;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String role;
	private Users users;
	private String registrationMessage;
	private String errorRegistrationMessage;
	
	public String execute() {
		
		RegistrationService registrationService = new RegistrationService();
		boolean isRegistrated = registrationService.addUser(users);
		if(!isRegistrated){
			setErrorRegistrationMessage(MessageManager.getProperty("message.registrationerror")); 
			return ERROR;
		}
		else {
			setUser(users.getName());
			setRole("guest");
			setRegistrationMessage(MessageManager.getProperty("message.registration"));
			return SUCCESS;
		}
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

	public String getRegistrationMessage() {
		return registrationMessage;
	}

	public void setRegistrationMessage(String registrationMessage) {
		this.registrationMessage = registrationMessage;
	}

	public String getErrorRegistrationMessage() {
		return errorRegistrationMessage;
	}

	public void setErrorRegistrationMessage(String errorRegistrationMessage) {
		this.errorRegistrationMessage = errorRegistrationMessage;
	}
	

}
