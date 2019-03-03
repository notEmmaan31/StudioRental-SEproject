package util;

public class Encryption {
	
	private static int[]  keys = {216, 1512, 184, 586, 15,49,432,23,41,534,564,646,1476,245,235,523,52342,123425,645743,356};
	public static String encrypt(String pass) {
		String newPass = "";
		char ch;
		int key = 0;
		for(int i = 0; i < pass.length(); i++) {
			if(key >= keys.length - 1) {
				key = 0;
			}
			ch = pass.charAt(i);
			ch += keys[key];
			newPass += ch;
		}
		return newPass;
	}
	
	public static String decrypt(String pass) {
		String newPass = "";
		char ch;
		int key = 0;
		for(int i = 0; i < pass.length(); i++) {
			if(key >= keys.length - 1) {
				key = 0;
			}
			ch = pass.charAt(i);
			ch -= keys[key];
			newPass += ch;
		}
		return newPass;		
	}
}
