package TreePackage;

public class Logger {
	public void printlns(Object... values) {
		for(Object val:values) {
			System.out.println(val.toString());
		}
	}
	public void println(Object... values) {
		for(Object val:values) {
			System.out.print(val.toString() +" ");
		}
		System.out.print('\n');
	}
}
