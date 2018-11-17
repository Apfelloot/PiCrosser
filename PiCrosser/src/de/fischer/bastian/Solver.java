package de.fischer.bastian;
import java.util.List;
import java.util.ListIterator;

public class Solver {
	
	public static PiCrossBoard board;
	
	public static PiCrossBoard solve(){
		
		solveFulls();
		UiManager.printBoard(board);
		solveFullsWithSpaces();
		UiManager.printBoard(board);
		partSolveOneNum();
		UiManager.printBoard(board);
		partSolveEdgeIsMarked();
		Checker.board = board;
		if(Checker.checkIfSolved()) System.out.println("EASY");
		return board;
		
	}
	
	private static void partSolveEdgeIsMarked(){
		
		ListIterator<List<Integer>> iterator = board.horizontalConditions.listIterator();
		int elementId = 0;
		while(iterator.hasNext()){

			List<Integer> conditionList = iterator.next();
			ListIterator<Integer> iteratorValues = conditionList.listIterator();
			int conditionId = 0;
			
			while(iteratorValues.hasNext()){
				
				int currentValue = iteratorValues.next();
				
				if(conditionId == 0 && board.boardArray[elementId][0] == 1){
					
					for(int a = 0; a < currentValue; a++){
						
						board.boardArray[elementId][a] = 1;
						
					}
					
				}
				
				if(conditionId == conditionList.size()-1 && board.boardArray[elementId][board.size-1] == 1 && conditionList.size() > 1){
					
					for(int a = board.size-currentValue; a < board.size ; a++){
						
						board.boardArray[elementId][a] = 1;
						
					}
					
				}
				
				conditionId++;
				
			}
			
			elementId++;
			
		}
		
		iterator = board.verticalConditions.listIterator();
		elementId = 0;
		while(iterator.hasNext()){

			List<Integer> conditionList = iterator.next();
			ListIterator<Integer> iteratorValues = conditionList.listIterator();
			int conditionId = 0;
			
			while(iteratorValues.hasNext()){
				
				int currentValue = iteratorValues.next();
				
				if(conditionId == 0 && board.boardArray[0][elementId] == 1){
					
					for(int a = 0; a < currentValue; a++){
						
						board.boardArray[a][elementId] = 1;
						
					}
					
				}
				
				if(conditionId == conditionList.size()-1 && board.boardArray[board.size-1][elementId] == 1 && conditionList.size() > 1){
					
					for(int a = board.size-currentValue; a < board.size ; a++){
						
						board.boardArray[a][elementId] = 1;
						
					}
					
				}
				
				conditionId++;
				
			}
			
			elementId++;
			
		}
		
	}
	
	private static void partSolveOneNum(){
		
		ListIterator<List<Integer>> iterator = board.horizontalConditions.listIterator();
		int elementId = 0;
		while(iterator.hasNext()){

			List<Integer> conditionList = iterator.next();
			ListIterator<Integer> iteratorValues = conditionList.listIterator();
			
			while(iteratorValues.hasNext()){
				
				int currentValue = iteratorValues.next();
				
				if(conditionList.size() == 1 && board.size - currentValue < board.size / 2 + 0.5){
					
					int blankValue = board.size - currentValue;
					int markValue = board.size - 2*blankValue;
					
					for(int a = 0; a < board.size; a++){
						
						if(a >= blankValue && a < blankValue + markValue)board.boardArray[elementId][a] = 1;
						
					}
					
				}
				
			}
			
			elementId++;
			
		}
		
		iterator = board.verticalConditions.listIterator();
		elementId = 0;
		while(iterator.hasNext()){

			List<Integer> conditionList = iterator.next();
			ListIterator<Integer> iteratorValues = conditionList.listIterator();
			
			while(iteratorValues.hasNext()){
				
				int currentValue = iteratorValues.next();
				
				if(conditionList.size() == 1 && board.size - currentValue < board.size / 2 + 0.5){
					
					int blankValue = board.size - currentValue;
					int markValue = board.size - 2*blankValue;
					
					for(int a = 0; a < board.size; a++){
						
						if(a >= blankValue && a < blankValue + markValue)board.boardArray[a][elementId] = 1;
						
					}
					
				}
				
			}
			
			elementId++;
			
		}	
		
	}
	
	private static void solveFulls(){
		
		ListIterator<List<Integer>> iterator = board.horizontalConditions.listIterator();
		int elementId = 0;
		while(iterator.hasNext()){

			ListIterator<Integer> iteratorValues = iterator.next().listIterator();
			
			while(iteratorValues.hasNext()){
				
				int currentValue = iteratorValues.next();
				
				if(currentValue == board.size){
					
					for(int a = 0; a < board.size; a++){
						
						board.boardArray[elementId][a] = 1; 
						
					}
					
				}
				
				else if(currentValue == 0){
					
					for(int a = 0; a < board.size; a++){
						
						board.boardArray[elementId][a] = 2; 
						
					}					
					
				}
				
			}
			
			elementId++;
			
		}
		
		iterator = board.verticalConditions.listIterator();
		elementId = 0;
		while(iterator.hasNext()){

			ListIterator<Integer> iteratorValues = iterator.next().listIterator();
			
			while(iteratorValues.hasNext()){
				
				int currentValue = iteratorValues.next();
				
				if(currentValue == board.size){
					
					for(int a = 0; a < board.size; a++){
						
						board.boardArray[a][elementId] = 1; 
						
					}
					
				}
				
				else if(currentValue == 0){
					
					for(int a = 0; a < board.size; a++){
						
						board.boardArray[a][elementId] = 2; 
						
					}					
					
				}
				
			}
			
			elementId++;
			
		}
		
	}
	
	private static void solveFullsWithSpaces(){
	
		ListIterator<List<Integer>> iterator = board.horizontalConditions.listIterator();
		int elementId = 0;
		while(iterator.hasNext()){
			
			List<Integer> values = iterator.next();
			int conditionSum = values.size()-1;
			ListIterator<Integer> iteratorValues = values.listIterator();
			
			while(iteratorValues.hasNext()){
				
				conditionSum += iteratorValues.next();
				
			}
			
			if(conditionSum == board.size){
				
				iteratorValues = values.listIterator();
				
				int allCount = 0;
				
				while(iteratorValues.hasNext()){
					
					int a = 0;
					int counter = iteratorValues.next();
					while(a < counter){
						
						board.boardArray[elementId][allCount] = 1;
						a++;
						allCount++;
						
					}
					
					if (iteratorValues.hasNext()) {
						
						board.boardArray[elementId][allCount] = 2;
						allCount++;
						
					}
					
				}
				
				
			}
			
			elementId++;
			
		}
		
		iterator = board.verticalConditions.listIterator();
		elementId = 0;
		while(iterator.hasNext()){
			
			List<Integer> values = iterator.next();
			int conditionSum = values.size()-1;
			ListIterator<Integer> iteratorValues = values.listIterator();
			
			while(iteratorValues.hasNext()){
				
				conditionSum += iteratorValues.next();
				
			}
			
			if(conditionSum == board.size){
				
				iteratorValues = values.listIterator();
				
				int allCount = 0;
				
				while(iteratorValues.hasNext()){
					
					int a = 0;
					int counter = iteratorValues.next();
					while(a < counter){
						
						board.boardArray[allCount][elementId] = 1;
						a++;
						allCount++;
						
					}
					
					if (iteratorValues.hasNext()) {
						
						board.boardArray[allCount][elementId] = 2;
						allCount++;
						
					}
					
				}
				
				
			}
			
			elementId++;
			
		}
		
	}
	
}
