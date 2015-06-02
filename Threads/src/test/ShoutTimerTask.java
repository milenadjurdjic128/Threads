package test;

import java.util.Timer;
import java.util.TimerTask;

public class ShoutTimerTask extends TimerTask{
	
	private Timer timer;
	
	public ShoutTimerTask(Timer timer) {
		super();
		this.timer = timer;
	}
	
	public ShoutTimerTask () {
		super();
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * trazio je po netu negde ovaj TimerTask sa metodom run, abstraktna klasa moram da napravim svoju
	 * klasu u kojoj implementiram pa onda tek zovem.
	 * Runnable implementira, jer Runnable ima metodu run
	 */
	@Override
	public void run() {
		System.out.println();
		System.out.println("Yeah!"); // kad se neko ubaci i usklikne
		System.out.println();
		
		timer.cancel(); //kazes mu - crkni :D
		timer.purge();// ali pre toga malo pocisti sa sobom
	}



}
