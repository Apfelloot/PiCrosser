package de.fischer.bastian;

import java.util.ArrayList;
import java.util.List;

public class PiCrossBoard {

	public int size;
	//0 = empty, 1 = true, 2 = false
	public Integer[][] boardArray;
	public boolean[] horizontalSolved;
	public boolean[] verticalSolved;
	public List<List<Integer>> horizontalConditions = new ArrayList<List<Integer>>();
	public List<List<Integer>> verticalConditions = new ArrayList<List<Integer>>();
	
	//example sequence: 5;1-2,1-1,3-1,1-1,3-1:1-2,1-1,3-1,1-1,3-1
	public PiCrossBoard(String sequence){
		
		String[] sizeSplit = sequence.split(";");
		size = Integer.parseInt(sizeSplit[0]);
		boardArray = new Integer[size][size];
		horizontalSolved = new boolean[size];
		verticalSolved = new boolean[size];
		
		for(int a = 0; a<size; a++){
			
			horizontalSolved[a] = false;
			verticalSolved[a] = false;
			
			for(int b = 0; b<size; b++){
				
				boardArray[a][b] = 0;
				
			}
							
		}
		
		String[] conditionSplit = sizeSplit[1].split(":");
		for(String condition : conditionSplit[0].split(",")){
			
			List<Integer> cons = new ArrayList<Integer>();
			
			for(String singleCon : condition.split("-")){
				
				cons.add(Integer.parseInt(singleCon));
				
			}
			
			horizontalConditions.add(cons);
			
		}
		
		for(String condition : conditionSplit[1].split(",")){
			
			List<Integer> cons = new ArrayList<Integer>();
			
			for(String singleCon : condition.split("-")){
				
				cons.add(Integer.parseInt(singleCon));
				
			}
			
			verticalConditions.add(cons);
			
		}
		
		
	}	
	
}
