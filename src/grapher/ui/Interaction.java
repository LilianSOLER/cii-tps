package grapher.ui;
import java.awt.Point;
import java.awt.event.*;
public class Interaction implements MouseListener,MouseMotionListener,MouseWheelListener {
	enum State { UP, CLIC_OR_DRAG, DRAG } // possible states
	   State state ;               // current state
	   Point p; // mouse pressed position
	   Grapher grapher;
	   static final int D_DRAG = 5; // dragging max distance
	  
	   
	   public Interaction(Grapher grapher) {
		   this.grapher=grapher;
		   state=State.UP;
	   }
	   
	   
	   
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(state) {
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
	      }
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		switch(state) {
	      case UP:
	         p = e.getPoint();
	         state = State.CLIC_OR_DRAG;
	         break;
	      default: 
	         throw new RuntimeException();
	      }		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		switch(state) {
	      case CLIC_OR_DRAG:
	         state = State.UP;
	         break;
	      case DRAG:
	         state = State.UP;
	         break;
	      default: 
	         throw new RuntimeException();
	      }
	   }		
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		switch(state) {
		case CLIC_OR_DRAG:
			break;
		default:
	         throw new RuntimeException();

		
		}
	}
}