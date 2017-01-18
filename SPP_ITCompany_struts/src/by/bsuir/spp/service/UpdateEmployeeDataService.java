package by.bsuir.spp.service;

import by.bsuir.spp.dao.UpdateEmployeeDataDAO;
import by.bsuir.spp.entities.Employee;

public class UpdateEmployeeDataService {
	UpdateEmployeeDataDAO uedd = new UpdateEmployeeDataDAO();

	public boolean updateEmployeeData(Employee employee) {
		
		PassScrambler ps = new PassScrambler();
		String pass = employee.getUsers().getPassword();
		employee.getUsers().setPassword(ps.scramble(pass));
	
		return uedd.updateEmployeeInDB(employee);
	}

}
