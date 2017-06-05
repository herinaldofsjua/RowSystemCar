<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@page import="br.com.apis.rowsystemcar.entidades.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>menucliente</title>
<style type="text/css">

h1{

text-align: center; color: blue;

}
body{ 

    background-color: lightblue;

}
.menu ul li{
  background-color: #c61d1d;
  color: white;
  float: left;
  width: 150px;
  height: 30px;
  display: inline-block;
  text-align: center;
  line-height: 100px
  font-size: 20 px; 
  position: relative; 
} 
.menu ul li:HOVER{
   background-color: #07014c;
}
.menu ul {
   padding: 0;
}
.menu ul ul{
   display: none;
}
.menu ul li:hover > ul{
    display: block;
}
</style>
</head>
<body>
       <img  id="image-1" alt="" src="fotos/LogoRowSystemCar.gif" width="300"/>
       <h1>MENU DO CLIENTE</h1><br>
       <nav class="menu">
           <ul>
             <li>CARRO
                <ul>
                   <a href="CadCarro.html"> <li>Cadastrar um Carro</li> </a>
                   <a href="EdCarro.html"> <li>Alterar um Carro</li> </a>
                   <a href="ExCarro.html"> <li>Excluir Carro</li> </a>
                   <a href="AdCarroFila.html"> <li>Adicionar Carro a Fila</li> </a>
                </ul>
             </li>
             <li>Serviço
                 <ul>
                   <a href="AdServicoCarro.html"> <li>Adicionar Serviço ao Carro</li>
                   <a href="CanServico.html"> <li>Cancelar Serviço</li>
                 </ul>
             </li>
                  
                   <a href="VisFila.jsp"><li>Visualizar Fila</li>
                   <a href="EdCliente.jsp"><li>Alterar Conta</li>
                   <a href="ExCliente.html"><li>Excluir Conta</li>
                   <a href="TelaLogin.html"><li>Sair</li>          
           </ul>
       </nav>
</body>
</html>             