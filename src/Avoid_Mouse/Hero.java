package Avoid_Mouse;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Hero {
	
	private Image imgHero;
	private int posX;
	private int posY;
	
	private int lifeState;
	
	final int ALIVE = 0;
	final int DEAD = 1;
	
	public void init(){
		imgHero = new ImageIcon("Hero.png").getImage();
		posX 	= 0;
		posY 	= 0;
		lifeState 	= DEAD;
	}
	
	public void update(){
		
	}


	public void render(Graphics g){
		g.drawImage(imgHero, posX-5, posY-5, null);
		
	}
	
	public void setPos(int _posX, int _posY){
		posX = _posX;
		posY = _posY;
	}
	
	public void setLifeState(int _lifeState){
		lifeState = _lifeState;
	}
	
	public int getLifeState(){
		return lifeState;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
}
