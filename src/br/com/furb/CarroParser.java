package br.com.furb;

import java.util.ArrayList;

import br.com.furb.gals.LexicalError;
import br.com.furb.gals.Lexico;
import br.com.furb.gals.Token;

public class CarroParser {

	public static StringBuilder processar(String entrada) throws LexicalError {
		ArrayList<String> result = new ArrayList<>();
		Carro carro = new Carro();
		int i = 0;

		Lexico lexico = new Lexico();
		Token token = null;

		for (String line : entrada.split("\n|\r\n")) {
			++i; // incrementa a linha, para aparecer no stack
			lexico.setInput(line);
			while ((token = lexico.nextToken(i)) != null) {
				StringBuilder sb = new StringBuilder().append(i).append("   ").append(token.getLexeme()).append("   ")
						.append(getNameById(carro, token.getId()));
				result.add(sb.toString());
			}
		}

		StringBuilder sb = new StringBuilder().append("Dados analisados").append(System.getProperty("line.separator"));
		for (String string : result) {
			sb.append(string).append(System.getProperty("line.separator"));
		}

		return sb;
	}

	private static String getNameById(Carro carro, int id) {
		switch (id) {
		case 2: // é motor
			return "Motor";
		case 3: // é ano
			return "Ano";
		case 4: // é valor
			return "Valor";
		case 5: // é km
			return "KM";
		case 6: // é chassi
			return "Chassi";
		case 7: // é placa
			return "Placa";
		case 8: // é marcaModelo
			return "Marca ou Modelo";
		case 9: // é alcool
		case 10: // é bicombustivel
		case 11: // é diesel
		case 12: // é gasolina
			return "Combustível";
		}
		return "";
	}

}
