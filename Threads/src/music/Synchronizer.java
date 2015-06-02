package music;

public class Synchronizer {
	/**
	 * sta ako nesto iz jednog threada treba drugom threadu - tada se radi sinhronizacija da ne bi doslo do
	 * kolizije u memoriji - mindblown
	 * 
	 * to se radi uvodjenjem objekta koji je zajednicki za ta dva thread-a (obojica imaju pointer
	 * na isti objekat koji je deo oba thread-a) 
	 */
	
	
	 //indikator kad koji treba da pocne
	 
	private boolean leadVoiceFlag;
	
	/**
	 * 
	 * @param line sta da otpeva
	 * @param delay sa koliko kasnjenja
	 */
	public synchronized void singLeadVoice(String line, long delay) {
		//dok god ne dobije signal od drugog da je zavrsio on treba da suti
		while (!leadVoiceFlag) {
			try {
				wait(); //cuti
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		//neko spoja mu da signal (leadVoiceFlag) pogledaj dole
		singOneLine(line, delay);
		
	}
	
	public synchronized void singBackingVoice(String line, long delay) {
		while (!leadVoiceFlag) {
			try {
				wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		singOneLine(line, delay);
		
	}
	
	private void singOneLine(String line, long delay) {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		leadVoiceFlag = !leadVoiceFlag; // CARSKI to je taj signal
		
		/**
		 * probudi sve ove pospane tipove koji cekaju na neki signal i neka pocnu da rade, a ti si u 
		 * stanju cekanja jer si ti svoje odradio ;)
		 */
		notifyAll();
	}
	

}
