package br.com.apis.rowsystemcar.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutentica
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAutentica implements Filter {

 
    public FiltroAutentica() {
     
    }


	public void destroy() {
	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    //Casting HttpServlet request
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url= httpServletRequest.getRequestURI();
		//Capturando sessao
		HttpSession sessao = ((HttpServletRequest) request).getSession();
		//esta logado?
		if(sessao.getAttribute("cliLogado")!= null || url.lastIndexOf("TelaLogin.html")>-1 || url.lastIndexOf("autcontroller.do")>-1  || url.lastIndexOf("CadCliente.jsp")>-1 || url.lastIndexOf("clicontroller.do")>-1 ){
			chain.doFilter(request, response);//permite o fluxo de requisição
		}else{
			//redireciona para tela login
			((HttpServletResponse) response).sendRedirect("TelaLogin.html");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
