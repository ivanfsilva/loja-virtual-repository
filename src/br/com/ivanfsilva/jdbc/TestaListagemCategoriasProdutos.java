package br.com.ivanfsilva.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ivanfsilva.jdbc.dao.CategoriaDAO;
import br.com.ivanfsilva.jdbc.model.Categoria;
import br.com.ivanfsilva.jdbc.model.Produto;

public class TestaListagemCategoriasProdutos {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaCategorias = categoriaDAO.listarComProdutos();
			listaCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}

	}

}
