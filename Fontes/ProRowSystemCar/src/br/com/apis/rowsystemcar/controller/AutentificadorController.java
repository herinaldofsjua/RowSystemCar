package br.com.apis.rowsystemcar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.sun.javafx.css.CssError.StringParsingError;

import br.com.apis.rowsystemcar.entidades.Cliente;
import br.com.apis.rowsystemcar.jbdc.ClienteDAO;
import javafx.util.converter.BooleanStringConverter;
import sun.reflect.generics.tree.BottomSignature;
import sun.util.locale.ParseStatus;

/**
 * Servlet implementation class Autentificador
 */
@WebServlet(name = "AutentificadorController", urlPatterns = { "/autcontroller.do" })
public class AutentificadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AutentificadorController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
		}
		response.sendRedirect("TelaLogin.html");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//captura digição da tela           
		String login = request.getParameter("txtlogin");
        String senha = request.getParameter("txtsenha");
        //constroi objeto para consulta.
        Cliente cliente = new Cliente();
        cliente.setLogin(login);
        cliente.setSenha(senha);
        //busca no banco com o DAO
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliRetorno = clienteDAO.autentificar(cliente);
        if(cliRetorno != null){
        	
        	//criando a sessão
        	HttpSession sessao =request.getSession();
        	sessao.setMaxInactiveInterval(30000);//tempo para enserrar sessao
        	sessao.setAttribute("cliLogado", cliRetorno);
        	//encaminhado ao index
        	//request.getRequestDispatcher("MenuMonitor.jsp").forward(request, response);
            request.getRequestDispatcher("MenuCliente.jsp").forward(request, response);	
        	
        	
        }else{
        	JOptionPane.showMessageDialog(null, "Login ou senha estão errados!");
        	response.sendRedirect("TelaLogin.html");
        	
        }
                    
	}

}
