package br.com.empregos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.emprego.entidades.Vaga;
import br.com.emprego.utils.Connections;

public class VagaDAO {

	public void salvar(Vaga vaga) throws Exception {

		Connection con = Connections.getConexao();
		String sql = "INSERT INTO vaga (estado, capital,data, cargo, descricao, empresa) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vaga.getEstado());
		ps.setString(2, vaga.getCapital());
		ps.setString(3,  vaga.getData().toString());
		ps.setString(4, vaga.getCargo());
		ps.setString(5, vaga.getDescricao());
		ps.setString(6, vaga.getEmpresa());

		// Executa a instrução SQL
		ps.execute();
		ps.close();
	}

}
