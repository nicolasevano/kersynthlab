package gui.impl.subpresentation;
/*  
 * DKnob.java
 * (c) 2000 by Joakim Eriksson
 *  
 * DKnob is a component similar to JSlider but with 
 * round "user interface", a knob. 
 */
//package molette;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;



import javax.swing.*;
import javax.swing.event.*;

public class DKnob extends JComponent
{
	private final static float START = 225;//225, modifie les placements des traits noirs sur le cercle
	private final static float LENGTH = 270;//270,augmente et reduit la zone de déplacement de l'aiguille et la zone de placement des traits 
	private final static float PI = (float) 3.1415;
	private final static float START_ANG = (START/360)*PI*2;//(START/360)*PI*2
	private final static float LENGTH_ANG = (LENGTH/360)*PI*2;
	private final static float DRAG_RES = (float) 0.01;//0.01 à voir, on dirait, pas d'utilité
	private final static float MULTIP = 180 / PI;//180 / PI, à voir
	private final static Color DEFAULT_FOCUS_COLOR = new Color(0x8080ff);//new Color(0x8080ff) modifier la couleur du cadre

	private int SHADOWX = 1;//1 à voir
	private int SHADOWY = 1;//1 à voir
	private float DRAG_SPEED;//vitesse pour le changement de l'aiguille 
	private float CLICK_SPEED;//meme que en haut
	private int size;//la taille du rond
	private int middle;//le milieu à voir

	public final static int SIMPLE = 1;//1 à voir
	public final static int ROUND  = 2;
	private int dragType = ROUND;




	private final static Dimension MIN_SIZE = new Dimension(40, 40);//dim 40 40 
	private final static Dimension PREF_SIZE = new Dimension(80, 80);//dim 80 80

	// Set the antialiasing to get the right look!
	private final static RenderingHints AALIAS = 
			new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);

	private ChangeEvent changeEvent = null;
	private EventListenerList listenerList = new EventListenerList();

	private Arc2D hitArc = new Arc2D.Float(Arc2D.PIE);

	private float ang = (float) START_ANG;
	private float val;
	private int dragpos = -1;
	private float startVal;
	private Color focusColor;
	private double lastAng;

	public DKnob() {
		DRAG_SPEED = 0.01F;//0.01F
		CLICK_SPEED = 0.01F;//0.01F
		SHADOWX = 1;
		SHADOWY = 1;

		focusColor = DEFAULT_FOCUS_COLOR;

		setPreferredSize(PREF_SIZE);
		int degrees = 235;//au debut 235
		hitArc.setAngleStart(degrees); // Degrees ??? Radians???
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				dragpos = me.getX() + me.getY();
				startVal = val;

				// Fix last angle
				int xpos = middle - me.getX();
				int ypos = middle - me.getY();
				lastAng = Math.atan2(xpos, ypos);

				requestFocus();
			}

			public void mouseClicked(MouseEvent me) {
				hitArc.setAngleExtent(-(LENGTH + 20));
				if  (hitArc.contains(me.getX(), me.getY())) {	   
					hitArc.setAngleExtent(MULTIP * (ang-START_ANG)-10);
					if  (hitArc.contains(me.getX(), me.getY())) {
						decValue();
					} else incValue();	
				}
			}
		});

		// Let the user control the knob with the mouse
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent me) {
				if ( dragType == SIMPLE) {
					float f = DRAG_SPEED * (float)
							((me.getX() + me.getY()) - dragpos);
					setValue(startVal + f);
				} else if ( dragType == ROUND) {
					// Measure relative the middle of the button! 
					int xpos = middle - me.getX();
					int ypos = middle - me.getY();
					double ang = Math.atan2(xpos, ypos);
					double diff = lastAng - ang;
					setValue((float) (getValue() + (diff / LENGTH_ANG)));

					lastAng = ang;
				}
			}

			public void mouseMoved(MouseEvent me) {
			}
		});

		// Let the user control the knob with the keyboard
		addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {} 
			public void keyPressed(KeyEvent e) { 
				int k = e.getKeyCode();
				if (k == e.VK_RIGHT)
					incValue();
				else if (k == e.VK_LEFT)
					decValue();
			}		
		});

		// Handle focus so that the knob gets the correct focus highlighting.
		addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				repaint();
			}
			public void focusLost(FocusEvent e) {
				repaint();
			}
		});
	}

	public void setDragType(int type) {
		dragType = type;
	}
	public int getDragType() {
		return dragType;
	}

	public boolean isManagingFocus() {
		return true;
	}

	public boolean isFocusTraversable() {
		return true;
	}



	private void incValue() {
		setValue(val + CLICK_SPEED);
	}

	private void decValue() {
		setValue(val - CLICK_SPEED);
	}


	public float getValue() {
		return val;
	}

	private float valeurAiguille;


	public float getValeurAiguille() {
		return valeurAiguille;
	}

	/***
	 *Set value of hand.
	 *
	 *  @param valeurAiguille: we must count the number of "markers" and the value that you have given corresponding with number that you have counted  
	 */

	public void setValeurAiguille(float valeurAiguille) {
		this.valeurAiguille = (float) valeurAiguille/((int) nombreDeTrait);
	}

	public void setValue(float val) {
		if (val < 0 && valeurAiguille <= nombreDeTrait) val = valeurAiguille;//0
		if (val > 1 && valeurAiguille > nombreDeTrait) val = 1;//1
		this.val = val;
		ang = START_ANG - (float) LENGTH_ANG * val;
		repaint();
		fireChangeEvent();
	}

