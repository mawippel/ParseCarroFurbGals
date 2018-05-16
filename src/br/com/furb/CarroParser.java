package br.com.furb;

import java.util.regex.Matcher;

import br.com.furb.exception.AtributoInvalidoException;
import br.com.furb.exception.CombustivelInvalidoException;
import br.com.furb.exception.SimboloInvalidoException;
import br.com.furb.exception.ValorInvalidoException;

public class CarroParser {

	public static Carro processar(String entrada) {
		Carro carro = new Carro();
		int i = 0;
		for (String line : entrada.split("\n|\r\n")) {
			++i;
			for (String word : line.split("\\s")) {
				if (word.trim().isEmpty()) {
					continue;
				}

				// VALIDAÇÕES
				Matcher matcherNumber = CompilerPatterns.VERIFY_NUMBER.getPattern().matcher(word);
				if (matcherNumber.find()) { // verifica se é um número
					validateNumber(carro, word, i);
					continue;
				} 

				Matcher matcherSymbol = CompilerPatterns.VERIFY_VALID_SYMBOL.getPattern().matcher(word);
				if (matcherSymbol.find()) { // verifica se é um simbolo válido
					validateSymbol(carro, word, i);
					continue;
				} 

				// Se não entrar nem no Number, nem no Symbol, é um simbolo inválido
				throw new SimboloInvalidoException(i, word);
			}
		}
		return carro;
	}

	private static void validateNumber(Carro carro, String word, int lineNumber) {
		Matcher matcherZeroBefore = CompilerPatterns.CHECK_ZERO_BEFORE.getPattern().matcher(word);
		if (matcherZeroBefore.find()) {
			throw new AtributoInvalidoException(lineNumber, word);
		}

		// valida o Motor
		Matcher matcherNumber = CompilerPatterns.CHECK_ENGINE.getPattern().matcher(word);
		if (matcherNumber.matches()) {
			carro.addQtdMotor();
			return;
		}

		// valida o Ano
		matcherNumber = CompilerPatterns.CHECK_YEAR.getPattern().matcher(word);
		if (matcherNumber.matches()) {
			carro.addQtdAno();
			return;
		}

		// valida o KM
		matcherNumber = CompilerPatterns.CHECK_KM.getPattern().matcher(word);
		if (matcherNumber.matches()) {
			if(200000 >= Integer.parseInt(word.replace(".", ""))){
				carro.addQtdKm();
				return;
			}
		}

		throw new AtributoInvalidoException(lineNumber, word);
	}

	private static void validateSymbol(Carro carro, String word, int lineNumber) {
		// Valida o combustível
		if (checkPattern(CompilerPatterns.VERIFY_COMB, word)) {
			if(checkPattern(CompilerPatterns.CHECK_COMB, word)){
				carro.addQtdCombustivel();
			} else {
				throw new CombustivelInvalidoException(lineNumber, word);
			}
		}
		// Valida o Valor
		if (checkPattern(CompilerPatterns.VERIFY_MONEY, word)) {
			if(checkPattern(CompilerPatterns.CHECK_MONEY, word) && !checkPattern(CompilerPatterns.CHECK_ZERO_BEFORE, word)){
				carro.addQtdValor();
			} else {
				throw new ValorInvalidoException(lineNumber, word);
			}
		}
	}
	
	private static boolean checkPattern(CompilerPatterns compilerPattern, String word){
		Matcher matcher = compilerPattern.getPattern().matcher(word);
		return matcher.find();
	}


}
