<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>menumonitor</title>
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
       <h1>MENU MONITOR</h1><br>
       <nav class="menu">
           <ul>
             <li>Cadastrar
              <ul>
                <a href="CadCliente.jsp"> <li>Cadastrar Cliente</li> </a>
                <a href="CadMonitor.jsp"> <li>Cadastrar Monitor</li> </a>
                <a href="CadServico.jsp"> <li>Cadastrar Serviço</li> </a>
              </ul>
             </li>
             <li>Alterar
              <ul>
                <a href="EdCliente.jsp"> <li>Alterar Cliente</li> </a>
                <a href=""EdMonitor.jsp""> <li>Alterar Monitor</li> </a>
                <a href="EdServico.jsp"> <li>Alterar Serviço</li> </a>
              </ul>
             <li>Excluir
               <ul>
                <a href="ExCarro.html"> <li>Excluir Cliente</li> </a>
                <a href="ExMonitor.html"> <li>Excluir Monitor</li> </a>
                <a href="ExServico.html"> <li>Excluir Serviço</li> </a>
               </ul>
             </li>
             <a href="clicontroller.do?acao=lis"><li>Lista de Clientes</li>
             <a href="monicontroller.do?acao=lis"><li>Lista de Monitores</li>
             <a href="Telalogin.html"><li>Sair</li>
           </ul>
       </nav>
</body>
</html>
                
              