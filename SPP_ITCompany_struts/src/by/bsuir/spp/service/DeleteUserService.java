package by.bsuir.spp.service;

import by.bsuir.spp.dao.DeleteUserDAO;

public class DeleteUserService {
	DeleteUserDAO dud = new DeleteUserDAO();

	public boolean removeUser(int id_users) {
		String userId = "" + id_users;
		return dud.deleteUser(userId);
	}

}
