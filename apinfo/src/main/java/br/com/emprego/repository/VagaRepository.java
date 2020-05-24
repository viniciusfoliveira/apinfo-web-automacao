package br.com.emprego.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.emprego.entidades.Vaga;
import br.com.emprego.utils.Connections;

public interface VagaRepository {

	public void salvar(Vaga vaga);
}
