package test.java.br.com.furb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import br.com.furb.Carro;
import br.com.furb.CarroParser;
import br.com.furb.exception.ParseCarroException;

import static org.junit.Assert.*;

/**
 *
 * @author marwippel
 */
public class ParseCarroTest {

	public String getConteudo(String nomeExemplo) throws IOException{
		Path path = Paths.get(String.format("src\\test\\resources\\%s.txt", nomeExemplo));
		return new String(Files.readAllBytes(path));
	}

	@Test
	public void exemplo01() throws IOException {
		String conteudo = getConteudo("exemplo1");
		Carro carroProcessado = CarroParser.processar(conteudo);
		Carro carroEsperado = new Carro(2, 1, 2, 3, 4);
		assertEquals(carroEsperado, carroProcessado);
	}

	@Test
	public void exemplo02() throws IOException {
		String conteudo = getConteudo("exemplo2");
		validaExcecao(conteudo, "erro na linha 1 - motor, ano ou KM inválido: 1.");
	}

	@Test
	public void exemplo03() throws IOException {
		String conteudo = getConteudo("exemplo3");
//		validaExcecao(conteudo, "erro na linha 1 - motor, ano ou KM inválido: 201");
	}

	@Test
	public void exemplo04() throws IOException {
		String conteudo = getConteudo("exemplo4");
		validaExcecao(conteudo, "erro na linha 2 - motor, ano ou KM inválido: 6.99");
	}

	@Test
	public void exemplo05() throws IOException {
		String conteudo = getConteudo("exemplo5");
		validaExcecao(conteudo, "erro na linha 3 - valor inválido: R$23.800,0");
	}

	@Test
	public void exemplo06() throws IOException {
		String conteudo = getConteudo("exemplo6");
		validaExcecao(conteudo, "erro na linha 3 - combustível inválido: Álcoo");
	}

	@Test
	public void exemplo07() throws IOException {
		String conteudo = getConteudo("exemplo7");
		validaExcecao(conteudo, "erro na linha 4 - símbolo(s) inválido(s): alcool");
	}

	public void validaExcecao(String conteudo, String mensagemErroEsperada) {
		ParseCarroException exception = null;
		Carro carro = null;
		try {
			carro = CarroParser.processar(conteudo);
		} catch (ParseCarroException e) {
			exception = e;
		}
		String mensagem = String.format("O teste esperava um erro, mas obteve sucesso, %s",
				carro != null ? carro.toString() : null);
		assertNotNull(mensagem, exception);
		assertEquals(exception.getMessage(), mensagemErroEsperada);
	}

}
