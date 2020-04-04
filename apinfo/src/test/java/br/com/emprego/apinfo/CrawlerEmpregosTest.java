package br.com.emprego.apinfo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.emprego.facade.VagaFacade;
import br.com.emprego.pages.VagaPage;
import br.com.emprego.service.VagaService;

public class CrawlerEmpregosTest {

	
	public VagaService vagasService = new VagaService();
	
	public VagaPage vagaPage = new VagaPage();
	
	private VagaFacade vagaFacade = new VagaFacade(vagaPage);

	@Before
	public void inicialiaPagina() {
		vagaPage.inicializaPagina();
	}
	
	@Test 
	public void empregosJuniorTest() throws Exception{

		VagaPage.inicializaPagina();
		vagaFacade.buscarVagas("Jr");
		vagasService.crawlerVagas();
		assertEquals("Resultado da pesquisa :", vagaPage.getTitulo());	
	}
	
	@Test 
	public void empregosPlenoTest() throws Exception{

		VagaPage.inicializaPagina();
		vagaFacade.buscarVagas("Pleno");
		vagasService.crawlerVagas();
		assertEquals("Resultado da pesquisa :", vagaPage.getTitulo());	
	}
	
	@Test 
	public void empregosSeniorTest() throws Exception{

		VagaPage.inicializaPagina();
		vagaFacade.buscarVagas("Senior");
		vagasService.crawlerVagas();
		assertEquals("Resultado da pesquisa :", vagaPage.getTitulo());	
	}
	
	@After
	public void finalizarPagina() {
		vagaPage.finalizar();
	}
}
