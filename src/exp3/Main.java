
package exp3;

public class Main {
	public static void main(String arg[]) {
		String keys = "12";
		String codes = "pranshu";
		StringBuilder result = new StringBuilder();
		char[] codeList = codes.toCharArray();
		char[] keyList = keys.toCharArray();
		int maxCount = keys.length();
		System.out.println("The length is " + maxCount);
		int i = 0;
		for (Character code : codeList) {
			int key = Character.getNumericValue(keyList[i]);
			if (key % 2 == 0)
				result.append((char) (code + key));
			else
				result.append((char) (code - key));
			i++;
			if (i == maxCount)
				i = 0;
		}
		System.out.println("The result is " + result.toString());
	}
}
