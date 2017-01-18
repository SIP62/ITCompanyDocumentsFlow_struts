package by.bsuir.spp.entities;

import java.util.List;

public class CompanyModel {
	private Employee employee;
	private Client client;
	private Project project;
	private ProjectProposal projectProposal;
	private ClientEmployee clientEmployee;
	private Info info;
	private Recruit recruit;
	private List<Roles> rolesList;
	private List<Employee> employeeList;
	private List<Project> projectsList;
	private List<Client> clientList;
	private List<ClientEmployee> clientEmployeeList;
	private List<Info> infoList;
	private List<ProjectProposal> projectProposalList;
	private List<Users> userList;
	
	
	public CompanyModel() {}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public ProjectProposal getProjectProposal() {
		return projectProposal;
	}

	public void setProjectProposal(ProjectProposal projectProposal) {
		this.projectProposal = projectProposal;
	}
	
	public ClientEmployee getClientEmployee() {
		return clientEmployee;
	}

	public void setClientEmployee(ClientEmployee clientEmployee) {
		this.clientEmployee = clientEmployee;
	}
	
	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	public Recruit getRecruit() {
		return recruit;
	}

	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}

	public List<Roles> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<Roles> rolesList) {
		this.rolesList = rolesList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Project> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}
	
	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public List<ClientEmployee> getClientEmployeeList() {
		return clientEmployeeList;
	}

	public void setClientEmployeeList(List<ClientEmployee> clientEmployeeList) {
		this.clientEmployeeList = clientEmployeeList;
	}

	public List<Info> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<Info> infoList) {
		this.infoList = infoList;
	}

	public List<ProjectProposal> getProjectProposalList() {
		return projectProposalList;
	}

	public void setProjectProposalList(List<ProjectProposal> projectProposalList) {
		this.projectProposalList = projectProposalList;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}
	
	
}
