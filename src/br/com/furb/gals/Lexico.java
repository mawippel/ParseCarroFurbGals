package br.com.furb.gals;

public class Lexico implements Constants
{
    private int position;
    private String input;

    public Lexico()
    {
        this("");
    }

    public Lexico(String input)
    {
        setInput(input);
    }

    public void setInput(String input)
    {
        this.input = input;
        setPosition(0);
    }

    public void setPosition(int pos)
    {
        position = pos;
    }

    public Token nextToken(int line) throws LexicalError
    {
        if ( ! hasInput() )
            return null;

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput())
        {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0)
                break;

            else
            {
                if (tokenForState(state) >= 0)
                {
                    endState = state;
                    end = position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)) {
        	int index = input.indexOf(" ", start);
			if (index == -1) { //caso seja a última palavra da linha
				index = input.length() - 1;
			}
			String word = input.substring(start, index + 1);
			
			//Se for um erro de Valor inválido, deve pegar a String 'R$' + 'Valor'
			if ("R$".equals(word.trim())) {
				int nextSpace = input.indexOf(" ", index + 1);
				if (nextSpace == -1) { //caso seja a última palavra da linha
					nextSpace = input.length();
				}
				word = word + input.substring(index + 1, nextSpace);
			}
			
			//Caso o erro seja de KM Inválido, deve adicionar o 'km' atrás da kilometragem
			if ("KM inválido".equals(SCANNER_ERROR[lastState]) && !word.contains("km")) {
				word = word + "km";
			}
			
			String message = String.format("erro na linha %d - %s: %s", line, SCANNER_ERROR[lastState], word);
			throw new LexicalError(message);
        }
        

        position = end;

        int token = tokenForState(endState);

