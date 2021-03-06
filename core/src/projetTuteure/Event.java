package projetTuteure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

public class Event {

	static final int CLAVIER = 0;
	static final int MANETTE = 1;
	
	static final int TOUCHE_HAUT = 0;
	static final int TOUCHE_BAS = 1;
	static final int TOUCHE_GAUCHE = 2;
	static final int TOUCHE_DROITE = 3;
	
	static final int JOYSTICK_GAUCHE = 0;
	static final int JOYSTICK_DROIT = 1;
	
	private int typeController;
	private Controller controller;
	
	private Vector2[] joystick;
	private Vector2 posSouri;
	private Boolean[] toucheDeplacement;
	private Boolean[] action;
	
	private float margeErreur;
	
	// Constructeur clavier
	Event()
	{
		this.typeController = Event.CLAVIER;
		
		toucheDeplacement = new Boolean[4];
		action = new Boolean[4];		
		posSouri = new Vector2();
		
		System.out.println("Clavier");
		
	}
	
	// Constructeur manette
	Event(int numController)
	{
		this.typeController = Event.MANETTE;
		
		if(numController < Controllers.getControllers().size)
			controller = Controllers.getControllers().get(numController);
		else
			System.exit(4);
					
		joystick = new Vector2[2];
		for(int i=0; i < 2; i++)
			joystick[i] = new Vector2();
		
		action = new Boolean[4];
		posSouri = new Vector2();	
		
		margeErreur = 0.3f;
		
		System.out.println("Manette");
	}
	
	// Mise � jour des evenements
	public void update()
	{
		if(typeController == Event.CLAVIER)
		{
			// Mise a jour des fleche de deplacement
			toucheDeplacement[Event.TOUCHE_HAUT] = Gdx.input.isKeyPressed(Keys.UP);
			toucheDeplacement[Event.TOUCHE_BAS] = Gdx.input.isKeyPressed(Keys.DOWN);
			toucheDeplacement[Event.TOUCHE_GAUCHE] = Gdx.input.isKeyPressed(Keys.LEFT);
			toucheDeplacement[Event.TOUCHE_DROITE] = Gdx.input.isKeyPressed(Keys.RIGHT);
			
			// Mise a jour de la souris
			posSouri.x = Gdx.input.getX();
			posSouri.y = Gdx.input.getY();
			
			// Mise a jour btn souris
			/// A Faire (Laurent)\\\
			
			// Mise a jour touches action
			action[0] = Gdx.input.isKeyPressed(Keys.A);
			action[1] = Gdx.input.isKeyPressed(Keys.Z);
			action[2] = Gdx.input.isKeyPressed(Keys.E);
			action[3] = Gdx.input.isKeyPressed(Keys.R);
		}
		else if(typeController == Event.MANETTE)
		{
			// Mise a jour des joystick
			joystick[JOYSTICK_GAUCHE].x = controller.getAxis(0);
			joystick[JOYSTICK_GAUCHE].y = controller.getAxis(1);
			joystick[JOYSTICK_DROIT].x = controller.getAxis(3);
			joystick[JOYSTICK_DROIT].y = controller.getAxis(2);
			
			if(joystick[JOYSTICK_GAUCHE].x < margeErreur && joystick[JOYSTICK_GAUCHE].x > -margeErreur)
				joystick[JOYSTICK_GAUCHE].x = 0;
			if(joystick[JOYSTICK_GAUCHE].y < margeErreur && joystick[JOYSTICK_GAUCHE].y > -margeErreur)
				joystick[JOYSTICK_GAUCHE].y = 0;
			if(joystick[JOYSTICK_DROIT].x < margeErreur && joystick[JOYSTICK_DROIT].x > -margeErreur)
				joystick[JOYSTICK_DROIT].x = 0;
			if(joystick[JOYSTICK_DROIT].y < margeErreur && joystick[JOYSTICK_DROIT].y > -margeErreur)
				joystick[JOYSTICK_DROIT].y = 0;
			
			// Mise a jour touches actions
			action[0] = controller.getButton(0);
			action[1] = controller.getButton(1);
			action[2] = controller.getButton(2);
			action[3] = controller.getButton(3);
		}
	}
	
	// Verifie appui sur une touche de d�placement
	public boolean getToucheDeplacement(int id)
	{ return toucheDeplacement[id]; }
	
	//V�rifie l'appui d'une touche d'action 
	public boolean getAction (int id)
	{ return action[id]; }
	
	// Recupere si manette ou clavier
	public int getTypeController()
	{ return typeController; }
	
	// Recupere valeur joystick
	public float getValJoystick(int joystick, int axe)
	{
		if(axe == 0)
			return this.joystick[joystick].x;
		else if(axe == 1)
			return this.joystick[joystick].y;
		else
			return 0;
	}

}
