package music;

public class Performance {

	private Song song;
	private long delay;
	
	public Performance(Song song, long delay) {
		super();
		this.song = song;
		this.delay = delay;
	}
	
	/**
	 * zasto su prazni konstruktori ZDRAVI? :D
	 * da bi se zvala JavaBean klasa, koja je potpuna (navikavajmo se na to da pravimo)
	 */
	
	public Performance() {
		super();
	}
	
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public long getDelay() {
		return delay;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}
	
	
}
