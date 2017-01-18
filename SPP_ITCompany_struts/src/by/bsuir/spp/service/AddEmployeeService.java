package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddEmployeeDAO;
import by.bsuir.spp.entities.Employee;

public class AddEmployeeService {
	
	AddEmployeeDAO aed = new AddEmployeeDAO();

	public boolean addEmployee(Employee employee) {

		PassScrambler ps = new PassScrambler();
		String pass = employee.getUsers().getPassword();
		employee.getUsers().setPassword(ps.scramble(pass));
		
		return aed.addEmployeeInDB(employee);

	}

}
