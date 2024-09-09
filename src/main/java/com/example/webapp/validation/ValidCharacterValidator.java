package com.example.webapp.validation;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidCharacterValidator implements ConstraintValidator<ValidCharacter, String>{
	
	// 正規表現パターン（例として、ここでは簡略化しています）
    // JIS X 0201 文字種、JIS X 0208の指定された区点の範囲の文字を含む
    //private static final Pattern VALID_CHAR_PATTERN = Pattern.compile("^[\\u0020-\\u007E\\uFF61-\\uFF9F\\u3040-\\u309F\\u30A0-\\u30FF\\u4E00-\\u9FFF\\u3400-\\u4DBF\\u20000-\\u2A6DF\\u2A700-\\u2B73F\\u2B740-\\u2B81F\\u2B820-\\u2CEAF\\uF900-\\uFAFF\\u2F800-\\u2FA1F]+$");
    private static final String[] allowedCharacters = {"\\u0020","\\u007E","\\u30bf"};
	private static Pattern pattern;
    
    @Override
    public void initialize(ValidCharacter constraintAnnotation) {
    	String s = "["+String.join("", allowedCharacters)+"]*";
    	pattern = Pattern.compile(s);
        
    }

    

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO 自動生成されたメソッド・スタブ
		if(value == null) {
			return true;
		}
		return pattern.matcher(value).matches();
	}

}
