/* grapher.fc.Test
 * (c) blanch@imag.fr 2021–                                                */


package grapher.fc;


// main that tests grapher.fc functionalities

public class Test {
	public static void main(String argv[]) {
		for(String expression : argv) {
			Function f = FunctionFactory.createFunction(expression);
			System.out.println("x, " + f);
			for(double x = 0.; x <= 1.; x += .1) {
				System.out.println(x + ", " + f.y(x));
			}
		}
	}
}
