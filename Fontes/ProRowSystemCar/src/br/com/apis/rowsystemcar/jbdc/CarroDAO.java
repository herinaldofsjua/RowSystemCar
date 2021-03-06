package br.com.apis.rowsystemcar.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.apis.rowsystemcar.entidades.*;

public class CarroDAO {
	private Connection conexao = Conexao.getConnection();
	private void cadastrar(Carro carro) {

		String consultasql = "inset into carro (marca,modelo,cor,placa) values(?,?,?,?)";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			
			preparador.setString(1, carro.getMarca());
			preparador.setString(2, carro.getModelo());
			preparador.setString(3, carro.getCor());
			preparador.setString(4, carro.getPlaca());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com Suscesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!" + e.getMessage());
		}

	}
	private void alterar(Carro carro) {
		
		String consultasql = "update carro set  cor=?, placa=?  WHERE placa=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setString(1, carro.getCor());
			preparador.setString(2, carro.getPlaca());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "alterado com Sucesso!");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao alterar!" + e.getMessage());
		}
		
	}
	
	public void excluir(Carro carro) {
		String consultasql = "DELETE FROM carro WHERE placa=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setString(1, carro.getPlaca());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Carro n�o existe!" + e.getMessage());
		}
	}
}
