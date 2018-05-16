package br.com.furb.exception;

/**
 *
 * @author matheus.raymundo
 */
public class AtributoInvalidoException extends ParseCarroException {

    public AtributoInvalidoException(int linha, String campo) {
        super(String.format("erro na linha %d - motor, ano ou KM inválido: %s", linha, campo));
    }

}
