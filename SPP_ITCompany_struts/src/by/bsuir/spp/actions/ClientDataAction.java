package by.bsuir.spp.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.ClientCSVOutput;
import by.bsuir.spp.service.ClientDataService;
import by.bsuir.spp.service.ClientExcelOutput;
import by.bsuir.spp.service.ClientPDFOutput;

import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientDataAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int id_users;
	private String user;
	private String role;
	private String output_file;
	private String clientOutputMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		boolean isOutput = false;
		String message = null;
		
		ClientDataService clientDataService = new ClientDataService();
		Client client = clientDataService.getClientData(id_users);
		companyModel.setClient(client);
		
		if(output_file == null) output_file = "";
		System.out.println("outputFile = " + output_file);
		switch (output_file) {
		case "excel":
			ClientExcelOutput ceo = new ClientExcelOutput();
			try {
				isOutput = ceo.sendDataToExcel(client);
				message = "message.clientexceloutput";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "pdf":
			ClientPDFOutput cpo = new ClientPDFOutput();
			try {
				isOutput = cpo.sendDataToPDF(client);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.clientpdfoutput";
			break;
		case "csv":
			ClientCSVOutput cco = new ClientCSVOutput();
			try {
				isOutput = cco.sendDataToCSV(client);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.clientcsvoutput";
			break;

		default:
			break;
		}
		if (isOutput) {
			setClientOutputMessage(MessageManager.getProperty(message));
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
	
	public String getClientOutputMessage() {
		return clientOutputMessage;
	}

	public void setClientOutputMessage(String clientOutputMessage) {
		this.clientOutputMessage = clientOutputMessage;
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
