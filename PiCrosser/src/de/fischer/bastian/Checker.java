package de.fischer.bastian;

import java.util.List;
import java.util.ListIterator;

public class Checker {
	
	public static PiCrossBoard board;

	public static boolean checkIfSolved(){
		
		checkLines();
		return checkBoard();
		
	}
	
	private static boolean checkBoard(){
		
		for(boolean a : board.horizontalSolved){
			
			if (!a) return false;
			
		}
		
		for(boolean a : board.verticalSolved){
			
			if (!a) return false;
			
		}
		
		return true;
		
	}
	
	private static void checkLines(){
		
		ListIterator<List<Integer>> iterator = board.horizontalConditions.listIterator();
		int elementId = 0;
		while(iterator.hasNext()){

			List<Integer> conditionList = iterator.next();
			ListIterator<Integer> iteratorValues = conditionList.listIterator();
			
			int targetValue = 0;
			int currentValue = 0;
			
			while(iteratorValues.hasNext()){
				
				targetValue += iteratorValues.next();
				
			}
			
			for(int a = 0 ; a < board.size ; a++){
				
				if (board.boardArray[elementId][a] == 1) currentValue++;
				
			}
			
			if(targetValue == currentValue){
				
				board.horizontalSolved[elementId] = true;
				finishLine("horizontal", elementId);
				
			}
			
			elementId++;
			
		}		
		
	}
	
	private static void finishLine(String dir, int row){
		
		for(int a = 0 ; a < board.size ; a++){
			
			if(dir.equals("horizontal")){
				
				if(board.boardArray[row][a]==0) board.boardArray[row][a] = 2;
				
			}
			
			else{
				
				if(board.boardArray[a][row]==0) board.boardArray[a][row] = 2;
				
			}
			
		}		
		
	}
	
}
