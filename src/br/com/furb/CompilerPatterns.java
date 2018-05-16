package br.com.furb;

import java.util.regex.Pattern;

public enum CompilerPatterns {
	
	CHECK_ZERO_BEFORE("(^0+[0-9]|R\\$0+[1-9])"),
	
	CHECK_ENGINE("[0-9]\\.[0-9]$"),
	
	CHECK_YEAR("^[0-9]{4}$"),
	
	CHECK_KM("^([0-9]{1,3}|[0-9]{1,3}\\.[0-9]{3})$"),
	
	CHECK_MONEY("^R\\$([0-9]{1,3}|[0-9]{1,3}\\.[0-9]{1,3}),[0-9]{2}$"),
	
	CHECK_COMB("Álcool|Bicombustível|Diesel|Gasolina"),

	VERIFY_NUMBER("^[0-9]"), // 1
	VERIFY_VALID_SYMBOL("Á|B|D|G|R"), // 2
	VERIFY_COMB("Á|B|D|G"), // 2.1
	VERIFY_MONEY("^R\\$"); // 2.2
	
	private Pattern pattern;
		
	private CompilerPatterns(String regex){
		this.pattern = Pattern.compile(regex);
	}
	
	public Pattern getPattern(){
		return pattern;
	}
}
