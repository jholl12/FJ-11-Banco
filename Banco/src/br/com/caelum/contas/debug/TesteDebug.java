package br.com.caelum.contas.debug;

public class TesteDebug {
	public static void main(String[] args) {
		String name = "Java";
		printChars(name);
	}

	private static void printChars(String name) {
		char[] chars = name.toCharArray();
		for(int i = 0; i <= chars.length; i++){
			System.out.println(chars[i]);
		}
	}
}
