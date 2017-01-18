package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddClientEmployeeDAO;
import by.bsuir.spp.entities.ClientEmployee;

public class AddClientEmployeeService {
	AddClientEmployeeDAO aced = new AddClientEmployeeDAO();

	public boolean addClientEmployee(ClientEmployee clientEmployee, int clientid) {

		clientEmployee.getClient().setId(clientid);
		
		return aced.insertClientEmployee(clientEmployee);
	}

}
