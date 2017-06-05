package br.com.apis.rowsystemcar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apis.rowsystemcar.entidades.Cliente;
import br.com.apis.rowsystemcar.jbdc.ClienteDAO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet({ "/ClienteController", "/clicontroller.do" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
   
    public ClienteController() {
        super();
        
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//captura parametro da tela
		String acao = request.getParameter("acao");
		ClienteDAO clienteDAO = new ClienteDAO();
		if(acao != null && acao.equals("exc")){//exclui clinte na lista
			//captura parametro id da tela 
			String id = request.getParameter("id");
			
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(id));
			clienteDAO.excluir(cliente);
			response.sendRedirect("clicontroller.do?acao=lis");
			
		}
		if(acao != null && acao.equals("alt")){//chama tela alterar
			//captura parametro da tela
			String id = request.getParameter("id");
			//busca objeto no banco
			Cliente cliente = clienteDAO.buscarPorId(Integer.parseInt(id));
			//seta atributos request com pbjeto cliente 
			request.setAttribute("cliente",cliente);
			//emcaminha objeto cliente para a tela
			RequestDispatcher saida = request.getRequestDispatcher("EdCliente.jsp");
		    saida.forward(request, response);
			
		}
		if(acao != null && acao.equals("lis")){
		
	    List<Cliente> lista = clienteDAO.listaClientes();
	    //engaveta no request a lista
	    request.setAttribute("lista", lista);
	    //encaminha ao JSP
	    RequestDispatcher saida = request.getRequestDispatcher("VisClientes.jsp");
	    saida.forward(request, response);
	    
		}
		if(acao != null && acao.equals("men")){
			
			RequestDispatcher saida = request.getRequestDispatcher("MenuCliente.jsp");
		    saida.forward(request, response);
		    
	    }
		if(acao != null && acao.equals("cad")){//chama tela alterar
			
			Cliente cliente = new Cliente();
			cliente.setId(0);
			cliente.setNome("");
			cliente.setLogin("");
			cliente.setTelefone1("");
			cliente.setTelefone2("");
			cliente.setSenha("");
			cliente.setCidade("");
			cliente.setBairro("");
			cliente.setRua("");
			cliente.setNumero("");
			cliente.setUf("");
			cliente.setConta("");
			request.setAttribute("cliente",cliente);
			
			RequestDispatcher saida = request.getRequestDispatcher("CCliente.jsp");
		    saida.forward(request, response);
			
		}
	    
		
	}
     



   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("txtid");
		String nome= request.getParameter("txtnome");
		String login= request.getParameter("txtlogin");
		String senha= request.getParameter("txtsenha");
		String telefone1= request.getParameter("txttelefone1");
		String telefone2= request.getParameter("txttelefone2");
		String cidade= request.getParameter("txtcidade");
		String bairro= request.getParameter("txtbairro");
		String rua= request.getParameter("txtrua");
		String numero= request.getParameter("txtnumero");
		String uf= request.getParameter("txtuf");
		String conta= request.getParameter("txtconta");
		
	    Cliente cliente = new Cliente();
	    
	 
	    cliente.setId(Integer.parseInt(id));
	    cliente.setNome(nome);
	    cliente.setLogin(login);
	    cliente.setSenha(senha);
	    cliente.setTelefone1(telefone1);
	    cliente.setTelefone2(telefone2);    
	    cliente.setCidade(cidade);
	    cliente.setBairro(bairro);
	    cliente.setRua(rua);
	    cliente.setNumero(numero);
	    cliente.setUf(uf);
	    cliente.setConta(conta);
	    
		ClienteDAO   clienteDAO= new ClienteDAO();
        clienteDAO.salvar(cliente);
		
	}

}