//	private double tempoValeurChangeListener;
//
//
//	public double getTempoValeurChangeListener() {
//		return tempoValeurChangeListener;
//	}
//
//	public void setTempoValeurChangeListener(double tempoValeurChangeListener) {
//		this.tempoValeurChangeListener = tempoValeurChangeListener;
//	}

	public void addChangeListener(ChangeListener cl) {
		listenerList.add(ChangeListener.class, cl);
	}

	public void removeChangeListener(ChangeListener cl) {
		listenerList.remove(ChangeListener.class, cl);		
	}

	public Dimension getMinimumSize() {
		return MIN_SIZE;
	}

	protected void fireChangeEvent() {
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) {
			if (listeners[i] == ChangeListener.class) {
				// Lazily create the event:
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
			}
		}
	}

	private double nombreDeTrait; 

	public double getNombreDeTrait() {
		return nombreDeTrait;
	}

	public void setNombreDeTrait(double nombreDeTrait) {
		this.nombreDeTrait = nombreDeTrait;
	}


	//entier designant l'intervalle des nombres
	//si on choisit le signe positif, la molette passe de 0 à entInter
	//sinon si on choisit le signe negatif, la molette passe de -entInter à entInter
	private int entInter;

	public int getEntInter() {
		return entInter;
	}

	public void setEntInter(int entInter) {
		this.entInter = entInter;
	}

	private SigneAffichage choxSigne;

	public SigneAffichage getChoxSigne() {
		return choxSigne;
	}

	public void setChoxSigne(SigneAffichage choxSigne) {
		this.choxSigne = choxSigne;
	}


	//cette méthode nous sert à avoir l'affichage de la molette
	void setValeurAffichageMolette(int val, SigneAffichage signe, Graphics g){
		if(signe.equals(SigneAffichage.positif)){
			// Set the position of the Zero
			g.drawString("0", 1, size + 10);

			// Set the position of the one
			g.drawString(val+"", size+10, size+10);

		}else if(signe.equals(SigneAffichage.negatif)){
			g.drawString("-"+val+"", 1, size + 10);

			// Set the position of the one
			g.drawString(val+"", size+10, size+10);
		}else{
			// Set the position of the Zero
			g.drawString("1", 1, size + 10);

			// Set the position of the one
			g.drawString((int) Math.pow(2, val)+"", size+10, size+10);
		}

	}



	// Paint the DKnob
	public void paint(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		size = Math.min(width, height) - 22;
		middle = 10 + size/2;

		if (g instanceof Graphics2D) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(getParent().getBackground());
			g2d.addRenderingHints(AALIAS);

			// For the size of the "mouse click" area
			hitArc.setFrame(4, 4, size+12, size+12);//4, 4, size+12, size+12
		}

		// Paint the "markers"
		for (float a2 = START_ANG; a2 >= START_ANG - LENGTH_ANG; a2=a2 -(float)
				(LENGTH_ANG/nombreDeTrait))//10.01
		{
			int x = 10 + size/2 + (int)((6+size/2) * Math.cos(a2));
			int y = 10 + size/2 - (int)((6+size/2) * Math.sin(a2));
			g.drawLine(10 + size/2, 10 + size/2, x, y);

		}


		this.setValeurAffichageMolette(entInter, choxSigne, g);
		// Set the position of the Zero
		//g.drawString("0", 1, size + 10);

		// Set the position of the one
		//g.drawString("1", size+10, size+10);




		// Paint focus if in focus
		if (hasFocus()) {
			g.setColor(focusColor);
		} else {
			g.setColor(Color.white);
		}

		g.fillOval(10, 10, size, size);
		g.setColor(Color.gray);
		g.fillOval(14 + SHADOWX, 14 + SHADOWY, size-8, size-8);

		g.setColor(Color.black);
		g.drawArc(10, 10, size, size, 315, 270);
		g.fillOval(14, 14, size-8, size-8);
		g.setColor(Color.white);

		int x = 10 + size/2 + (int)(size/2 * Math.cos(ang));
		int y = 10 + size/2 - (int)(size/2 * Math.sin(ang));
		g.drawLine(10 + size/2, 10 + size/2, x, y);
		g.setColor(Color.gray);
		int s2 = (int) Math.max(size / 6, 6);
		g.drawOval(10 + s2, 10 + s2, size - s2*2, size - s2*2);

		int dx = (int)(2 * Math.sin(ang));
		int dy = (int)(2 * Math.cos(ang));
		g.drawLine(10 + dx + size/2, 10 + dy + size/2, x, y);
		g.drawLine(10-dx + size/2, 10-dy + size/2, x, y);
	}

	private String nomMolette;

	public String getNomMolette() {
		return nomMolette;
	}

	public void setNomMolette(String nomMolette) {
		this.nomMolette = nomMolette;
	}

}
