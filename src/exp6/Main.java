/**
 * @author Pranshu Aggarwal
 * @problem 
 */
package exp6;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n and g: ");
		int n = sc.nextInt();
		int g = sc.nextInt();
		System.out.println("Enter the value of x for the first person: ");
		int x = sc.nextInt();
		int a = (int) power(g, x, n);
		System.out.println("Enter the value of y for the second person: ");
		int y = sc.nextInt();
		int b = (int) power(g, y, n);
		System.out.println("Key for first person is " + " " + (int) power(b,x,n));
		System.out.println("Key for second person is " + " " + (int) power(a,y,n));
	}
	public static long power(int a,int b,int mod) {
		long t;
		if(b == 1) return a;
		t = power(a, b / 2, mod);
		if(b % 2 == 0) return (t * t) % mod;
		else return (((t * t) % mod) * a) % mod;
	}
	public static long calculateKey(int a, int x, int n) {
		return power(a, x, n);
	}
}