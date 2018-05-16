package br.com.furb.exception;

/**
 *
 * @author matheus.raymundo
 */
public class CombustivelInvalidoException extends ParseCarroException {

    public CombustivelInvalidoException(int linha, String campo) {
        super(String.format("erro na linha %d - combust�vel inv�lido: %s", linha, campo));
    }

}
