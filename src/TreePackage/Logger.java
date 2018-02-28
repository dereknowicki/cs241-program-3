package TreePackage;

public class Logger {
	public static void printlns(Object... values) {
		for(Object val:values) {
			System.out.println(val.toString());
		}
	}
	public static void println(Object... values) {
		for(Object val:values) {
			System.out.print(val.toString() +" ");
		}
		System.out.print('\n');
	}
}
