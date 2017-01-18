<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data Form</title>
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
        <span class="icon-bar"></span>           
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href='<s:url action="logout"></s:url>'>Home</a></li>
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
      <h4>Menu</h4>
      <ul class="nav nav-pills nav-stacked" style="background-color:#aaa">
		<li><s:url action="return_to_page" var="rtp_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{rtp_url}">Return</s:a>
        </li>
	  </ul>
    </div>
    <div class="col-sm-6 text-left"> 
      <h4>Employee Data Form</h4>
      
      <s:form class="form-horizontal" role="form" action="update_employee_data" method="POST">
		<input type="hidden" name="companyModel.employee.id" value="${companyModel.employee.id}" />
		<input type="hidden" name="companyModel.employee.users.id" value="${companyModel.employee.users.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		
		<c:choose>
		<c:when test="${role eq 'admin'}">
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="companyModel.employee.users.name" value="${companyModel.employee.users.name}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="companyModel.employee.address" value="${companyModel.employee.address}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="companyModel.employee.phone" value="${companyModel.employee.phone}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="passport">Passport:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="passport" name="companyModel.employee.passport" value="${companyModel.employee.passport}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="credit_card" name="companyModel.employee.creditCard" value="${companyModel.employee.creditCard}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="companyModel.employee.resume">${companyModel.employee.resume}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="companyModel.employee.specialization" value="${companyModel.employee.specialization}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="companyModel.employee.salary" value="${companyModel.employee.salary}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="companyModel.employee.recruitmentDate" value="${companyModel.employee.recruitmentDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="companyModel.employee.contractExpirationDate" value="${companyModel.employee.contractExpirationDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="id_roles" name="companyModel.employee.users.roles.id">
	        	<c:forEach var="employeerole" items="${companyModel.rolesList}">
	        	  <c:choose>
	        		<c:when test="${employeerole.role eq companyModel.employee.users.roles.role}">
	        		  <option value="${employeerole.id}" selected>${employeerole.role}</option>
	        		</c:when>
	        	  	<c:otherwise>
	        		  <option value="${employeerole.id}">${employeerole.role}</option>
	        	  	</c:otherwise>
	        	  </c:choose>
	        	</c:forEach>
	          </select>			
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="login">Login:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="login" name="companyModel.employee.users.login" value="${companyModel.employee.users.login}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="pwd">Password:</label>
		    <div class="col-sm-9"> 
		      <input type="password" class="form-control" id="pwd" name="companyModel.employee.users.password" value="${companyModel.employee.users.password}">
		    </div>    
		  </div>
		  </c:when>
		  <c:when test="${role eq 'project_manager' or role eq 'HR'}">
			<c:if test="${role ne companyModel.employee.users.roles.role}">
				<input type="hidden" name="companyModel.employee.users.login" value="${companyModel.employee.users.login}" />\
				<input type="hidden" name="companyModel.employee.users.password" value="${companyModel.employee.users.password}" />
				<input type="hidden" name="companyModel.employee.passport" value="${companyModel.employee.passport}" />
				<input type="hidden" name="companyModel.employee.creditCard" value="${companyModel.employee.creditCard}" />
			</c:if>
			<div class="form-group">
		      <label class="control-label col-sm-3" for="name">Name:</label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="name" name="companyModel.employee.users.name" value="${companyModel.employee.users.name}" readonly>
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-3" for="address">Address:</label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="address" name="companyModel.employee.address" value="${companyModel.employee.address}" readonly>
		      </div>
		    </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="companyModel.employee.phone" value="${companyModel.employee.phone}" readonly>
		    </div>
		  </div>
		  <c:if test="${role eq employee.users.roles.role}">	
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="passport">Passport:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="passport" name="companyModel.employee.passport" value="${companyModel.employee.passport}">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="credit_card" name="companyModel.employee.creditCard" value="${companyModel.employee.creditCard}" readonly>
			    </div>
			  </div>
		  </c:if>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="companyModel.employee.resume" readonly>${companyModel.employee.resume}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="companyModel.employee.specialization" value="${companyModel.employee.specialization}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="companyModel.employee.salary" value="${companyModel.employee.salary}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="companyModel.employee.recruitmentDate" value="${companyModel.employee.recruitmentDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="companyModel.employee.contractExpirationDate" value="${companyModel.employee.contractExpirationDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="id_roles" name="companyModel.employee.users.roles.id">
	        	<c:forEach var="employeerole" items="${companyModel.rolesList}">
	        	  <c:choose>
	        		<c:when test="${employeerole.role eq companyModel.employee.users.roles.role}">
	        		  <option value="${employeerole.id}" selected>${employeerole.role}</option>
	        		</c:when>
	        	  	<c:otherwise>
	        		  <option value="${employeerole.id}">${employeerole.role}</option>
	        	  	</c:otherwise>
	        	  </c:choose>
	        	</c:forEach>
	          </select>			
		    </div>
		  </div>
		  <c:if test="${role eq companyModel.employee.users.roles.role}">
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="login">Login:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="login" name="companyModel.employee.users.login" value="${companyModel.employee.users.login}">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="pwd">Password:</label>
			    <div class="col-sm-9"> 
			      <input type="password" class="form-control" id="pwd" name="companyModel.employee.users.password" value="${companyModel.employee.users.password}">
			    </div>    
			  </div>
		  </c:if>		
		  </c:when>
		  <c:otherwise>
			<input type="hidden" name="companyModel.employee.users.roles.id" value="${companyModel.employee.users.roles.id}" />
			<div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="companyModel.employee.users.name" value="${companyModel.employee.users.name}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="companyModel.employee.address" value="${companyModel.employee.address}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="companyModel.employee.phone" value="${companyModel.employee.phone}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="passport">Passport:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="passport" name="companyModel.employee.passport" value="${companyModel.employee.passport}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="credit_card" name="companyModel.employee.creditCard" value="${companyModel.employee.creditCard}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="companyModel.employee.resume">${companyModel.employee.resume}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="companyModel.employee.specialization" value="${companyModel.employee.specialization}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="companyModel.employee.salary" value="${companyModel.employee.salary}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="companyModel.employee.recruitmentDate" value="${companyModel.employee.recruitmentDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="companyModel.employee.contractExpirationDate" value="${companyModel.employee.contractExpirationDate}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="status">Status:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="status" name="companyModel.employee.users.roles.role" value="${companyModel.employee.users.roles.role}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="login">Login:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="login" name="companyModel.employee.users.login" value="${companyModel.employee.users.login}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="pwd">Password:</label>
		    <div class="col-sm-9"> 
		      <input type="password" class="form-control" id="pwd" name="companyModel.employee.users.password" value="${companyModel.employee.users.password}">
		    </div>    
		  </div>
		  </c:otherwise>		
		</c:choose>
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Update</button>
		    </div>
		  </div>
		  
	  </s:form>
    </div>
    <div class="col-sm-3 sidenav">
      <div class="well">
        <h3>Welcome</h3>
	    <hr/>
        <p>${user} ${role}, hello!</p>
      </div>
      <div class="well">
        <p>${errorUpdateEmployeeDataMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

</body>
</html>