<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee Form</title>
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
      <h3>Menu</h3>
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
      <s:form class="form-horizontal" role="form" action="add_employee" method="POST">
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		
		
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="companyModel.employee.users.name" placeholder="Enter name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="address">Address:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="address" name="companyModel.employee.address" placeholder="Enter address">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="companyModel.employee.phone" placeholder="Enter phone">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="passport">Passport:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="passport" name="companyModel.employee.passport" placeholder="Enter passport">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="credit_card">Credit card:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="credit_card" name="companyModel.employee.creditCard" placeholder="Enter credit card">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="companyModel.employee.resume" placeholder="Enter resume"></textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="companyModel.employee.specialization" placeholder="Enter specialization">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="salary">Salary:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="salary" name="companyModel.employee.salary" placeholder="Enter salary">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="recruitment_date">Recruitment date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="recruitment_date" name="companyModel.employee.recruitmentDate" placeholder="Enter recruitment date">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="contract_expiration_date">Contract expiration date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="contract_expiration_date" name="companyModel.employee.contractExpirationDate" placeholder="Enter contract expiration date">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="id_roles">Status:</label>
		    <div class="col-sm-9">
		      <select class="form-control" id="id_roles" name="companyModel.employee.users.roles.id">
	        	<c:forEach var="employeerole" items="${companyModel.rolesList}">
	        	  <option value="${employeerole.id}">${employeerole.role}</option>
	        	</c:forEach>
	          </select>			
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="login">Login:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="login" name="companyModel.employee.users.login" placeholder="Enter login">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="pwd">Password:</label>
		    <div class="col-sm-9"> 
		      <input type="password" class="form-control" id="pwd" name="companyModel.employee.users.password" placeholder="Enter password">
		    </div>    
		  </div>
		 
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Add Employee</button>
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