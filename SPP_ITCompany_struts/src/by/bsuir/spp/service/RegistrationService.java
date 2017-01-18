package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.dao.RegistrationDAO;
import by.bsuir.spp.dao.RolesListDAO;
import by.bsuir.spp.entities.Roles;
import by.bsuir.spp.entities.Users;

public class RegistrationService {
	
	RegistrationDAO crd = new RegistrationDAO();
	public boolean addUser(Users users) {
		
		PassScrambler ps = new PassScrambler();
		List<Roles> rolesList = new ArrayList<Roles>();
		RolesListDAO rld = new RolesListDAO();
		rolesList = rld.viewRolesList();
		users.setPassword(ps.scramble(users.getPassword()));
		for (Roles r: rolesList) {
			if(r.getRole().equals("guest")) {
				users.getRoles().setId(r.getId());
				break;
			}
		}
		
		return crd.addUserToDB(users);
	}
}
