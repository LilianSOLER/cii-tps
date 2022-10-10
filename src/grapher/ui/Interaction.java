package grapher.ui;

import java.awt.event.*;
import java.awt.Point;

public class Interaction implements MouseListener, MouseMotionListener, MouseWheelListener {
	private State state;
	private Grapher grapher;
	//enum State { UP, CLIC_OR_DRAG, DRAG } // possible states
	   Point p; // mouse pressed position
	   static final int D_DRAG = 5; // dragging max distance
	  
	public Interaction() {
		state = State.Default;
		this.grapher=grapher;

	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
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
		System.out.println("mouseClicked: " + state);
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		switch (mouseEvent.getButton()) {
			case MouseEvent.BUTTON1:
				state = State.PressedLeft;
				break;
			case MouseEvent.BUTTON2:
				state = State.PressedWheel;
				break;
			case MouseEvent.BUTTON3:
				state = State.PressedRight;
				break;
		}
		System.out.println("mousePressed: " + state);
		/*switch(state) {
	      case UP:
	         p = e.getPoint();
	         state = State.CLIC_OR_DRAG;
	         break;
	      default: 
	         throw new RuntimeException();
	      }	*/
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		switch (state) {
			case PressedLeft:
				this.grapher.zoom(mouseEvent.getPoint(), 5);
				break;
			case PressedRight:
				this.grapher.zoom(mouseEvent.getPoint(), -5);
				break;
		}
		state = State.Default;
		System.out.println("mouseReleased: " + state);
		/*switch(state) {
	      case CLIC_OR_DRAG:
	         state = State.UP;
	         break;
	      case DRAG:
	         state = State.UP;
	         break;
	      default: 
	         throw new RuntimeException();
	      }*/
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		switch (mouseEvent.getButton()) {
			case MouseEvent.BUTTON1:
				state = State.DraggedLeft;
				break;
			case MouseEvent.BUTTON2:
				state = State.DraggedWheel;
				break;
		}
		System.out.println("mouseDragged: " + state);
		
		/*switch(state) {
	      case CLIC_OR_DRAG:
	         if(p.distance(e.getPoint()) > D_DRAG) {
	            state = State.DRAG;
	         }
	         break;
	      case DRAG:
	    	  if (e.getButton()==e.BUTTON1) {
	         Point n = e.getPoint(); // new position
	         grapher.translate( n.x-p.x, n.y-p.y);
	         p = n;
	    	  } 
	    	  else if (e.getButton()==e.BUTTON2){
	    		  
	    	  }
	         break;
	      default: 
	         throw new RuntimeException();
	      }*/
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		System.out.println("mouseMoved: " + state);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		if (state != State.DraggedWheel) {
			state = State.DraggedWheel;
		}

		switch (mouseWheelEvent.getWheelRotation()) {
			case 1:
				this.grapher.zoom(mouseWheelEvent.getPoint(), -5);
				break;
			case -1:
				this.grapher.zoom(mouseWheelEvent.getPoint(), 5);
				break;
		}

		System.out.println("mouseWheelMoved: " + state);
		System.out.println("mouseWheelMoved: " + mouseWheelEvent.getWheelRotation());
	}

	public void setGrapher(Grapher grapher) {
		this.grapher = grapher;
	}
}
