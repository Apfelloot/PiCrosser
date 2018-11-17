package de.fischer.bastian;
import java.util.List;
import java.util.Scanner;

public class UiManager {

	public static String getUserSequence(){
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter PiCross sequence: ");
		String piCrossSequence = reader.next();
		reader.close();
		return piCrossSequence;
		
	}
	
	public static void printBoard(PiCrossBoard board){
		
		StringBuilder sb = new StringBuilder();
		sb.append(" \t");
		List<List<Integer>> horizontalConditions = board.horizontalConditions;
		for(int a = 0; a < horizontalConditions.size(); a++){
			
			List<Integer> values = horizontalConditions.get(a);
			
			for(int b = 0; b < values.size(); b++){
			
				sb.append(values.get(b));
				if(b < values.size()-1) sb.append("-");
				
			}
		
			sb.append("\t");
			
		}
		
		sb.append(System.lineSeparator());
		
		List<List<Integer>> verticalConditions = board.verticalConditions;
		Integer[][] boardArray = board.boardArray;
		for(int a = 0; a < verticalConditions.size(); a++){
			
			List<Integer> values = verticalConditions.get(a);
			
			for(int b = 0; b < values.size(); b++){
			
				sb.append(values.get(b));
				if(b < values.size()-1) sb.append("-");
				
			}
			
			sb.append("\t");
			
			for(int c = 0; c < board.size; c++){
				
				switch(boardArray[c][a]){
				
				case 0: 
						sb.append("\u2395");
						break;
						
				case 1: 
					sb.append("\u23F9");
					break;
					
				case 2: 
					sb.append("\u22A0");
					break;				
				
				}
				
				sb.append("\t");
				
			}
		
			sb.append(System.lineSeparator());
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}
