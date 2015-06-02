package main;

import test.Test;

public class Main {

	public static void main(String[] args) {
		
		Test t = new Test();
		
//		t.testPickLine(); 
//		t.testSing();
//		t.testSingWithDelay();
		
		/**
		 * 	threadovi koje pevaju bbk i bono idu dalje, ovaj drekne odjedared
		 * i kad se zavrsi ON I DALJE RADI ako mu ne kazem da prekine
		 * "On ima svoj zivot. On je nezavisan covek" vi morate njega da ubijete!
		 */
		t.testSingWithTimer();  
	}

}