        if (token == 0)
            return nextToken(line);
        else
        {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state)
    {
        switch (state)
        {
            case 0:
                switch (c)
                {
                    case 9: return 1;
                    case 10: return 1;
                    case 32: return 1;
                    case 48: return 2;
                    case 49: return 3;
                    case 50: return 4;
                    case 51: return 5;
                    case 52: return 5;
                    case 53: return 5;
                    case 54: return 5;
                    case 55: return 5;
                    case 56: return 5;
                    case 57: return 6;
                    case 65: return 7;
                    case 66: return 7;
                    case 67: return 7;
                    case 68: return 7;
                    case 69: return 7;
                    case 70: return 7;
                    case 71: return 7;
                    case 72: return 7;
                    case 73: return 7;
                    case 74: return 7;
                    case 75: return 7;
                    case 76: return 7;
                    case 77: return 7;
                    case 78: return 7;
                    case 79: return 7;
                    case 80: return 7;
                    case 81: return 7;
                    case 82: return 8;
                    case 83: return 7;
                    case 84: return 7;
                    case 85: return 7;
                    case 86: return 7;
                    case 87: return 7;
                    case 88: return 7;
                    case 89: return 7;
                    case 90: return 7;
                    case 193: return 9;
                    default: return -1;
                }
            case 2:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 3:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 14;
                    case 49: return 14;
                    case 50: return 14;
                    case 51: return 14;
                    case 52: return 14;
                    case 53: return 14;
                    case 54: return 14;
                    case 55: return 14;
                    case 56: return 14;
                    case 57: return 15;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 4:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 16;
                    case 49: return 17;
                    case 50: return 17;
                    case 51: return 17;
                    case 52: return 17;
                    case 53: return 17;
                    case 54: return 17;
                    case 55: return 17;
                    case 56: return 17;
                    case 57: return 17;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 5:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 18;
                    case 49: return 18;
                    case 50: return 18;
                    case 51: return 18;
                    case 52: return 18;
                    case 53: return 18;
                    case 54: return 18;
                    case 55: return 18;
                    case 56: return 18;
                    case 57: return 18;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 6:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 13;
                    case 48: return 18;
                    case 49: return 18;
                    case 50: return 18;
                    case 51: return 19;
                    case 52: return 19;
                    case 53: return 19;
                    case 54: return 19;
                    case 55: return 19;
                    case 56: return 19;
                    case 57: return 19;
                    case 65: return 20;
                    case 66: return 20;
                    case 67: return 20;
                    case 68: return 20;
                    case 69: return 20;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 7:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 21;
                    case 66: return 21;
                    case 67: return 21;
                    case 68: return 21;
                    case 69: return 21;
                    case 70: return 21;
                    case 71: return 21;
                    case 72: return 21;
                    case 73: return 21;
                    case 74: return 21;
                    case 75: return 21;
                    case 76: return 21;
                    case 77: return 21;
                    case 78: return 21;
                    case 79: return 21;
                    case 80: return 21;
                    case 81: return 21;
                    case 82: return 21;
                    case 83: return 21;
                    case 84: return 21;
                    case 85: return 21;
                    case 86: return 21;
                    case 87: return 21;
                    case 88: return 21;
                    case 89: return 21;
                    case 90: return 21;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 8:
                switch (c)
                {
                    case 36: return 22;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 21;
                    case 66: return 21;
                    case 67: return 21;
                    case 68: return 21;
                    case 69: return 21;
                    case 70: return 21;
                    case 71: return 21;
                    case 72: return 21;
                    case 73: return 21;
                    case 74: return 21;
                    case 75: return 21;
                    case 76: return 21;
                    case 77: return 21;
                    case 78: return 21;
                    case 79: return 21;
                    case 80: return 21;
                    case 81: return 21;
                    case 82: return 21;
                    case 83: return 21;
                    case 84: return 21;
                    case 85: return 21;
                    case 86: return 21;
                    case 87: return 21;
                    case 88: return 21;
                    case 89: return 21;
                    case 90: return 21;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 9:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 10:
                switch (c)
                {
                    case 107: return 23;
                    default: return -1;
                }
            case 11:
                switch (c)
                {
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 12:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 13:
                switch (c)
                {
                    case 48: return 24;
                    case 49: return 24;
                    case 50: return 24;
                    case 51: return 24;
                    case 52: return 24;
                    case 53: return 24;
                    case 54: return 24;
                    case 55: return 24;
                    case 56: return 24;
                    case 57: return 24;
                    default: return -1;
                }
            case 14:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 26;
                    case 49: return 26;
                    case 50: return 26;
                    case 51: return 26;
                    case 52: return 26;
                    case 53: return 26;
                    case 54: return 26;
                    case 55: return 26;
                    case 56: return 26;
                    case 57: return 26;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 15:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 27;
                    case 49: return 27;
                    case 50: return 27;
                    case 51: return 27;
                    case 52: return 27;
                    case 53: return 27;
                    case 54: return 27;
                    case 55: return 27;
                    case 56: return 27;
                    case 57: return 27;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 16:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 28;
                    case 49: return 29;
                    case 50: return 29;
                    case 51: return 29;
                    case 52: return 29;
                    case 53: return 29;
                    case 54: return 29;
                    case 55: return 29;
                    case 56: return 29;
                    case 57: return 29;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 17:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 29;
                    case 49: return 29;
                    case 50: return 29;
                    case 51: return 29;
                    case 52: return 29;
                    case 53: return 29;
                    case 54: return 29;
                    case 55: return 29;
                    case 56: return 29;
                    case 57: return 29;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 18:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 30;
                    case 49: return 30;
                    case 50: return 30;
                    case 51: return 30;
                    case 52: return 30;
                    case 53: return 30;
                    case 54: return 30;
                    case 55: return 30;
                    case 56: return 30;
                    case 57: return 30;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 19:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 30;
                    case 49: return 30;
                    case 50: return 30;
                    case 51: return 30;
                    case 52: return 30;
                    case 53: return 30;
                    case 54: return 30;
                    case 55: return 30;
                    case 56: return 30;
                    case 57: return 30;
                    case 65: return 31;
                    case 66: return 31;
                    case 67: return 31;
                    case 68: return 31;
                    case 69: return 31;
                    case 70: return 31;
                    case 71: return 31;
                    case 72: return 31;
                    case 73: return 31;
                    case 74: return 31;
                    case 75: return 31;
                    case 76: return 31;
                    case 77: return 31;
                    case 78: return 31;
                    case 79: return 31;
                    case 80: return 31;
                    case 81: return 31;
                    case 82: return 31;
                    case 83: return 31;
                    case 84: return 31;
                    case 85: return 31;
                    case 86: return 31;
                    case 87: return 31;
                    case 88: return 31;
                    case 89: return 31;
                    case 90: return 31;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 20:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 31;
                    case 66: return 31;
                    case 67: return 31;
                    case 68: return 31;
                    case 69: return 31;
                    case 70: return 31;
                    case 71: return 31;
                    case 72: return 31;
                    case 73: return 31;
                    case 74: return 31;
                    case 75: return 31;
                    case 76: return 31;
                    case 77: return 31;
                    case 78: return 31;
                    case 79: return 31;
                    case 80: return 31;
                    case 81: return 31;
                    case 82: return 31;
                    case 83: return 31;
                    case 84: return 31;
                    case 85: return 31;
                    case 86: return 31;
                    case 87: return 31;
                    case 88: return 31;
                    case 89: return 31;
                    case 90: return 31;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 21:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 22:
                switch (c)
                {
                    case 32: return 33;
                    default: return -1;
                }
            case 23:
                switch (c)
                {
                    case 109: return 34;
                    default: return -1;
                }
            case 24:
                switch (c)
                {
                    case 48: return 35;
                    case 49: return 35;
                    case 50: return 35;
                    case 51: return 35;
                    case 52: return 35;
                    case 53: return 35;
                    case 54: return 35;
                    case 55: return 35;
                    case 56: return 35;
                    case 57: return 35;
                    default: return -1;
                }
            case 25:
                switch (c)
                {
                    case 48: return 36;
                    case 49: return 36;
                    case 50: return 36;
                    case 51: return 36;
                    case 52: return 36;
                    case 53: return 36;
                    case 54: return 36;
                    case 55: return 36;
                    case 56: return 36;
                    case 57: return 36;
                    default: return -1;
                }
            case 26:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 27:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 25;
                    case 48: return 37;
                    case 49: return 37;
                    case 50: return 37;
                    case 51: return 37;
                    case 52: return 37;
                    case 53: return 37;
                    case 54: return 37;
                    case 55: return 37;
                    case 56: return 37;
                    case 57: return 37;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 28:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 46: return 38;
                    case 48: return 37;
                    case 49: return 37;
                    case 50: return 37;
                    case 51: return 37;
                    case 52: return 37;
                    case 53: return 37;
                    case 54: return 37;
                    case 55: return 37;
                    case 56: return 37;
                    case 57: return 37;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 29:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 48: return 37;
                    case 49: return 37;
                    case 50: return 37;
                    case 51: return 37;
                    case 52: return 37;
                    case 53: return 37;
                    case 54: return 37;
                    case 55: return 37;
                    case 56: return 37;
                    case 57: return 37;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 30:
                switch (c)
                {
                    case 32: return 10;
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 31:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 39;
                    case 49: return 39;
                    case 50: return 39;
                    case 51: return 39;
                    case 52: return 39;
                    case 53: return 39;
                    case 54: return 39;
                    case 55: return 39;
                    case 56: return 39;
                    case 57: return 39;
                    case 65: return 39;
                    case 66: return 39;
                    case 67: return 39;
                    case 68: return 39;
                    case 69: return 39;
                    case 70: return 39;
                    case 71: return 39;
                    case 72: return 39;
                    case 73: return 39;
                    case 74: return 39;
                    case 75: return 39;
                    case 76: return 39;
                    case 77: return 39;
                    case 78: return 39;
                    case 79: return 39;
                    case 80: return 39;
                    case 81: return 39;
                    case 82: return 39;
                    case 83: return 39;
                    case 84: return 39;
                    case 85: return 39;
                    case 86: return 39;
                    case 87: return 39;
                    case 88: return 39;
                    case 89: return 39;
                    case 90: return 39;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 32:
                switch (c)
                {
                    case 45: return 40;
                    case 46: return 41;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 33:
                switch (c)
                {
                    case 49: return 42;
                    case 50: return 42;
                    case 51: return 42;
                    case 52: return 42;
                    case 53: return 42;
                    case 54: return 42;
                    case 55: return 42;
                    case 56: return 42;
                    case 57: return 42;
                    default: return -1;
                }
            case 35:
                switch (c)
                {
                    case 48: return 43;
                    case 49: return 43;
                    case 50: return 43;
                    case 51: return 43;
                    case 52: return 43;
                    case 53: return 43;
                    case 54: return 43;
                    case 55: return 43;
                    case 56: return 43;
                    case 57: return 43;
                    default: return -1;
                }
            case 36:
                switch (c)
                {
                    case 48: return 35;
                    case 49: return 35;
                    case 50: return 35;
                    case 51: return 35;
                    case 52: return 35;
                    case 53: return 35;
                    case 54: return 35;
                    case 55: return 35;
                    case 56: return 35;
                    case 57: return 35;
                    default: return -1;
                }
            case 37:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 38:
                switch (c)
                {
                    case 48: return 44;
                    default: return -1;
                }
            case 39:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 45;
                    case 49: return 45;
                    case 50: return 45;
                    case 51: return 45;
                    case 52: return 45;
                    case 53: return 45;
                    case 54: return 45;
                    case 55: return 45;
                    case 56: return 45;
                    case 57: return 45;
                    case 65: return 45;
                    case 66: return 45;
                    case 67: return 45;
                    case 68: return 45;
                    case 69: return 45;
                    case 70: return 45;
                    case 71: return 45;
                    case 72: return 45;
                    case 73: return 45;
                    case 74: return 45;
                    case 75: return 45;
                    case 76: return 45;
                    case 77: return 45;
                    case 78: return 45;
                    case 79: return 45;
                    case 80: return 45;
                    case 81: return 45;
                    case 82: return 45;
                    case 83: return 45;
                    case 84: return 45;
                    case 85: return 45;
                    case 86: return 45;
                    case 87: return 45;
                    case 88: return 45;
                    case 89: return 45;
                    case 90: return 45;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 40:
                switch (c)
                {
                    case 48: return 46;
                    case 49: return 47;
                    case 50: return 47;
                    case 51: return 47;
                    case 52: return 47;
                    case 53: return 47;
                    case 54: return 47;
                    case 55: return 47;
                    case 56: return 47;
                    case 57: return 47;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 41:
                switch (c)
                {
                    case 48: return 48;
                    case 49: return 49;
                    case 50: return 49;
                    case 51: return 49;
                    case 52: return 49;
                    case 53: return 49;
                    case 54: return 49;
                    case 55: return 49;
                    case 56: return 49;
                    case 57: return 49;
                    default: return -1;
                }
            case 42:
                switch (c)
                {
                    case 44: return 50;
                    case 46: return 51;
                    case 48: return 52;
                    case 49: return 52;
                    case 50: return 52;
                    case 51: return 52;
                    case 52: return 52;
                    case 53: return 52;
                    case 54: return 52;
                    case 55: return 52;
                    case 56: return 52;
                    case 57: return 52;
                    default: return -1;
                }
            case 43:
                switch (c)
                {
                    case 32: return 10;
                    default: return -1;
                }
            case 44:
                switch (c)
                {
                    case 48: return 53;
                    default: return -1;
                }
            case 45:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 54;
                    case 49: return 54;
                    case 50: return 54;
                    case 51: return 54;
                    case 52: return 54;
                    case 53: return 54;
                    case 54: return 54;
                    case 55: return 54;
                    case 56: return 54;
                    case 57: return 54;
                    case 65: return 54;
                    case 66: return 54;
                    case 67: return 54;
                    case 68: return 54;
                    case 69: return 54;
                    case 70: return 54;
                    case 71: return 54;
                    case 72: return 54;
                    case 73: return 54;
                    case 74: return 54;
                    case 75: return 54;
                    case 76: return 54;
                    case 77: return 54;
                    case 78: return 54;
                    case 79: return 54;
                    case 80: return 54;
                    case 81: return 54;
                    case 82: return 54;
                    case 83: return 54;
                    case 84: return 54;
                    case 85: return 54;
                    case 86: return 54;
                    case 87: return 54;
                    case 88: return 54;
                    case 89: return 54;
                    case 90: return 54;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 46:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 55;
                    case 49: return 56;
                    case 50: return 56;
                    case 51: return 56;
                    case 52: return 56;
                    case 53: return 56;
                    case 54: return 56;
                    case 55: return 56;
                    case 56: return 56;
                    case 57: return 56;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 47:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 57;
                    case 49: return 58;
                    case 50: return 58;
                    case 51: return 58;
                    case 52: return 58;
                    case 53: return 58;
                    case 54: return 58;
                    case 55: return 58;
                    case 56: return 58;
                    case 57: return 58;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 48:
                switch (c)
                {
                    case 48: return 59;
                    case 49: return 60;
                    case 50: return 60;
                    case 51: return 60;
                    case 52: return 60;
                    case 53: return 60;
                    case 54: return 60;
                    case 55: return 60;
                    case 56: return 60;
                    case 57: return 60;
                    default: return -1;
                }
            case 49:
                switch (c)
                {
                    case 48: return 61;
                    case 49: return 62;
                    case 50: return 62;
                    case 51: return 62;
                    case 52: return 62;
                    case 53: return 62;
                    case 54: return 62;
                    case 55: return 62;
                    case 56: return 62;
                    case 57: return 62;
                    default: return -1;
                }
            case 50:
                switch (c)
                {
                    case 48: return 63;
                    case 49: return 63;
                    case 50: return 63;
                    case 51: return 63;
                    case 52: return 63;
                    case 53: return 63;
                    case 54: return 63;
                    case 55: return 63;
                    case 56: return 63;
                    case 57: return 63;
                    default: return -1;
                }
            case 51:
                switch (c)
                {
                    case 48: return 64;
                    case 49: return 64;
                    case 50: return 64;
                    case 51: return 64;
                    case 52: return 64;
                    case 53: return 64;
                    case 54: return 64;
                    case 55: return 64;
                    case 56: return 64;
                    case 57: return 64;
                    default: return -1;
                }
            case 52:
                switch (c)
                {
                    case 44: return 50;
                    case 46: return 51;
                    case 48: return 65;
                    case 49: return 65;
                    case 50: return 65;
                    case 51: return 65;
                    case 52: return 65;
                    case 53: return 65;
                    case 54: return 65;
                    case 55: return 65;
                    case 56: return 65;
                    case 57: return 65;
                    default: return -1;
                }
            case 53:
                switch (c)
                {
                    case 48: return 43;
                    default: return -1;
                }
            case 54:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 66;
                    case 49: return 66;
                    case 50: return 66;
                    case 51: return 66;
                    case 52: return 66;
                    case 53: return 66;
                    case 54: return 66;
                    case 55: return 66;
                    case 56: return 66;
                    case 57: return 66;
                    case 65: return 66;
                    case 66: return 66;
                    case 67: return 66;
                    case 68: return 66;
                    case 69: return 66;
                    case 70: return 66;
                    case 71: return 66;
                    case 72: return 66;
                    case 73: return 66;
                    case 74: return 66;
                    case 75: return 66;
                    case 76: return 66;
                    case 77: return 66;
                    case 78: return 66;
                    case 79: return 66;
                    case 80: return 66;
                    case 81: return 66;
                    case 82: return 66;
                    case 83: return 66;
                    case 84: return 66;
                    case 85: return 66;
                    case 86: return 66;
                    case 87: return 66;
                    case 88: return 66;
                    case 89: return 66;
                    case 90: return 66;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 55:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 67;
                    case 49: return 68;
                    case 50: return 68;
                    case 51: return 68;
                    case 52: return 68;
                    case 53: return 68;
                    case 54: return 68;
                    case 55: return 68;
                    case 56: return 68;
                    case 57: return 68;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 56:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 69;
                    case 49: return 70;
                    case 50: return 70;
                    case 51: return 70;
                    case 52: return 70;
                    case 53: return 70;
                    case 54: return 70;
                    case 55: return 70;
                    case 56: return 70;
                    case 57: return 70;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 57:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 71;
                    case 49: return 72;
                    case 50: return 72;
                    case 51: return 72;
                    case 52: return 72;
                    case 53: return 72;
                    case 54: return 72;
                    case 55: return 72;
                    case 56: return 72;
                    case 57: return 72;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 58:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 73;
                    case 49: return 74;
                    case 50: return 74;
                    case 51: return 74;
                    case 52: return 74;
                    case 53: return 74;
                    case 54: return 74;
                    case 55: return 74;
                    case 56: return 74;
                    case 57: return 74;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 59:
                switch (c)
                {
                    case 48: return 75;
                    case 49: return 76;
                    case 50: return 76;
                    case 51: return 76;
                    case 52: return 76;
                    case 53: return 76;
                    case 54: return 76;
                    case 55: return 76;
                    case 56: return 76;
                    case 57: return 76;
                    default: return -1;
                }
            case 60:
                switch (c)
                {
                    case 48: return 77;
                    case 49: return 78;
                    case 50: return 78;
                    case 51: return 78;
                    case 52: return 78;
                    case 53: return 78;
                    case 54: return 78;
                    case 55: return 78;
                    case 56: return 78;
                    case 57: return 78;
                    default: return -1;
                }
            case 61:
                switch (c)
                {
                    case 48: return 79;
                    case 49: return 80;
                    case 50: return 80;
                    case 51: return 80;
                    case 52: return 80;
                    case 53: return 80;
                    case 54: return 80;
                    case 55: return 80;
                    case 56: return 80;
                    case 57: return 80;
                    default: return -1;
                }
            case 62:
                switch (c)
                {
                    case 48: return 81;
                    case 49: return 82;
                    case 50: return 82;
                    case 51: return 82;
                    case 52: return 82;
                    case 53: return 82;
                    case 54: return 82;
                    case 55: return 82;
                    case 56: return 82;
                    case 57: return 82;
                    default: return -1;
                }
            case 63:
                switch (c)
                {
                    case 48: return 83;
                    case 49: return 83;
                    case 50: return 83;
                    case 51: return 83;
                    case 52: return 83;
                    case 53: return 83;
                    case 54: return 83;
                    case 55: return 83;
                    case 56: return 83;
                    case 57: return 83;
                    default: return -1;
                }
            case 64:
                switch (c)
                {
                    case 44: return 50;
                    case 48: return 84;
                    case 49: return 84;
                    case 50: return 84;
                    case 51: return 84;
                    case 52: return 84;
                    case 53: return 84;
                    case 54: return 84;
                    case 55: return 84;
                    case 56: return 84;
                    case 57: return 84;
                    default: return -1;
                }
            case 65:
                switch (c)
                {
                    case 44: return 50;
                    case 46: return 51;
                    default: return -1;
                }
            case 66:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 85;
                    case 49: return 85;
                    case 50: return 85;
                    case 51: return 85;
                    case 52: return 85;
                    case 53: return 85;
                    case 54: return 85;
                    case 55: return 85;
                    case 56: return 85;
                    case 57: return 85;
                    case 65: return 85;
                    case 66: return 85;
                    case 67: return 85;
                    case 68: return 85;
                    case 69: return 85;
                    case 70: return 85;
                    case 71: return 85;
                    case 72: return 85;
                    case 73: return 85;
                    case 74: return 85;
                    case 75: return 85;
                    case 76: return 85;
                    case 77: return 85;
                    case 78: return 85;
                    case 79: return 85;
                    case 80: return 85;
                    case 81: return 85;
                    case 82: return 85;
                    case 83: return 85;
                    case 84: return 85;
                    case 85: return 85;
                    case 86: return 85;
                    case 87: return 85;
                    case 88: return 85;
                    case 89: return 85;
                    case 90: return 85;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 67:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 68:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 69:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 70:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 71:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 72:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 73:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 74:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 86;
                    case 49: return 86;
                    case 50: return 86;
                    case 51: return 86;
                    case 52: return 86;
                    case 53: return 86;
                    case 54: return 86;
                    case 55: return 86;
                    case 56: return 86;
                    case 57: return 86;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 75:
                switch (c)
                {
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 76:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 77:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 78:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 79:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 80:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 81:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 82:
                switch (c)
                {
                    case 48: return 87;
                    case 49: return 87;
                    case 50: return 87;
                    case 51: return 87;
                    case 52: return 87;
                    case 53: return 87;
                    case 54: return 87;
                    case 55: return 87;
                    case 56: return 87;
                    case 57: return 87;
                    default: return -1;
                }
            case 84:
                switch (c)
                {
                    case 44: return 50;
                    case 48: return 88;
                    case 49: return 88;
                    case 50: return 88;
                    case 51: return 88;
                    case 52: return 88;
                    case 53: return 88;
                    case 54: return 88;
                    case 55: return 88;
                    case 56: return 88;
                    case 57: return 88;
                    default: return -1;
                }
            case 85:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 89;
                    case 50: return 89;
                    case 51: return 89;
                    case 52: return 89;
                    case 53: return 89;
                    case 54: return 89;
                    case 55: return 89;
                    case 56: return 89;
                    case 57: return 89;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 86:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 88:
                switch (c)
                {
                    case 44: return 50;
                    default: return -1;
                }
            case 89:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 90;
                    case 66: return 90;
                    case 67: return 90;
                    case 68: return 90;
                    case 69: return 90;
                    case 70: return 90;
                    case 71: return 90;
                    case 72: return 90;
                    case 73: return 90;
                    case 74: return 90;
                    case 75: return 90;
                    case 76: return 90;
                    case 77: return 90;
                    case 78: return 90;
                    case 79: return 90;
                    case 80: return 90;
                    case 81: return 90;
                    case 82: return 90;
                    case 83: return 90;
                    case 84: return 90;
                    case 85: return 90;
                    case 86: return 90;
                    case 87: return 90;
                    case 88: return 90;
                    case 89: return 90;
                    case 90: return 90;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 90:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 91;
                    case 66: return 91;
                    case 67: return 91;
                    case 68: return 91;
                    case 69: return 91;
                    case 70: return 91;
                    case 71: return 91;
                    case 72: return 91;
                    case 73: return 91;
                    case 74: return 91;
                    case 75: return 91;
                    case 76: return 91;
                    case 77: return 91;
                    case 78: return 91;
                    case 79: return 91;
                    case 80: return 91;
                    case 81: return 91;
                    case 82: return 91;
                    case 83: return 91;
                    case 84: return 91;
                    case 85: return 91;
                    case 86: return 91;
                    case 87: return 91;
                    case 88: return 91;
                    case 89: return 91;
                    case 90: return 91;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 91:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 92;
                    case 49: return 92;
                    case 50: return 92;
                    case 51: return 92;
                    case 52: return 92;
                    case 53: return 92;
                    case 54: return 92;
                    case 55: return 92;
                    case 56: return 92;
                    case 57: return 92;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 92:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 93;
                    case 49: return 93;
                    case 50: return 93;
                    case 51: return 93;
                    case 52: return 93;
                    case 53: return 93;
                    case 54: return 93;
                    case 55: return 93;
                    case 56: return 93;
                    case 57: return 93;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 93:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 94;
                    case 49: return 94;
                    case 50: return 94;
                    case 51: return 94;
                    case 52: return 94;
                    case 53: return 94;
                    case 54: return 94;
                    case 55: return 94;
                    case 56: return 94;
                    case 57: return 94;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 94:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 95;
                    case 49: return 95;
                    case 50: return 95;
                    case 51: return 95;
                    case 52: return 95;
                    case 53: return 95;
                    case 54: return 95;
                    case 55: return 95;
                    case 56: return 95;
                    case 57: return 95;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 95:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 96;
                    case 49: return 96;
                    case 50: return 96;
                    case 51: return 96;
                    case 52: return 96;
                    case 53: return 96;
                    case 54: return 96;
                    case 55: return 96;
                    case 56: return 96;
                    case 57: return 96;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 96:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 97;
                    case 49: return 97;
                    case 50: return 97;
                    case 51: return 97;
                    case 52: return 97;
                    case 53: return 97;
                    case 54: return 97;
                    case 55: return 97;
                    case 56: return 97;
                    case 57: return 97;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            case 97:
                switch (c)
                {
                    case 45: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 65: return 12;
                    case 66: return 12;
                    case 67: return 12;
                    case 68: return 12;
                    case 69: return 12;
                    case 70: return 12;
                    case 71: return 12;
                    case 72: return 12;
                    case 73: return 12;
                    case 74: return 12;
                    case 75: return 12;
                    case 76: return 12;
                    case 77: return 12;
                    case 78: return 12;
                    case 79: return 12;
                    case 80: return 12;
                    case 81: return 12;
                    case 82: return 12;
                    case 83: return 12;
                    case 84: return 12;
                    case 85: return 12;
                    case 86: return 12;
                    case 87: return 12;
                    case 88: return 12;
                    case 89: return 12;
                    case 90: return 12;
                    case 97: return 12;
                    case 98: return 12;
                    case 99: return 12;
                    case 100: return 12;
                    case 101: return 12;
                    case 102: return 12;
                    case 103: return 12;
                    case 104: return 12;
                    case 105: return 12;
                    case 106: return 12;
                    case 107: return 12;
                    case 108: return 12;
                    case 109: return 12;
                    case 110: return 12;
                    case 111: return 12;
                    case 112: return 12;
                    case 113: return 12;
                    case 114: return 12;
                    case 115: return 12;
                    case 116: return 12;
                    case 117: return 12;
                    case 118: return 12;
                    case 119: return 12;
                    case 120: return 12;
                    case 121: return 12;
                    case 122: return 12;
                    case 237: return 12;
                    default: return -1;
                }
            default: return -1;
        }
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key)
    {
        int start = SPECIAL_CASES_INDEXES[base];
        int end   = SPECIAL_CASES_INDEXES[base+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0)
                return SPECIAL_CASES_VALUES[half];
            else if (comp < 0)
                start = half+1;
            else  //(comp > 0)
                end = half-1;
        }

        return base;
    }

    private boolean hasInput()
    {
        return position < input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return input.charAt(position++);
        else
            return (char) -1;
    }
}
