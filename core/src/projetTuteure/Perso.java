package projetTuteure;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Perso {
	//D�claration des variables de la classe
	private Vector2 pos;
	private Vector2 deplacement;
	private Texture img;
	private float vitesse;
	private Event event;
	
	//Constructeur de la classe
	Perso()
	{
		pos = new Vector2();
		deplacement = new Vector2();
		img = new Texture("perso.png");
		vitesse = 5;
		event = new Event();
	}
	
	//Getteur de la position
	public Vector2 getPos()
	{
		return pos;
	}
	
	//Getteur de l'image
	public Texture getImg()
	{
		return img;
	}
	
	//Getteur de la vitesse; 
	public float getVitesse()
	{
		return vitesse;
	}
	
	//Mise � jour des �v�nements
	public void updateEvent()
	{
		event.update();
	}
	
	//Calcul du d�placement
	public void update()
	{
		if (event.getTouche(Event.TOUCHE_HAUT))
		{
			deplacement.y+=vitesse;
		}
		if (event.getTouche(Event.TOUCHE_BAS))
		{
			deplacement.y-=vitesse;
		}
		if (event.getTouche(Event.TOUCHE_GAUCHE))
		{
			deplacement.x-=vitesse;
		}
		if (event.getTouche(Event.TOUCHE_DROITE))
		{
			deplacement.x+=vitesse;
		}
	}
	
	//M�thode de gestion de la collision
	
	//M�thode de d�placement
	public void deplacement()
	{
		pos.x += deplacement.x;
		pos.y += deplacement.y;
		deplacement.x = 0;
		deplacement.y = 0;
	}
	//M�thode d'affichage du personnage
	public void draw(SpriteBatch batch)
	{
		batch.draw(img, pos.x, pos.y);
	}
}