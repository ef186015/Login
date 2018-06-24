package utils;

public interface LoginPageErrorMessages {
	
	public String notValidEmailErrorText = "This is not a valid email";
	public String emailFieldBlankErrorText = "You left the email field blank";
	public String passwordRequirementErrorText = "Passwords must be 8-64 characters and "
			+ "contain at least one uppercase letter, one lowercase letter, "
			+ "one number, and cannot contain any starting or ending spaces";
	public String passwordFieldBlankErrorText = "You left the password field blank.";
	public String emailDoesNotExistErrorText = "This email doesn't exist in our records";
}
