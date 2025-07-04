package de.gupta.commons.utility.string;

import java.util.Optional;

public final class StringFormatUtility
{
	private StringFormatUtility()
	{
	}

	public static boolean startsWithUppercase(String text)
	{
		return !text.isEmpty() && Character.isUpperCase(text.charAt(0));
	}

	public static boolean hasValidJavaClassNameFormat(String domainName)
	{
		return Optional.ofNullable(domainName)
					   .filter(StringFormatUtility::startsWithUppercase)
					   .filter(name -> name.chars().allMatch(c -> Character.isLetter(c) && c <= 127))
					   .filter(name -> name.length() == 1 || name.chars().anyMatch(Character::isLowerCase))
					   .isPresent();
	}
}