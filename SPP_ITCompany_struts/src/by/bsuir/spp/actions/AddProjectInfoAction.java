package by.bsuir.spp.actions;

import java.util.List;

import by.bsuir.spp.entities.CompanyModel;
import by.bsuir.spp.entities.Info;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddProjectInfoService;
import by.bsuir.spp.service.ProjectInfoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProjectInfoAction extends ActionSupport implements ModelDriven<CompanyModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user;
	private String role;
	private int projectid;
	private String projectname;
	private int author_id;
	private String errorInsertMessage;
	
	private CompanyModel companyModel = new CompanyModel();
	
	
	
	public String execute() {
		
		System.out.println("from AddProjectInfoAction: projectid= " + projectid);
		System.out.println("from AddProjectInfoAction: author_id= " + author_id);
		
		AddProjectInfoService addProjectInfoService = new AddProjectInfoService();
		boolean isAdded = addProjectInfoService.addProjectInfo(companyModel.getInfo(), projectid, author_id);

		ProjectInfoService projectInfoService = new ProjectInfoService();
		List<Info> infoList = projectInfoService.getInfoData(projectid);
		companyModel.setInfoList(infoList);
		
		if(!isAdded) {
			setErrorInsertMessage(MessageManager.getProperty("message.inserterror"));
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
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getErrorInsertMessage() {
		return errorInsertMessage;
	}

	public void setErrorInsertMessage(String errorInsertMessage) {
		this.errorInsertMessage = errorInsertMessage;
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
