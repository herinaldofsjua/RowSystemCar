<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.apis.rowsystemcar.entidades.*" %>
<%@page import="br.com.apis.rowsystemcar.controller.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title >EDITAR CLIENTE</title>
<style type="text/css">
h1{

text-align: center; color: blue;

}
body{

background-color: lightblue;

}
</style>
</head>
<body>
     
     <img  id="image-1" alt="" src="fotos/LogoRowSystemCar.gif" width="300"/>
     
     <h1>EDITAR CLIENTE</h1>  
      
     <%
     Cliente cliente = (Cliente)  request.getAttribute("cliente"); 
     %>
     
     <form action="clicontroller.do?" method="post">
       
         <label>ID</label>
         <input type="text" readonly="readonly" name="txtid"  maxlength="4" value="<%= cliente.getId() %>" size="4" /><br><br>
         
         <label>*Nome:</label>
         <input type="text" readonly="readonly" name="txtnome"  maxlength="100"  value="<%= cliente.getNome() %>" size="100"/><br><br>
         
         <label>*Login:</label>
         <input type="text" readonly="readonly" name="txtlogin"  maxlength="20"  value="<%= cliente.getLogin() %>" size="20"/>
         
         <label>*Senha:</label>
         <input type="password" name="txtsenha"  maxlength="8"  value="<%= cliente.getSenha() %>" size="8"/><br><br>
         
         <label>*Telefone1:</label>
         <input type="text" name="txttelefone1"  maxlength="11" value="<%= cliente.getTelefone1() %>" size="12"/>
                
         <label>Telefone2:</label>
         <input type="text" name="txttelefone2"  maxlength="11" value="<%= cliente.getTelefone2() %>" size="12"/><br><br>

         <label>*Cidade:</label>
         <input type="text" name="txtcidade"  maxlength="100" value="<%= cliente.getCidade() %>" size="100"/><br><br>
         
		 <label >*Bairro:</label>
         <input type="text" name="txtbairro"  maxlength="50" value="<%= cliente.getBairro() %>" size="55"/><br><br>
         
         <label>*Rua:</label>
         <input type="text" name="txtrua"  maxlength="100" value="<%= cliente.getRua() %>" size="100"/><br><br>
         
         <label>*N�:</label>
         <input type="text" name="txtnumero"  maxlength="4" value="<%= cliente.getNumero() %>" size="4"/>
         
         <label>*UF:</label>
         <input type="text" name="txtuf"  maxlength="2" value="<%= cliente.getUf() %>" size="2"/><br><br>
        
         <input type="submit" value="Alterar"/>
         <a href="MenuCliente.jsp">Cacelar</a> 
         
     </form>