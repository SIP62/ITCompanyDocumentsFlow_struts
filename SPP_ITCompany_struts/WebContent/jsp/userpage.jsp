<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="s" uri="/struts-tags"%>        
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>User page</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/user.css">
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <c:if test="${role ne 'client' && role ne 'guest'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'client'}">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role ne 'HR' && role ne 'admin' && role ne 'guest'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'project_manager' || role eq 'HR' || role eq 'admin'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'HR'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'client_manager' || role eq 'admin'}">
          <span class="icon-bar"></span>
        </c:if>
        <c:if test="${role eq 'admin'}">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </c:if>                      
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href='<s:url action="logout"></s:url>'>Home</a></li>
        
        <c:if test="${role ne 'client' && role ne 'guest'}">
          <li><s:url action="employee_form" var="ef_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="id_users">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{ef_url}">Private Data</s:a>
          </li>
        </c:if>
        
        <c:if test="${role eq 'client'}">
          <li><s:url action="client_form" var="cf_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="id_users">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{cf_url}">Private Data</s:a>
          </li>
          <li><s:url action="project_proposal_form" var="ppf_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{ppf_url}">Project proposal</s:a>
          </li>
        </c:if>
        	
        <c:if test="${role ne 'HR' && role ne 'admin' && role ne 'guest'}">
          <li><s:url action="projects_list" var="pl_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{pl_url}">Projects list</s:a>
          </li>
        </c:if>
        
        <c:if test="${role eq 'project_manager' || role eq 'HR' || role eq 'admin'}">			
          <li><s:url action="employee_list" var="el_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{el_url}">Employee list</s:a>
          </li>
        </c:if>
        
        <c:if test="${role eq 'HR'}">			
          <li><s:url action="project_proposal_list" var="ppl_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{ppl_url}">Project proposal list</s:a>
          </li>
        </c:if>
        
        <c:if test="${role eq 'client_manager' || role eq 'admin'}">			
          <li><s:url action="client_list" var="cl_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{cl_url}">Client list</s:a>
          </li>
        </c:if>
        
        <c:if test="${role eq 'admin'}">			
          <li><s:url action="add_employee_form" var="aef_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{aef_url}">Add Employee</s:a>
          </li>
          
          <li><s:url action="add_client_form" var="acf_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{acf_url}">Add Client</s:a>
          </li>
          
          <li><s:url action="users_list" var="ul_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{ul_url}">User list</s:a>
          </li>
        </c:if>								
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href='<s:url action="logout"></s:url>'><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h3>Menu</h3>
      <ul class="nav nav-pills nav-stacked" style="background-color:#aaa">
      
        <c:if test="${role eq 'guest'}">
		  <li><s:url action="recruit_form" var="rf_url">
			  <s:param name="user">${user}</s:param>
			  <s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{rf_url}">Recruit application</s:a>
          </li>
          
          <li><s:url action="project_proposal_form" var="ppf_url">
          	  <s:param name="user_id">${user_id}</s:param>
			  <s:param name="user">${user}</s:param>
			  <s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{ppf_url}">Project proposal</s:a>
          </li>	  
        </c:if>
        
        <c:if test="${role eq 'client'}">
		  <c:if test="${!empty companyModel.projectsList}">
			<c:forEach var="project" items="${companyModel.projectsList}">
				<li><s:url action="project_form" var="pf_url">
				  <s:param name="projectid">${project.id}</s:param>
				  <s:param name="user_id">${user_id}</s:param>
				  <s:param name="user">${user}</s:param>
				  <s:param name="role">${role}</s:param>
				</s:url>
        		<s:a href="%{pf_url}">${project.name}</s:a></li>
			</c:forEach>
		  </c:if>
        </c:if>
        
        <c:if test="${role ne 'HR'}">
		  <c:if test="${!empty companyModel.projectsList}">
			<c:forEach var="project" items="${companyModel.projectsList}">
				<li><s:url action="project_data" var="pd_url">
				  <s:param name="projectid">${project.id}</s:param>
				  <s:param name="user_id">${user_id}</s:param>
				  <s:param name="user">${user}</s:param>
				  <s:param name="role">${role}</s:param>
				</s:url>
        		<s:a href="%{pd_url}">${project.name}</s:a></li>
			</c:forEach>
		  </c:if>
		  
		  <c:if test="${!empty companyModel.project}">
    		<li><s:url action="client_employees" var="ce_url">
				  <s:param name="clientid">${companyModel.project.client.id}</s:param>
				  <s:param name="clientname">${companyModel.project.client.users.name}</s:param>
				  <s:param name="user_id">${user_id}</s:param>
				  <s:param name="user">${user}</s:param>
				  <s:param name="role">${role}</s:param>
				</s:url>
        		<s:a href="%{ce_url}">See contacts of Client ${companyModel.project.client.users.name}</s:a>
    		</li>
    		
    		<li><s:url action="project_info" var="pi_url">
				  <s:param name="projectid">${companyModel.project.id}</s:param>
				  <s:param name="projectname">${companyModel.project.name}</s:param>
				  <s:param name="user_id">${user_id}</s:param>
				  <s:param name="user">${user}</s:param>
				  <s:param name="role">${role}</s:param>
				</s:url>
        		<s:a href="%{pi_url}">See Project ${companyModel.project.name} info</s:a>
    		</li>
    		
    		<li><s:url action="project_form" var="pf_url">
				  <s:param name="projectid">${companyModel.project.id}</s:param>
				  <s:param name="user_id">${user_id}</s:param>
				  <s:param name="user">${user}</s:param>
				  <s:param name="role">${role}</s:param>
				</s:url>
        		<s:a href="%{pf_url}">Change Project</s:a>
    		</li>
		  </c:if>
		  
		  <c:if test="${!empty companyModel.infoList}">
		    <li><s:url action="project_info_form" var="pif_url">
				  <s:param name="projectid">${projectid}</s:param>
				  <s:param name="projectname">${projectname}</s:param>
				  <s:param name="user_id">${user_id}</s:param>
				  <s:param name="user">${user}</s:param>
				  <s:param name="role">${role}</s:param>
				</s:url>
        		<s:a href="%{pif_url}">Add info in Project ${projectname}</s:a>
		    </li>
		  </c:if>
	    </c:if>
	  
	  
	  <c:if test="${role eq 'project_manager' || role eq 'HR' || role eq 'admin'}">
		<c:if test="${!empty companyModel.employeeList}">
		  <h5>Employee List</h5>
			<c:forEach var="employee" items="${companyModel.employeeList}">
			  <li><s:url action="employee_data" var="ed_url">
				  	<s:param name="id_users">${employee.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ed_url}">${employee.users.name} - ${employee.users.roles.role}</s:a>
			  </li>
			</c:forEach>
		</c:if>
		
		<c:if test="${!empty companyModel.employee && (role eq 'project_manager' || role eq 'admin')}">
    		<li><s:url action="employee_form" var="ef_url">
				  	<s:param name="id_users">${companyModel.employee.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ef_url}">Change</s:a>
    		</li>
    		
    		<li class="dropdown">
    		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Export<span class="caret"></span></a>
    		  <ul class="dropdown-menu">
      			<li><s:url action="employee_data" var="ed_url">
      				<s:param name="output_file">${'excel'}</s:param>
				  	<s:param name="id_users">${companyModel.employee.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ed_url}">Export to Excel</s:a>
      			</li>
      			
      			<li><s:url action="employee_data" var="ed_url">
      				<s:param name="output_file">${'pdf'}</s:param>
				  	<s:param name="id_users">${companyModel.employee.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ed_url}">Export to PDF</s:a>
      			</li>
      			
      			<li><s:url action="employee_data" var="ed_url">
      				<s:param name="output_file">${'csv'}</s:param>
				  	<s:param name="id_users">${companyModel.employee.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ed_url}">Export to CSV</s:a>
      			</li> 
    		  </ul>
  			</li>
		</c:if>
	  </c:if>
	  
	  <c:if test="${role eq 'HR'}">
		<c:forEach var="project_proposal" items="${companyModel.projectProposalList}">
			<li><s:url action="project_proposal_view" var="ppv_url">
				  	<s:param name="projectProposalid">${project_proposal.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ppv_url}">${project_proposal.name}</s:a>
			</li>
		</c:forEach>
	  </c:if>
	  
	  <c:if test="${role eq 'admin'}">
		<c:if test="${!empty companyModel.userList}">
			<li class="dropdown">
    		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Export<span class="caret"></span></a>
    		  <ul class="dropdown-menu">
				<li><s:url action="users_list" var="ul_url">
      				<s:param name="output_file">${'excel'}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ul_url}">Export to Excel</s:a>
      			</li>
      			
      			<li><s:url action="users_list" var="ul_url">
      				<s:param name="output_file">${'pdf'}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ul_url}">Export to PDF</s:a>
      			</li>
      			
      			<li><s:url action="users_list" var="ul_url">
      				<s:param name="output_file">${'csv'}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{ul_url}">Export to CSV</s:a>
      			</li> 
	  		  </ul>
	  	</c:if>
	  </c:if>
	  
	  <c:if test="${role eq 'client_manager' || role eq 'admin'}">
		<c:if test="${!empty companyModel.clientList}">
			<h5>Client List</h5>
			<c:forEach var="client" items="${companyModel.clientList}">
				<li><s:url action="client_data" var="cd_url">
				  	<s:param name="id_users">${client.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{cd_url}">${client.users.name}</s:a>
				</li>
			</c:forEach>
		</c:if>
		
		<c:if test="${!empty companyModel.client}">
    		<li><s:url action="client_form" var="cf_url">
				  	<s:param name="id_users">${companyModel.client.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{cf_url}">Change</s:a>
    		</li>
    		
    		<li class="dropdown">
    		  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Export<span class="caret"></span></a>
    		  <ul class="dropdown-menu">
      			<li><s:url action="client_data" var="cd_url">
      				<s:param name="output_file">${'excel'}</s:param>
				  	<s:param name="id_users">${companyModel.client.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{cd_url}">Export to Excel</s:a>
      			</li>
      			
      			<li><s:url action="client_data" var="cd_url">
      				<s:param name="output_file">${'pdf'}</s:param>
				  	<s:param name="id_users">${companyModel.client.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{cd_url}">Export to PDF</s:a>
      			</li>
      			
      			<li><s:url action="client_data" var="cd_url">
      				<s:param name="output_file">${'csv'}</s:param>
				  	<s:param name="id_users">${companyModel.client.users.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{cd_url}">Export to CSV</s:a>
      			</li> 
    		  </ul>
  			</li>
		</c:if>
	  </c:if>
	  </ul>
    </div>
    
    <div class="col-sm-6 text-left"> 
      <h3>Data</h3>
      <c:if test="${role ne 'HR'}">
        <c:if test="${!empty companyModel.project}">
			<table  class="table table-bordered">
				<tr><th>Project Name</th><td>${companyModel.project.name}</td></tr>
		        <tr><th>Project description</th><td>${companyModel.project.description}</td></tr>	
				<tr><th>Requirements Specification</th>
					<td>${companyModel.project.requirementSpecification}</td></tr>
				<tr><th>Cost</th><td>${companyModel.project.cost}</td></tr>
				<tr><th>Start Date</th><td>${companyModel.project.startDate}</td></tr>
		        <tr><th>Finish Date</th><td>${companyModel.project.finishDate}</td></tr>	
				<tr><th>Progress</th><td>${companyModel.project.progress}</td></tr>
				<tr><th>Client Name</th><td>${companyModel.project.client.users.name}</td></tr>
				<tr><th>Executants</th>
					<td>
					<c:forEach var="executant" items="${companyModel.project.employees}">
						${executant.users.name} ${executant.users.roles.role}<br>
					</c:forEach>
					</td></tr>
    		</table>
    	</c:if>
    	
    	<c:if test="${!empty companyModel.clientEmployeeList}">
			<table  class="table table-bordered">
			  <tr>
				<th>Name</th>
				<th>Phone</th>
				<th>e-Mail</th>
				<th>Skype</th>
				<th>Status</th>
			  </tr>
		        <c:forEach var="clientEmployee" items="${companyModel.clientEmployeeList}">
			      <tr>
					<td>${clientEmployee.name}</td>
					<td>${clientEmployee.phone}</td>
					<td>${clientEmployee.email}</td>
					<td>${clientEmployee.skype}</td>
					<td>${clientEmployee.status}</td>
				  </tr>
				</c:forEach>
    		</table>
    	</c:if>
    	<c:if test="${!empty companyModel.infoList}">
		  	<table  class="table table-bordered">
				<tr>
				<th>Project</th>
				<th>Info Name</th>
				<th>Date</th>
				<th>Info description</th>
				<th>Author</th>
				</tr>
				<c:forEach var="info" items="${companyModel.infoList}">
					<tr>
					<td>${info.project.name}</td>
					<td>${info.name}</td>
					<td>${info.date}</td>
					<td>${info.description}</td>
					<td>${info.employee.users.name}</td>
					</tr>
				</c:forEach>
    		</table>
    	</c:if>		
      </c:if>
      <c:if test="${role eq 'project_manager' || role eq 'HR' || role eq 'admin'}">
		<c:if test="${!empty companyModel.employee}">
			<table  class="table table-bordered">
				<tr><th>Name</th><td>${companyModel.employee.users.name}</td></tr>
		        <tr><th>Address</th><td>${companyModel.employee.address}</td></tr>	
				<tr><th>Phone</th><td>${companyModel.employee.phone}</td></tr>
				<tr><th>Passport</th><td>${companyModel.employee.passport}</td></tr>
				<tr><th>Credit card</th><td>${companyModel.employee.creditCard}</td></tr>
		        <tr><th>Resume</th><td>${companyModel.employee.resume}</td></tr>	
				<tr><th>Specialization</th><td>${companyModel.employee.specialization}</td></tr>
		        <tr><th>Salary</th><td>${companyModel.employee.salary}</td></tr>
		        <tr><th>Recruitment date</th><td>${companyModel.employee.recruitmentDate}</td></tr>
		        <tr><th>Contract expiration date</th><td>${companyModel.employee.contractExpirationDate}</td></tr>
		        <tr><th>Status</th><td>${companyModel.employee.users.roles.role}</td></tr>
    		</table>
		</c:if>
	  </c:if>
	  
	  <c:if test="${role eq 'HR'}">
		<c:if test="${!empty companyModel.projectProposal}">
			<table  class="table table-bordered">
				<tr><th>Project Name</th><td>${companyModel.projectProposal.name}</td></tr>
				<tr><th>Contact Name</th><td>${companyModel.projectProposal.contactName}</td></tr>
				<tr><th>Phone</th><td>${companyModel.projectProposal.phone}</td></tr>
				<tr><th>e-Mail</th><td>${companyModel.projectProposal.email}</td></tr>
				<tr><th>Status</th><td>${companyModel.projectProposal.status}</td></tr>
				<tr><th>Project description</th><td>${companyModel.projectProposal.description}</td></tr>
				<tr><th>Require Specification</th><td>${companyModel.projectProposal.requirementSpecification}</td></tr>
				<tr><th>Term</th><td>${companyModel.projectProposal.term}</td></tr>	
			</table>
		</c:if>
	  </c:if>
	  
	  <c:if test="${role eq 'client_manager' || role eq 'admin'}">
		<c:if test="${!empty companyModel.client}">
			<table  class="table table-bordered">
				<tr><th>Name</th><td>${companyModel.client.users.name}</td></tr>
		        <tr><th>Payment Credentials</th><td>${companyModel.client.paymentCredentials}</td></tr>	
				<tr><th>Phone</th><td>${companyModel.client.phone}</td></tr>
				<tr><th>e-Mail</th><td>${companyModel.client.email}</td></tr>
				<tr><th>Address</th><td>${companyModel.client.address}</td></tr>
				<tr><th>Discount</th><td>${companyModel.client.discount}</td></tr>
    		</table>
		</c:if>
	  </c:if>
	  
	 <c:if test="${role eq 'admin'}">
		<c:if test="${!empty companyModel.userList}">
		  <table class="table table-bordered">
			<tr><th>ID</th><th>User</th><th>Status</th><th>&nbsp;</th></tr>
			<c:forEach var="user_el" items="${companyModel.userList}">
				<tr><td>${user_el.id}</td>
				<td>${user_el.name}</td>
				<td>${user_el.roles.role}</td>
				<td>
				<c:if test="${user_el.roles.role eq 'guest'}">
				  <s:url action="delete_user" var="du_url">
				  	<s:param name="id_users">${user_el.id}</s:param>
				  	<s:param name="user_id">${user_id}</s:param>
				  	<s:param name="user">${user}</s:param>
				  	<s:param name="role">${role}</s:param>
				  </s:url>
        		  <s:a href="%{du_url}">Delete</s:a>
				</c:if></td></tr><br>
			</c:forEach>
		  </table>
		</c:if>	
	  </c:if> 
      
    </div>
    <div class="col-sm-3 sidenav">
      <div class="well">
        <h3>Welcome</h3>
	    <hr/>
        <p>${user} ${role}, hello!</p>
      </div>
      <div class="well">
        <p>${updatePrivateDataMessage}</p>
        <br/>
		<p>${updateProjectDataMessage}</p>
		<br/>
		<p>${updateEmployeeDataMessage}</p>
		<br/>
		<p>${updateClientDataMessage}</p>
 		<br/>
		<p>${addEmployeeMessage}</p>
		<br/>
		<p>${addClientMessage}</p>
		<br/>
		<p>${clientOutputMessage}</p>
 		<br/>
		<p>${employeeOutputMessage}</p>
		<br/>
		<p>${userOutputMessage}</p>	
		<br/>
		<p>${addProjectProposalMessage}</p>
		<br/>
		<p>${addRecruitMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

</body>
</html>