package br.com.emprego.pages;


import static br.com.emprego.apinfo.Driver.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VagaPage {

	public static void inicializaPagina() {
		getDriver().get("https://www.apinfo.com/apinfo/");
	}
	
	public static void finalizar() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
	
	public void setBusca(String cargo) {
		getDriver().findElement(By.id("i-busca")).sendKeys(cargo);
	}

	public WebElement getPesquisa() {
		return getDriver().findElement(By.id("btn-busca"));
	}
	
	public WebElement getEsperaElementoSincronismo() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vagas")));
	}

	public WebElement getVagas() {
		return getDriver().findElement(By.id("vagas"));

	}
	
	public List<WebElement> getListarVagas() {
		return getVagas().findElements(By.className("box-vagas"));
	}
	
	public List<WebElement> getListarTodasDescricao(WebElement elemento){
		  return elemento.findElements(By.xpath("//p[@style]"));

	}

	public List<WebElement> getListarTodosCodigoEmpresa(WebElement elemento) {
		return elemento.findElements(By.xpath("//div[@class='texto']/child::p[2]"));
	}

	public String getTitulo() {
		return getDriver().findElement(By.className("title")).getText();
	}
	
	public String getCargo(WebElement elemento) {
		return elemento.findElement(By.className("cargo")).getText();
	}
	
	public String [] getPaginas() {
		return getDriver().findElement(By.className("n-paginas")).getText().split(" ");
	}
	
	public String [] getLocalizacaoData(WebElement elemento) {
		return elemento.findElement(By.className("info-data")).getText().split("-");  
    }
	
	public void setPagina(String valor) {
		
		getDriver().findElement(By.name("pag")).sendKeys(valor);
	}
	
	
	public WebElement getPagina() {
		return getDriver().findElement(By.xpath("//input[@value='OK']"));
	}
}