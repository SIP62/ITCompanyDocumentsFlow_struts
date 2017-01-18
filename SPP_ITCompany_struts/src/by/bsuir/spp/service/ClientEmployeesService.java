package by.bsuir.spp.service;

import java.util.List;

import by.bsuir.spp.dao.ClientEmployeesDAO;
import by.bsuir.spp.entities.ClientEmployee;

public class ClientEmployeesService {
	ClientEmployeesDAO ced = new ClientEmployeesDAO();

	public List<ClientEmployee> getClientEmployeeData(int clientid) {
		String clientId = "" + clientid;
		return ced.viewClientEmployees(clientId);
	}

}
