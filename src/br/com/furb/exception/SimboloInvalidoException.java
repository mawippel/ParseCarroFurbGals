package br.com.furb.exception;

/**
 *
 * @author matheus.raymundo
 */
public class SimboloInvalidoException extends ParseCarroException {

    public SimboloInvalidoException(int linha, String campo) {
        super(String.format("erro na linha %d - símbolo(s) inválido(s): %s", linha, campo));
    }

}
