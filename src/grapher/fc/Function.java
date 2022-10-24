/* grapher.fc.Function
 * (c) blanch@imag.fr 2021–2023                                            */


package grapher.fc;


// function as expected by grapher.ui.Grapher

public interface Function {

	String toString();  // text representation of the function

	double y(double x); // function computation
}
