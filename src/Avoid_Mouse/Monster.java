package Avoid_Mouse;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Monster {
	protected Image imgMonster;
	protected float posX;
	protected float posY;
	
	protected int target_posX;
	protected int target_posY;
	protected double target_angle;
	
	private int lifeState;
	
	final int ALIVE = 0;
	final int DEAD = 1;
	
	private Random random = new Random();
	
	public void init(){
		posX = 0;
		posY = 0;
		lifeState = DEAD;
	}
	
	public void update(Hero hero){
		if(posX <-10 || posX > 710 || posY > 510 || posY < -10)
		{
			lifeState = DEAD;
		}

		//충돌했는지 확인
		float horizontalDistance = hero.getPosX()-posX;
		float verticalDistance = hero.getPosY()-posY;
		float distance = (float) Math.sqrt(horizontalDistance*horizontalDistance + verticalDistance*verticalDistance);
		if(distance <= 10){
			hero.setLifeState(hero.DEAD);
		}
	}
	
	public void appear(int _posX, int _posY){
		posX = _posX;
		posY = _posY;
		lifeState = ALIVE;
		
		target_posX 	= random.nextInt(700);
		target_posY 	= random.nextInt(500);
		target_angle 	= Math.atan2(target_posY-posY, target_posX-posX);
	}
	
	public void render(Graphics g){
		g.drawImage(imgMonster, (int)posX-5, (int)posY-5, null);
	}
	
	public int getLifeState(){
		return lifeState;
	}
	
	public float getPosX(){
		return posX;
	}
	public float getPosY(){
		return posY;
	}
}
