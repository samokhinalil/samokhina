<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<style>
        <%@include file='style.css'%>
</style>
<%@ page import="java.util.*, java.text.*, ru.rsreu.samokhina.entity.*" %>

<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Authorization</title>
  </head>
  <body>
        <div class="form">
        <h1>Login</h1>
        <form action="jobrequest?action=login" method="POST">
        <label for="login">Login:</label><br>
        <input type="text" name="login"/>
        <br>
        <label for="password">Password:</label><br>
        <input type="text" name="password"/>
        <br>
        <input type="submit" value="Log in"/>
        </form>
        </div>
  </body>
</html>