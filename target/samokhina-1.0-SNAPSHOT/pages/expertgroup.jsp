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
      <title>Assign expert group</title>
  </head>
  <body>
        <h1>Expert group page</h1>

        	<h3>Assign expert group</h3>
        	<table>
        		<tr>
        			<th>ID</th>
        			<th>Start date</th>
        			<th>End date</th>
        			<th>Job type</th>
        			<th>Description</th>
        			<th>Current state</th>
        		</tr>

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
             </tr>
            </table>
        	</table>

        	<div class="form">
        	<form action="jobrequest?action=assignexpertgroup" method="POST">
        		<h3>Choose expert group:</h3>
        		<label for="expertIds">Experts:</label><br>
        		<select name="expertIds" multiple>
        			<c:forEach var="expert" items="${experts}">
                        <option value="${expert.getId()}">
                            <c:out value="${expert.getName()}"/>
                        </option>
                    </c:forEach>
        		</select>
        		<input type="hidden" value="${req.getId()}" name="getReqId"/>
        		<br>
        		<input type="submit" value="Confirm" class="button"></input>
        	</form>
        	</div>
  </body>
</html>