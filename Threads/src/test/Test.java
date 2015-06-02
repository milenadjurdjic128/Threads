package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import music.Performance;
import music.Singer;
import music.Song;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Song love;
	List<String> lyrics;
	Singer bbk;
	Singer bono;
	Performance performance;
	
	private void initialize() {

		lyrics = new ArrayList<String>();
		lyrics.add("When love comes to town I'm gonna jump that train.");
		lyrics.add("When love comes to town I'm gonna catch that flame.");
		lyrics.add("Maybe I was wrong to ever let you down.");
		lyrics.add("But I did what I did before love came to town.");

		love = new Song("When love comes to town", lyrics);
		performance = new Performance(love, 1000);

		bbk = new Singer("B.B.King", Voice.LEAD, performance);
		bono = new Singer("Bono", Voice.BACKING, performance);
	}

	public void testPickLine() {
		initialize();
		System.out.println(love.pickLine(Voice.ALL, 2));
		System.out.println();
		System.out.println(love.pickLine(Voice.LEAD, 2));
		System.out.println();
		System.out.println(love.pickLine(Voice.LEAD, 3));
	}
	
	public void testSing() {
		initialize();
		bbk.sing(love, 8);
		System.out.println();
		bono.sing(love, 8);
	}
	
	/**
	 * zove metodu wait koja negde vec postoji, stavlja ovo cudo da ceka ali 
	 * nastavlja da radi u pozadini pa prekida to cekanje u jednom trenutku --> to cekanje
	 * prekida ovaj Interupt iz try i catch-a; Drugi program broji ono vreme koje smo zadali u delay
	 * LEK ZA OVO: u metodi gore stavimo rec synchronized pre voida u metodi singWithDelay
	 */
	public void testSingWithDelay() {
		initialize();
		bbk.singWithDelay(love, 8);
		System.out.println();
		bono.singWithDelay(love, 8);
	}

	public void testSingWithTimer() {
		
		/**
		 * Timer iz UTILA!!!
		 * potrebno je opisati taj tajmer (kad neko uzvikne nesto --> shout)
		 */
		Timer timer = new Timer();
		
		ShoutTimerTask shout = new ShoutTimerTask(timer); //posle nekoliko sekundi nek ovaj drekne
		timer.schedule(shout, 2500);
		
		
		initialize();
		bbk.singWithDelay(love, 8);
		System.out.println();
		bono.singWithDelay(love, 8);
	}
}
