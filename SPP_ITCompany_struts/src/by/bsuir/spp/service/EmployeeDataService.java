package by.bsuir.spp.service;

import by.bsuir.spp.dao.EmployeeDataDAO;
import by.bsuir.spp.entities.Employee;

public class EmployeeDataService {
	EmployeeDataDAO edd = new EmployeeDataDAO();

	public Employee getEmployeeData(int id_user) {
		PassDecoder pd = new PassDecoder();
		String idUsers = "" + id_user;
		
		System.out.println("from EmployeeDataService: idUsers = " 
				+ idUsers);
		
		Employee employee = edd.viewEmployeeData(idUsers);
		String password = pd.decode(employee.getUsers().getPassword());
		employee.getUsers().setPassword(password);
		return employee;
	}

}
