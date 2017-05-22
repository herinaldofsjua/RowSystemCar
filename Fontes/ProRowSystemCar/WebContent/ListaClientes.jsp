<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.apis.rowsystemcar.entidades.*" %>
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
   ${request.Scope}
   <div id="divCenter">
   <table border="1" align="center">
   
   
   <tr bgcolor="red">
     <th>ID</th> <th>NOME</th> <th>LOGIN</th> <th>SENHA</th> <th>TELEFONE1</th> <th>TELEFONE2</th> <th>CIDADE</th> <th>BAIRRO</th> <th>RUA</th> <th>Nº</th> <th>UF</th> <th>AÇÂO
   </tr> 
     
 
   <c:forEach items="${requestScope.lista }" var="cli">
 
       <tr bgcolor="white">
           <td>${ cli.Id}</td>
           <td>${ cli.Nome }</td>
           <td>${  cli.Login }</td>
           <td>${  cli.Senha }</td>
           <td>${  cli.Telefone1}</td>
           <td>${  cli.Telefone2 }</td>
           <td>${  cli.Cidade }</td>
           <td>${  cli.Bairro }</td>
           <td>${  cli.Rua }</td>
           <td>${  cli.Numero }</td>
           <td>${  cli.Uf }</td>
           <td> 
           
           <a href="clicontroller.do?acao=exc&id=${ cli.Id}"> Excluir </a>
           |
           <a href="clicontroller.do?acao=alt&id=${ cli.Id}"> Alterar </a> 
           
           </td>
       </tr>
    
    </c:forEach>
    
 </table>
   </div>
</body>
</html>