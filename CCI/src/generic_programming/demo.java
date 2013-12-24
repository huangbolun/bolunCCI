package generic_programming;

public class demo {
	
	public void func() {
		
		Number[] a = new Number[100];
		for (Number e : a) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		demo d = new demo();
		d.func();
	}
	
}