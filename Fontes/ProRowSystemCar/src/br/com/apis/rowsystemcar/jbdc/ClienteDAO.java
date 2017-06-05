 package br.com.apis.rowsystemcar.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

import br.com.apis.rowsystemcar.entidades.Cliente;

public class ClienteDAO extends Cliente {

	private Connection conexao = Conexao.getConnection();

	public void cadastrar(Cliente cliente) {

		String consultasql = "INSERT INTO cliente (nome,login,senha,telefone1,telefone2,cidade,bairro,rua,numero,uf,conta)  VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setString(4, cliente.getTelefone1());
			preparador.setString(5, cliente.getTelefone2());
			preparador.setString(6, cliente.getCidade());
			preparador.setString(7, cliente.getBairro());
			preparador.setString(8, cliente.getRua());
			preparador.setString(9, cliente.getNumero());
			preparador.setString(10,cliente.getUf());
			preparador.setString(11,cliente.getConta());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!" + e.getMessage());
		}

	}

	public void alterar(Cliente cliente) {
		String consultasql = "update cliente set nome=?,login=?,senha=?,telefone1=?,telefone2=?, cidade=?, bairro=?, rua=?, numero=?, uf=?  WHERE id=?";

		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
            
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setString(4, cliente.getTelefone1());
			preparador.setString(5, cliente.getTelefone2());
			preparador.setString(6, cliente.getCidade());
			preparador.setString(7, cliente.getBairro());
			preparador.setString(8, cliente.getRua());
     		preparador.setString(9, cliente.getNumero());
			preparador.setString(10,cliente.getUf());
			preparador.setInt(   11,cliente.getId());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Alterar!" + e.getMessage());
		}
	}
	

	public void excluir(Cliente cliente) {
		String consultasql = "DELETE FROM cliente WHERE id=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setInt(1, cliente.getId());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "id n�o existe!" + e.getMessage());
		}
	}

	public List<Cliente> listaClientes() {
		String sql = "SELECT *FROM cliente ";
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone1(resultado.getString("telefone1"));
				cliente.setTelefone2(resultado.getString("telefone2"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setRua(resultado.getString("rua"));
				cliente.setNumero(resultado.getString("numero"));
				cliente.setUf(resultado.getString("uf"));
				cliente.setConta(resultado.getString("conta"));
				lista.add(cliente);

			}

			preparador.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao buscar a lista de clientes!" + e.getMessage());
		}
		return lista;
	}
    
	public Cliente buscarPorId(Integer id) {

		String sql = "SELECT * FROM cliente WHERE id=?";
		Cliente cliente = null;
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) { // se foi para proximo
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone1(resultado.getString("telefone1"));
				cliente.setTelefone2(resultado.getString("telefone2"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setRua(resultado.getString("rua"));
				cliente.setNumero(resultado.getString("numero"));
				cliente.setUf(resultado.getString("uf"));
				cliente.setConta(resultado.getString("conta"));
			}

		} catch (SQLException e) {
			System.out.println("ID n�o encontrado!");
		}
		return cliente;

	}
	
	public List<Cliente> buscarPorNome(String nome) {

		String sql = "SELECT * FROM cliente WHERE nome like ?";
		List<Cliente> lista = new ArrayList<Cliente>() ;
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, nome);
			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) { // se foi para proximo
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone1(resultado.getString("telefone1"));
				cliente.setTelefone2(resultado.getString("telefone2"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setRua(resultado.getString("rua"));
				cliente.setNumero(resultado.getString("numero"));
				cliente.setUf(resultado.getString("uf"));
				cliente.setConta(resultado.getString("conta"));
				lista.add(cliente);			}

		} catch (SQLException e) {
			System.out.println("ID n�o encontrado!");
		}
		return lista;

	}
    
	public Cliente autentificar(Cliente cliente) {

		String sql = "SELECT * FROM cliente WHERE login = ? AND senha = ?";
		Cliente clienteRetorno = null;
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setObject(1, cliente.getLogin());
			preparador.setObject(2, cliente.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) { // se foi para proximo
				clienteRetorno = new Cliente();
				clienteRetorno.setLogin(resultado.getString("login"));
				clienteRetorno.setSenha(resultado.getString("senha"));
			}

		} catch (SQLException e) {
			System.out.println("falha na autenfica��o!");
		}
		return clienteRetorno;

	}
	
	public void salvar(Cliente cliente){
		
		if(cliente.getId()!= null && cliente.getId()!= 0){
	        alterar(cliente);
			
		}else{
			cadastrar(cliente);
		}
		
	}

}
