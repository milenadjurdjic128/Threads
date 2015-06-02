package music;

public class Singer {

	private String singerName;
	private Voice voice;
	private Performance performance;
	
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
