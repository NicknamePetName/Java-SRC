package test;

public class Test {
	public static void main(String[] args) {
		try {
			method();
		} catch (NullPointerException e) {
			System.out.print("G");
		} catch (Exception e) {
			System.out.print("A");
		} finally {
			System.out.print("B");
		}
	}

	static void method() {
		try {
			wrench();
			System.out.print("C");
		} catch (ArithmeticException e) {
			System.out.print("D");
		} finally {
			System.out.print("E");
		}
		System.out.print("F");
	}

	static void wrench() {
		throw new NullPointerException();
	}
}