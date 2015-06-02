package music;

public class Singer extends Thread{

	private String singerName;
	private Voice voice;
	private Performance performance;
	
	private Synchronizer synch;
	private boolean stop; //zbog crvene tackice da se ugasi u konzoli
	
	
	public Singer(String singerName, Voice voice, Performance performance,
			Synchronizer synch, boolean stop) {
		super();
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
		this.synch = synch;
		this.stop = stop;
	}

	public Singer(String singerName, Voice voice, Performance performance) {
		super();
		this.singerName = singerName;
		this.voice = voice;
		this.performance = performance;
	} 
	
	public Singer(){
		super();
	}
	
	public void sing(Song song, int numberOfRepetitions) { // ako se u pesmi ponavlja strofa
		for (int i = 0; i < numberOfRepetitions; i+=2) {
			if(this.voice == Voice.LEAD) {
				System.out.println(song.getLyrics().get(i % song.getLyrics().size()));
			}
			if(this.voice == Voice.BACKING) {
				System.out.println(song.getLyrics().get(i % song.getLyrics().size() + 1 ));
			}
		}
	}
	
	
	/**
	 * svako od njih kad peva otpeva jedan stih pa saceka par sekundi pa opet otpeva svoj stih
	 * za ovo synchronized pogledaj Test klasu
	 * @param song
	 * @param numberOfRepetitions
	 */
	public synchronized void singWithDelay(Song song, int numberOfRepetitions) {
		long delay = this.performance.getDelay();
		for (int i = 0; i < numberOfRepetitions; i+=2) {
			if(this.voice == Voice.LEAD) {
				System.out.println(song.getLyrics().get(i % song.getLyrics().size()));
				try {
					wait(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(this.voice == Voice.BACKING) {
				System.out.println(song.getLyrics().get(i % song.getLyrics().size() + 1 ));
				try {
					wait(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * moram nju da zamenim onim sto zelimo da radi u trenutku kad dodje signal bbk ili bobou da treba da krene da
	 * radi, mora da postoji ova run metoda i od nje mora da krene
	 */
	@Override
	public void run() {
		sing(); //sto sad pravim sing zar nisam mogao da pozovem, NO
		
	}
	 
	/**
	 * 
	 */
	private void sing() {
		Song song = performance.getSong();
		long delay = performance.getDelay();
		
		int i = 0;
		String line = null;
		
		while (!stop) {
			if(this.voice == Voice.LEAD) {
				line = "\t" + song.pickLine(this.voice, i % song.getLyrics().size());
				synch.singLeadVoice(line, delay);
			}
			if(this.voice == Voice.BACKING) {
				line = "\t" + song.pickLine(this.voice, i % song.getLyrics().size());
				synch.singBackingVoice(line + 1, delay);
			}
			i += 2; 
		}
	}
	
	public Synchronizer getSynch() {
		return synch;
	}

	public void setSynch(Synchronizer synch) {
		this.synch = synch;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public String getSingerName() {
		return singerName;
	}
	
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	
	public Voice getVoice() {
		return voice;
	}
	
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	public Performance getPerformance() {
		return performance;
	}
	
	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
	
}
