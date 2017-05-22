 <%@page import="java.util.List"%>
<%@page import="br.com.apis.rowsystemcar.entidades.*" %>
<%@page import="br.com.apis.rowsystemcar.controller.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListadeClientes</title>
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
   <h1>LISTA DE CLIENTES</h1>
   <div id="divCenter">
   <table border="1" align="center">
   
   
   <tr bgcolor="red">
     <th>ID</th> <th>NOME</th> <th>LOGIN</th> <th>SENHA</th> <th>TELEFONE1</th> <th>TELEFONE2</th> <th>CIDADE</th> <th>BAIRRO</th> <th>RUA</th> <th>Nº</th> <th>UF</th> <th>AÇÂO
   </tr> 
     
   <% 
   //Scriptlet
    List<Cliente> lista = (List<Cliente>)  request.getAttribute("lista");
    for(Cliente cli: lista ){
    %>
       <tr bgcolor="white">
           <td><%= cli.getId() %></td>
           <td><%= cli.getNome() %></td>
           <td><%= cli.getLogin() %></td>
           <td><%= cli.getSenha() %></td>
           <td><%= cli.getTelefone1() %></td>
           <td><%= cli.getTelefone2() %></td>
           <td><%= cli.getCidade() %></td>
           <td><%= cli.getBairro() %></td>
           <td><%= cli.getRua() %></td>
           <td><%= cli.getNumero() %></td>
           <td><%= cli.getUf() %></td>
           <td> 
           
           <a href="clicontroller.do?acao=exc&id=<%= cli.getId()%>"> Excluir </a>
           |
           <a href="clicontroller.do?acao=alt&id=<%= cli.getId()%>"> Alterar </a> 
           
           </td>
       </tr>
    
    <% } %>	
    
    
   </table>
   </div>
</body>
</html>