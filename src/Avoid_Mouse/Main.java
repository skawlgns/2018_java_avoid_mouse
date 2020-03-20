package Avoid_Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class Main extends JFrame implements Runnable, MouseMotionListener, KeyListener {

	private int frameWidth = 700;
	private int frameHeight = 500;

	final int MAX_MONSTER = 500;

	private Hero Hero = new Hero();
	private Monster[] Monster = new Monster[MAX_MONSTER];
	private long MonsterCreationTime = 0;
	private int Score = 0;

	private Random random = new Random();
	private Thread thread;

	public Main() {
		init();
		setLayout(null);
		setTitle("15111174 남지훈");
		setBounds(200, 200, frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우 종료시 종료
		setVisible(true);

		thread = new Thread(this);
		thread.start();

		addMouseMotionListener(this);
		addKeyListener(this);
	}

	public void run() {
		while (true) {
			update();

			repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Error in executing thread: " + e);
			}
		}
	}

	public void init() {
		Hero.init();
	}

	public void update() {
		if (Hero.getLifeState() == Hero.DEAD)
			return;

		Hero.update();
		for (int i = 0; i < MAX_MONSTER; i++) {
			if (Monster[i] != null) {
				Monster[i].update(Hero);
				if (Monster[i].getLifeState() == Monster[i].DEAD) {
					Monster[i] = null;
				}
			}
		}

		if (MonsterCreationTime <= System.currentTimeMillis() - 20) {
			Score++;
			MonsterCreationTime = System.currentTimeMillis();
			for (int i = 0; i < MAX_MONSTER; i++) {
				// 죽은 몬스터 체크
				if (Monster[i] == null) {

					int nRandomMonster = random.nextInt(5);

					if (nRandomMonster == 0) {
						Monster[i] = new FastMonster();
					} else {
						Monster[i] = new NormalMonster();
					}
					Monster[i].init();

					int nRandomAppear = random.nextInt(4);
					if (nRandomAppear == 0) {
						Monster[i].appear(-5, random.nextInt(500));
					} else if (nRandomAppear == 1) {
						Monster[i].appear(705, random.nextInt(500));
					} else if (nRandomAppear == 2) {
						Monster[i].appear(random.nextInt(700), 505);
					} else if (nRandomAppear == 3) {
						Monster[i].appear(random.nextInt(700), -5);
					}
					break;
				}
			}
		}

	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, frameWidth, frameHeight);

		Hero.render(g);
		for (int i = 0; i < MAX_MONSTER; i++) {

			if (Monster[i] != null) {
				Monster[i].render(g);
			}
		}

		g.setColor(Color.white);
		g.drawString("score: " + Score + " Press SpaceBar to begin", 20, 50);
	}

	public static void main(String[] args) {
		new Main();
	}

	public void mouseMoved(MouseEvent e) {
		Hero.setPos(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		if (arg0.getKeyCode() == 32) {
			Hero.setLifeState(Hero.ALIVE);
			for (int i = 0; i < MAX_MONSTER; i++) {
				Monster[i] = null;
			}
			Score = 0;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
