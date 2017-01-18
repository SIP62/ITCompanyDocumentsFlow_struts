package by.bsuir.spp.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.UserCSVOutput;
import by.bsuir.spp.service.UserExcelOutput;
import by.bsuir.spp.service.UserPDFOutput;
import by.bsuir.spp.service.UsersListService;

import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UsersListAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private String output_file;
	private String userOutputMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	public String execute() {
		
		boolean isOutput = false;
		String message = null;
		
		UsersListService usersListService = new UsersListService();
		List<Users> userList = usersListService.getUsersList();
		companyModel.setUserList(userList);
		
		if(output_file == null) output_file = "";
		System.out.println("outputFile = " + output_file);
		switch (output_file) {
		case "excel":
			UserExcelOutput ueo = new UserExcelOutput();
			try {
				isOutput = ueo.sendDataToExcel(userList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.userexceloutput";
			break;
		case "pdf":
			UserPDFOutput upo = new UserPDFOutput();
			try {
				isOutput = upo.sendDataToPDF(userList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.userpdfoutput";
			break;
		case "csv":
			UserCSVOutput uco = new UserCSVOutput();
			try {
				isOutput = uco.sendDataToCSV(userList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.usercsvoutput";
			break;

		default:
			break;
		}
		if (isOutput) {
			setUserOutputMessage(MessageManager.getProperty(message));
		}

		return SUCCESS;
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
	
	public String getOutput_file() {
		return output_file;
	}

	public void setOutput_file(String output_file) {
		this.output_file = output_file;
	}

	public String getUserOutputMessage() {
		return userOutputMessage;
	}

	public void setUserOutputMessage(String userOutputMessage) {
		this.userOutputMessage = userOutputMessage;
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
