package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject{

    private Handler handler;

    private Random r = new Random();

    public HardEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        //TODO Auto-generated constructor stub
        this.handler = handler;

        velX = 5;
        velY = 5;
    }

    
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        // TODO Auto-generated method stub
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) {if(velY < 0) velY *= -(r.nextInt(7)+1)*-1; else velY = (r.nextInt(7)+1)*-1;}
        if (x <= 0 || x >= Game.WIDTH - 16) {if(velX < 0) velX *= -(r.nextInt(7)+1)*-1; else velX = (r.nextInt(7)+1)*-1;}

        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, (float) 0.01, handler));
    }

    public void render(Graphics g) {
        // TODO Auto-generated method stub



        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
