/**
 * @author Pranshu Aggarwal
 * @problem 
 */
package exp4;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
public class Main {
	public static void main(String[] args) throws IOException {
		int bitlength = 1024;
		Random r = new Random();
		BigInteger p = BigInteger.probablePrime(bitlength, r);
		BigInteger q = BigInteger.probablePrime(bitlength, r);
		BigInteger N = p.multiply(q);
		BigInteger z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		BigInteger e = BigInteger.probablePrime(bitlength / 2, r);
		while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0 ) 
			e.add(BigInteger.ONE);
		BigInteger d = e.modInverse(z);
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter the plain text:");
		String msg = in.readLine();
		// encrypt
		int sum = 0, rem = 0;
		byte[] encrypted = new BigInteger(msg.getBytes()).modPow(e, N).toByteArray();
		for(int i = 0; i<encrypted.length; i++)
			sum += (int) (Math.abs(encrypted[i]));
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < String.valueOf(sum).length(); i++) {
			rem = sum % 10;
			sum /= 10;
			sb.append((char)(rem + 97));
		}
		System.out.println("Encrypted text is: " + sb);
		// decrypt
		byte[] decrypted = new BigInteger(encrypted).modPow(d, N).toByteArray();
		System.out.println("Decrypted String: " + new String(decrypted));
	}
}
