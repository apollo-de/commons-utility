package de.gupta.commons.utility.string;

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
		if (domainName.isEmpty())
		{
			return false;
		}

		boolean expectLower = true;
		boolean hasLowercase = false;

		for (int i = 0; i < domainName.length(); i++)
		{
			char c = domainName.charAt(i);

			// Only ASCII letters allowed (a-z, A-Z)
			if (!Character.isLetter(c) || c > 127)
			{
				return false;
			}

			// First letter must be uppercase
			if (i == 0)
			{
				if (!Character.isUpperCase(c))
				{
					return false;
				}
				expectLower = true;
				continue;
			}

			if (Character.isUpperCase(c))
			{
				// Uppercase in the middle is only allowed for new words
				expectLower = true;
			}
			else if (expectLower)
			{
				// After uppercase, we expect lowercase
				expectLower = false;
				hasLowercase = true;
			}
			else
			{
				hasLowercase = true;
			}
		}

		// Valid Java class names should have at least one lowercase letter (camel case)
		// Special case: a single uppercase letter is also valid
		return hasLowercase || domainName.length() == 1;
	}
}