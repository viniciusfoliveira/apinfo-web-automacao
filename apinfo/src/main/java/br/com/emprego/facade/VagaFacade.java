package br.com.emprego.facade;

import br.com.emprego.pages.VagaPage;

public class VagaFacade {

	private VagaPage vagaPage;
	
	public VagaFacade (VagaPage vagaPage) {
		this.vagaPage = vagaPage;
	}
	
	public void buscarVagas(String cargo) {
		vagaPage.setBusca(cargo);
		vagaPage.getPesquisa().click();
	}
	
	public void clickPagina() {
		vagaPage.getPagina().click();
	}
}
