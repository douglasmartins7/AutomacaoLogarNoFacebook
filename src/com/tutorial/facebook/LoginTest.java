package com.tutorial.facebook;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	WebDriver driver;

	@Before
	public void inicializar() {

		// Utilizando o driver do Chrome

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Douglas Martins\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void verificarLogin() {
		// Acessando o site do Facebook
		driver.get("https://pt-br.facebook.com");

		// Capturando os elementos de email e senha pelo atributo name
		WebElement txtEmail = driver.findElement(By.name("email"));
		WebElement txtSenha = driver.findElement(By.name("pass"));

		// Setando valores nos atributos de email e senha
		txtEmail.sendKeys("dougprogrammer@gmail.com");
		txtSenha.sendKeys("xx");

		// Capturando o elemento do botão entrar
		WebElement btnEntrar = driver.findElement(By.id("u_0_m"));

		// Efetuando um click no botão
		btnEntrar.click();

		// Verifica se o nome do Perfil está no fonte da página
		boolean erroPerfil = driver.getPageSource().contains("Seu nome no perfil");
		assertFalse(erroPerfil);
	}

	@Test
	public void verificarEmail() {

		// Acessando o site do facebook
		driver.get("https://pt-br.facebook.com");

		// Capturando os elementos do email e senha pelo atributo name
		WebElement txtEmail = driver.findElement(By.name("email"));
		WebElement txtSenha = driver.findElement(By.name("pass"));

		// Setando valores nos atributos de email e senha

		txtEmail.sendKeys("XX");
		txtSenha.sendKeys("XX");

		// Capturando o elemento do botão entrar
		WebElement btnEntrar = driver.findElement(By.id("u_0_m"));

		// Efetuando um click no botão
		btnEntrar.click();

		boolean erroEmail = driver.getPageSource().contains("The email or phone number you’ve entered doesn’t match any account");
		assertFalse(erroEmail);
	}
	
	@Test
	public void verirficarSenha() {
		// Acessando o site di facebook
				driver.get("https://pt-br.facebook.com");

				// Capturando os elementos do email e senha pelo atributo name
				WebElement txtEmail = driver.findElement(By.name("email"));
				WebElement txtSenha = driver.findElement(By.name("pass"));

				// Setando valores nos atributos de email e senha

				txtEmail.sendKeys("dougprogrammer@gmail.com");
				txtSenha.sendKeys("XX");

				// Capturando o elemento do botão entrar
				WebElement btnEntrar = driver.findElement(By.id("u_0_m"));

				// Efetuando um click no botão
				btnEntrar.click();

				// Verifica se o código font da página contém a mensagem de erro da senha
				boolean erroSenha = driver.getPageSource().contains("Digite sua senha novamente");
				assertFalse(erroSenha);
	}

	@After
	public void finalizar() {
		driver.close();
	}

}
