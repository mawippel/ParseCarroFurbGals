package br.com.furb.exception;

/**
 *
 * @author matheus.raymundo
 */
public class ValorInvalidoException extends ParseCarroException {

    public ValorInvalidoException(int linha, String campo) {
        super(String.format("erro na linha %d - valor inválido: %s", linha, campo));
    }

}
