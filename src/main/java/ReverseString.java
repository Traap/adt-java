class ReverseString {
	public static void main(final String[] args) {
		System.out.println(reverse("Madam, I'm Adam"));
	}

	public static String reverse(final String str) {
		final int length = str.length(), last = length - 1;
		final char[] chars = str.toCharArray();
		for (int ii = 0; ii < (length / 2); ii++) {
			final char ch = chars[ii];
			chars[ii] = chars[last - ii];
			chars[last - ii] = ch;
		}
		return new String(chars);
	}
}
