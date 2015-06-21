import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;
import java.util.ArrayList;
import java.util.List;


public class nMaxSwap  implements HeuristicFunction {
	public double h(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
        
        return evaluateNMaxSwap(board);
	}
	static EightPuzzleBoard goalState = new EightPuzzleBoard(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
	public int evaluateNMaxSwap(EightPuzzleBoard board){
		int retVal = 0 ;
		
		if(board == goalState)
		{
			retVal = 0;
		}
		else
		{
			// get the position of the space
			XYLocation loc = board.getLocationOf(0);
			// find the number that should go in the above space
			int index = loc.getXCoOrdinate()*3 + loc.getYCoOrdinate();
			
			// if the space is already in the correct position 
			// then find a misplaced tile and swap the space with it
			if(index == 0)
			{
				for(int i=1; i<9; i++){
					XYLocation tloc = board.getLocationOf(i);
					int tIndex = tloc.getXCoOrdinate() * 3 + tloc.getYCoOrdinate();
					
					if(tIndex != i){
						EightPuzzleBoard newBoard = update(board,0,tloc,i,loc);
						retVal += 1 + evaluateNMaxSwap(newBoard);
					}
				}
			}
			else
			{
				// get the location of the number that you have to swap with the space
				XYLocation indexLoc = board.getLocationOf(index);
				
				EightPuzzleBoard newBoard = update(board,index,loc,0,indexLoc);
	
				// continue recussion
				retVal += 1+ evaluateNMaxSwap(newBoard);
			}
		}
		return retVal;
	}
	
	public EightPuzzleBoard update(EightPuzzleBoard board, int a, XYLocation aLoc, int b, XYLocation bLoc){
		// create a copy of the board to update
		EightPuzzleBoard newBoard = new EightPuzzleBoard(board);
		
		// get positons of all the numbers on the board ordered by the number value
		List<XYLocation> pos = board.getPositions();
		
		// swap the place where the number is with the place of the space
		pos.remove(a);
		pos.add(a,aLoc);
		// swap the place of the space with the place of the number
		pos.remove(b);
		pos.add(b,bLoc);
		
		// applay the new configuration back to the board
		newBoard.setBoard(pos);
		return newBoard;
	}	
}
