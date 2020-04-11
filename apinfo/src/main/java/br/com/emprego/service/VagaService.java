package br.com.emprego.service;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebElement;

import br.com.emprego.entidades.Vaga;
import br.com.emprego.pages.VagaPage;
import br.com.emprego.repository.impl.VagaRepositoryImpl;
import br.com.empregos.repository.VagaRepository;

public class VagaService {

	
	private VagaRepository vagasDAO = new  VagaRepositoryImpl();

	private VagaPage vagaPage = new VagaPage();
	
	public void salvar(Vaga vagas) throws Exception {
		vagasDAO.salvar(vagas);
	}

	public void crawlerVagas() throws Exception {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		String[] listaTexto = vagaPage.getPaginas();

		int paginas = 1;

		while (paginas <= Integer.parseInt(listaTexto[3])) {
			
			vagaPage.getEsperaElementoSincronismo();
			
			int i = 0, j = 0;

			for (WebElement elemento : vagaPage.getListarVagas()) {

				Vaga vaga = new Vaga();

				vaga.setCapital(vagaPage.getLocalizacaoData(elemento)[0]);

				vaga.setEstado(vagaPage.getLocalizacaoData(elemento)[1]);

				vaga.setData(sdf1.parse(vagaPage.getLocalizacaoData(elemento)[2]));

				vaga.setCargo(vagaPage.getCargo(elemento));

				while (i < vagaPage.getListarTodasDescricao(elemento).size()) {
					vaga.setDescricao(vagaPage.getListarTodasDescricao(elemento).get(i).getText());
					i++;
					break;
				}

				while (j < vagaPage.getListarTodosCodigoEmpresa(elemento).size()) {
					String[] empresas = vagaPage.getListarTodosCodigoEmpresa(elemento).get(j).getText().split(" ");
					vaga.setEmpresa(empresas[2]);
					j++;
					break;
				}

				this.salvar(vaga);
			}

			vagaPage.clickPagina();
			paginas++;
		}

	}
}
