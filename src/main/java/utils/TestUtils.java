package utils;

public class TestUtils {
	
	public static String[] InvalidEmailsArray = new String[]{
			"plainaddress",
			"#@%^%#$@#$@#.com",
			"@example.com",
			"Joe Smith <email@example.com>",
			"email.example.com",
			"email@example@example.com",
			".email@example.com",
			"email.@example.com",
			"email..email@example.com",
			"email@example.com (Joe Smith)",
			"email@example",
			"email@-example.com",
			"email@111.222.333.44444",
			"email@example..com",
			"Abc..123@example.com"
	};
	
	public static String[] InvalidPasswordsArray = new String[] {
		"U+c4U>97pM*SCZGffsb2z^)u&>M#'*AL\"=:7RhkeZxH'!QeSys[8*MZ9K&srR&8dA",
		"Pwd1",
		"Password",
		"PASSWORD1",
		"password1",
		"P@$$WORD",
		" Password123",
		"Password123 "
	};
	
}
