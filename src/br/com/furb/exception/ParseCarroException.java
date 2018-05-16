package br.com.furb.exception;

/**
 *
 * @author matheus.raymundo
 */
public abstract class ParseCarroException extends IllegalArgumentException {

    public ParseCarroException(String mensagem) {
        super(mensagem);
    }

}
