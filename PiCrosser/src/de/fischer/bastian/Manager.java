package de.fischer.bastian;

public class Manager {

	public static void main(String[] args) {
		
		PiCrossBoard board = new PiCrossBoard(UiManager.getUserSequence());
		Solver.board = board;
		UiManager.printBoard(Solver.solve());
		
	}

}
