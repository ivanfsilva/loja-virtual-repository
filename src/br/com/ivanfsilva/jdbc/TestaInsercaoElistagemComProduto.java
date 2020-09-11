package br.com.ivanfsilva.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ivanfsilva.jdbc.dao.ProdutoDAO;
import br.com.ivanfsilva.jdbc.model.Produto;

public class TestaInsercaoElistagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cama", "Cama kingSize");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaProdutos = produtoDao.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
