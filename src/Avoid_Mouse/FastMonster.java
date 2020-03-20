package Avoid_Mouse;

import javax.swing.ImageIcon;

public class FastMonster extends Monster {
	
	public void init(){
		super.init();
		imgMonster = new ImageIcon("FastMonster.png").getImage();
	}
	
	public void update(Hero hero){
		super.update(hero);
		
		posX +=  Math.cos(target_angle)*5;
		posY +=  Math.sin(target_angle)*5;
		
		
	}
}
