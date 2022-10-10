/* grapher.ui.Main
 * (c) blanch@imag.fr 2021–2023                                            */

package grapher.ui;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

// main that launch a grapher.ui.Grapher

public class Main extends JFrame {
	Main(String title, String[] expressions, Interaction interaction) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Grapher grapher = new Grapher();
		interaction.setGrapher(grapher);

		for (String expression : expressions) {
			grapher.add(expression);
		}

		add(grapher);

		addMouseListener(interaction);
		addMouseMotionListener(interaction);
		addMouseWheelListener(interaction);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setRightComponent(grapher);
		JList<String> expressionsList = new JList<String>(expressions);
		expressionsList.addMouseListener(new MouseInputListener() {
																			 @Override
																			 public void mouseClicked(MouseEvent mouseEvent) {
																			 }

																			 @Override
																			 public void mousePressed(MouseEvent mouseEvent) {

																			 }

																			 @Override
																			 public void mouseReleased(MouseEvent mouseEvent) {

																			 }

																			 @Override
																			 public void mouseEntered(MouseEvent mouseEvent) {

																			 }

																			 @Override
																			 public void mouseExited(MouseEvent mouseEvent) {

																			 }

																			 @Override
																			 public void mouseDragged(MouseEvent mouseEvent) {

																			 }

																			 @Override
																			 public void mouseMoved(MouseEvent mouseEvent) {

																			 }
																		 }
		);
		expressionsList.setFont(new Font("Monospaced", 1, 12));
		splitPane.setLeftComponent(expressionsList);

		add(splitPane);

		pack();

	}

	public static void main(String[] argv) {
		final String[] expressions = argv;
		Interaction interaction = new Interaction();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main("grapher", expressions, interaction).setVisible(true);
			}
		});
	}
}
