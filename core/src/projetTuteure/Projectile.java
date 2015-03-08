package projetTuteure;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    //D�claration des variables de la classe
    private Vector2 pos;
    private Vector2 deplacement;

    private Texture img;

    private float vitesse;

    //Constructeur de la classe
    Projectile ()
    {
        pos = new Vector2();
        deplacement = new Vector2();
        img = new Texture("carre.jpg");
        vitesse = 4;
        pos.x = 1315;
        this.pos.y = pos.y;
    }

    //Proc�dure de mise � jour
    public void update(Vector2 pos)
    {
        if (this.pos.x > 0)
        {
            deplacement.x = -vitesse;
            System.out.println(pos.x + "En Y :" + pos.y);
        }
    }

    //Proc�dure de d�placement du projectile
    public void deplacement()
    {
        pos.x += deplacement.x;
        deplacement.x = 0;
    }

    //Proc�dure
    public void draw(SpriteBatch batch)
    {
        batch.draw(img, pos.x, pos.y);
    }
}