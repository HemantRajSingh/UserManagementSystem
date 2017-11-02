package com.softech.usermanagement.validator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private Pattern emailPattern;
	private Pattern phonePattern;
	private Pattern alphabetPattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String PHONE_PATTERN= "\\d{10}";
	
	private static final String ALPHABET_PATTERN = "^[a-zA-Z]+$";

	public Validator() {
		emailPattern = Pattern.compile(EMAIL_PATTERN);
		phonePattern= Pattern.compile(PHONE_PATTERN);
		alphabetPattern = Pattern.compile(ALPHABET_PATTERN);
	}

	
	public boolean validateEmail(final String email) {

		matcher = emailPattern.matcher(email);
		return matcher.matches();

	}
	
	public boolean validatePhone(final String phone){
		matcher = phonePattern.matcher(phone);
		return matcher.matches();
	}
	
	public boolean validateAlphabet(final String alphabet){
		matcher = alphabetPattern.matcher(alphabet);
		return matcher.matches();
	}
	
	
	public boolean validateFutureDate(String userDate) {
		boolean isDateFuture = false;
		if(userDate != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 Date date1=new Date();
		try {
			date1 = sdf.parse(userDate);
		} catch (ParseException e) {
			
		}
		 Date today = new Date ();
		 isDateFuture = date1.compareTo(today)>0;
	} 
		 return isDateFuture;
		 
	}
	
	
}