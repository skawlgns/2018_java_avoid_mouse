package Avoid_Mouse;

import javax.swing.ImageIcon;

public class NormalMonster extends Monster {
	
	public void init(){
		super.init();
		imgMonster = new ImageIcon("Monster.png").getImage();
	}
	
	public void update(Hero hero){
		super.update(hero);
		
		posX +=  Math.cos(target_angle)*2;
		posY +=  Math.sin(target_angle)*2;
	}
}
