<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
        <%@include file='style.css'%>
</style>
<%@ page import="java.util.*, java.text.*, ru.rsreu.samokhina.entity.*" %>

<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>User page</title>
  </head>
  <body>
        <h1>User page</h1>

        	<h3>Requests for confirmation</h3>
            <table>
            	<tr>
            		<th>ID</th>
            		<th>Start date</th>
            		<th>End date</th>
            		<th>Job type</th>
            		<th>Description</th>
            		<th>Current state</th>
            		<th>Initiator</th>
            		<th></th>
            		<th></th>
            	</tr>

            <c:forEach var="reqForConfirm" items="${requestsForConfirm}">
              <tr>
               <td>
                <c:out value="${reqForConfirm.getId()}"/>
               </td>
               <td>
                <c:out value="${reqForConfirm.getStartDate()}"/>
               </td>
               <td>
                <c:out value="${reqForConfirm.getEndDate()}"/>
               </td>
               <td>
                <c:out value="${reqForConfirm.getJobType().getTitle()}"/>
               </td>
               <td>
                <c:out value="${reqForConfirm.getDescription()}"/>
               </td>
               <td>
                <c:out value="${reqForConfirm.getState().getTitle()}"/>
               </td>
               <td>Initiator</td>
              <td>
             <form action="jobrequest?action=approverequest" method="POST">
              <input type="submit" value="Confirm" class="button"></input>
              <input type="hidden" value="${reqForConfirm.getId()}" name="getApprovedId"/>
             </form>
             </td>
             <td>
             <form action="jobrequest?action=refuserequest" method="POST">
              <input type="submit" value="Refuse" class="button"></input>
              <input type="hidden" value="${reqForConfirm.getId()}" name="getRefusedId"/>
             </form>
             </td>
             </tr>
            </c:forEach>
            </table>

        	<div class="form">
        	<form action="jobrequest?action=usercreaterequest" method="POST">
        		<h3>Create job request</h3>
        		<label for="startdate">Choose start date:</label><br>
        		<input type="date" name="startdate"></input><br>
        		<label for="enddate">Choose end date:</label><br>
        		<input type="date" name="enddate"></input><br>
        		<label for="jobtype">Choose job type:</label><br>
        		<select name="jobtype">
                <%
                List<JobType> types = (List<JobType>) request.getAttribute("types");
                if (types != null) {
                    for (JobType type : types) {
                        out.println("<option value=" + type.getId() + ">" + type.getTitle() + "</option>");
                    }
                } else out.println("<p>There are no roles yet!</p>");
                %>
                </select>
        		<br>
        		<label for="description">Description:</label><br>
        		<input type="text" name="description"></input><br>
        		<br>
        		<input type="submit" value="Send" class="button"></input>
        	</form>
        	</div>

        	<h3>Your requests</h3>
        	<table>
        		<tr>
        			<th>ID</th>
        			<th>Start date</th>
        			<th>End date</th>
        			<th>Job type</th>
        			<th>Description</th>
        			<th>Current state</th>
        			<th>Initiator</th>
        			<th></th>
        			<th></th>
        		</tr>

        	<c:forEach var="req" items="${requests}">
              <tr>
               <td>
                <c:out value="${req.getId()}"/>
               </td>
               <td>
                <c:out value="${req.getStartDate()}"/>
               </td>
               <td>
                <c:out value="${req.getEndDate()}"/>
               </td>
               <td>
                <c:out value="${req.getJobType().getTitle()}"/>
               </td>
               <td>
                <c:out value="${req.getDescription()}"/>
               </td>
               <td>
                <c:out value="${req.getState().getTitle()}"/>
               </td>
               <td>Initiator</td>
              <td>
             <form action="jobrequest?action=editrequest" method="POST">
              <input type="submit" value="Edit" class="button"></input>
              <input type="hidden" value="${req.getId()}" name="getEditedRequestId"/>
             </form>
             </td>
             <td>
             <form action="jobrequest?action=deleterequest" method="POST">
              <input type="submit" value="Delete" class="button"></input>
              <input type="hidden" value="${req.getId()}" name="getDeletedRequestId"/>
             </form>
             </td>
             </tr>
            </c:forEach>
            </table>
  </body>
</html>