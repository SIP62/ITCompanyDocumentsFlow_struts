package by.bsuir.spp.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.EmployeeCSVOutput;
import by.bsuir.spp.service.EmployeeDataService;
import by.bsuir.spp.service.EmployeeExcelOutput;
import by.bsuir.spp.service.EmployeePDFOutput;

import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeDataAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int id_users;
	private String user;
	private String role;
	private String output_file;
	private String employeeOutputMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		boolean isOutput = false;
		String message = null;
		
		EmployeeDataService employeeDataService = new EmployeeDataService();
		Employee employee = employeeDataService.getEmployeeData(id_users);
		companyModel.setEmployee(employee);
		
		if(output_file == null) output_file = "";
		System.out.println("outputFile = " + output_file);
		switch (output_file) {
		case "excel":
			EmployeeExcelOutput eeo = new EmployeeExcelOutput();
			try {
				isOutput = eeo.sendDataToExcel(employee);
				message = "message.employeeexceloutput";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "pdf":
			EmployeePDFOutput epo = new EmployeePDFOutput();
			try {
				isOutput = epo.sendDataToPDF(employee);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.employeepdfoutput";
			break;
		case "csv":
			EmployeeCSVOutput eco = new EmployeeCSVOutput();
			try {
				isOutput = eco.sendDataToCSV(employee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.employeecsvoutput";
			break;

		default:
			break;
		}
		if (isOutput) {
			setEmployeeOutputMessage(MessageManager.getProperty(message));
		}

		return SUCCESS;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

	public int getId_users() {
		return id_users;
	}

	public void setId_users(int id_users) {
		this.id_users = id_users;
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
	
	public String getOutput_file() {
		return output_file;
	}

	public void setOutput_file(String output_file) {
		this.output_file = output_file;
	}

	public String getEmployeeOutputMessage() {
		return employeeOutputMessage;
	}

	public void setEmployeeOutputMessage(String employeeOutputMessage) {
		this.employeeOutputMessage = employeeOutputMessage;
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
