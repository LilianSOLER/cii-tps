package grapher.ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class Interaction implements MouseListener, MouseMotionListener, MouseWheelListener, ListSelectionListener {
	static final int distDrag = 10; // minimum distance for drag
	private static Grapher grapher; // the grapher to interact with
	private Point pressedPosition; // position of the mouse when pressed
	private State state; // current state of the interaction

	private int selectedFunction; // index of the selected function in the list

	public Interaction() {
		state = State.Default;
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		System.out.println("mouseClicked: " + state);
		switch (mouseEvent.getButton()) {
			case MouseEvent.BUTTON1:
				state = State.ClickedLeft;
				break;
			case MouseEvent.BUTTON2:
				state = State.ClickedWheel;
				break;
			case MouseEvent.BUTTON3:
				state = State.ClickedRight;
				break;
		}
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		System.out.println("mousePressed: " + state);
		switch (mouseEvent.getButton()) {
			case MouseEvent.BUTTON1:
				state = State.PressedLeft;
				pressedPosition = mouseEvent.getPoint();
				break;
			case MouseEvent.BUTTON2:
				state = State.PressedWheel;
				break;
			case MouseEvent.BUTTON3:
				state = State.PressedRight;
				pressedPosition = mouseEvent.getPoint();
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		System.out.println("mouseReleased: " + state);
		switch (state) {
			case PressedLeft:
				grapher.zoom(mouseEvent.getPoint(), 5);
				break;
			case PressedRight:
				grapher.zoom(mouseEvent.getPoint(), -5);
				break;
			case DraggedRight:
				grapher.zoom(pressedPosition, mouseEvent.getPoint());
				break;
		}
		state = State.Default;
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		System.out.println("mouseEntered: " + state);
	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		System.out.println("mouseExited: " + state);
	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		System.out.println("mouseDragged: " + state);
		//TODO: implement dragging through Benjamin's comments
		switch (state) {
			case PressedLeft:
			case DraggedLeft:
				if (mouseEvent.getPoint().distance(pressedPosition) > distDrag) {
					state = State.DraggedLeft;
					grapher.translate((mouseEvent.getPoint().x - pressedPosition.x) / distDrag, (mouseEvent.getPoint().y - pressedPosition.y) / distDrag);
				}
				break;
			case PressedWheel:
				state = State.DraggedWheel;
				break;
			case PressedRight:
			case DraggedRight:
				if (mouseEvent.getPoint().distance(pressedPosition) > distDrag) {
					state = State.DraggedRight;
					displayDottedRectangle(pressedPosition, mouseEvent.getPoint());
				}
				break;
		}
	}

	private void displayDottedRectangle(Point pressedPosition, Point point) {
		System.out.println("displayDottedRectangle");
		grapher.displayDottedRectangle(pressedPosition, point);
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		System.out.println("mouseMoved: " + state);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		System.out.println("mouseWheelMoved: " + state);
		System.out.println("mouseWheelMoved: " + mouseWheelEvent.getWheelRotation());
		if (state != State.DraggedWheel) {
			state = State.DraggedWheel;
		}

		switch (mouseWheelEvent.getWheelRotation()) {
			case 1:
				grapher.zoom(mouseWheelEvent.getPoint(), -5);
				break;
			case -1:
				grapher.zoom(mouseWheelEvent.getPoint(), 5);
				break;
		}
	}

	public void setGrapher(Grapher g) {
		grapher = g;
	}

	@Override
	public void valueChanged(ListSelectionEvent listSelectionEvent) {
		System.out.println("valueChanged");
		if (!listSelectionEvent.getValueIsAdjusting()) {
			JList source = (JList) listSelectionEvent.getSource();
			int index = source.getSelectedIndex();
			String selected = source.getSelectedValue().toString();
			System.out.println("Selected: " + selected + " at index: " + index);
			changeSelectedFunction(Color.BLUE, 3, index);
		}
	}

	private void changeSelectedFunction(Color color, int thickness, int index) {
		if (selectedFunction != index) {
			grapher.setColors(Color.BLACK, selectedFunction);
			grapher.setThickness(1, selectedFunction);
			selectedFunction = index;
			grapher.setColors(color, selectedFunction);
			grapher.setThickness(thickness, selectedFunction);
			grapher.repaint();
		}
	}
}
