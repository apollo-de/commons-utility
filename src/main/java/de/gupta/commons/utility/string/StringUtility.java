package de.gupta.commons.utility.string;

public final class StringUtility
{
	private StringUtility()
	{
	}

	private static boolean startsWithUppercase(String text)
	{
		return !text.isEmpty() && Character.isUpperCase(text.charAt(0));
	}

	private static boolean hasValidJavaClassNameFormat(String domainName)
	{
		boolean expectLower = true;

		for (int i = 0; i < domainName.length(); i++)
		{
			char c = domainName.charAt(i);

			// Only letters allowed (no special characters or numbers)
			if (!Character.isLetter(c))
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
			}
		}

		return true;
	}
}