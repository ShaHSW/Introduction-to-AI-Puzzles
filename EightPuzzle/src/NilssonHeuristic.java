import aima.core.search.framework.HeuristicFunction;
import aima.core.util.datastructure.XYLocation;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;

public class NilssonHeuristic implements HeuristicFunction {
	public double h(Object state) {
	        EightPuzzleBoard board = (EightPuzzleBoard) state;
	        int returnValue = 0;
	        for (int i = 1; i < 9; i++) {
	                XYLocation loc = board.getLocationOf(i);
	                returnValue += evaluateManhattanDistanceOf(i, loc);
	                
	                XYLocation locations = gState.getLocationOf((i+1)%9);
	                int xLocation = loc.getXCoOrdinate();
	                int yLocation = loc.getYCoOrdinate();
	                int xSPos = locations.getXCoOrdinate();
	                int ySPos = locations.getYCoOrdinate();
	                int index = xLocation*3+yLocation;
	                int indexs = xSPos*3+ySPos;
	                if(xLocation!=1 && yLocation!=1){
	                	if(indexs != (index+1)%9) returnValue+=2;
	                }
	        }
	        return returnValue;
	
	}

	public int evaluateManhattanDistanceOf(int thisInteger, XYLocation location) {
		        int returnValue = -1;
		        int xPosition = location.getXCoOrdinate();
		        int yPosition = location.getYCoOrdinate();
		        switch (thisInteger) {
		
		        case 1:
		                returnValue = Math.abs(xPosition - 0) + Math.abs(yPosition - 1);
		                break;
		        case 2:
		                returnValue = Math.abs(xPosition - 0) + Math.abs(yPosition - 2);
		                break;
		        case 3:
		                returnValue = Math.abs(xPosition - 1) + Math.abs(yPosition - 0);
		                break;
		        case 4:
		                returnValue = Math.abs(xPosition - 1) + Math.abs(yPosition - 1);
		                break;
		        case 5:
		                returnValue = Math.abs(xPosition - 1) + Math.abs(yPosition - 2);
		                break;
		        case 6:
		                returnValue = Math.abs(xPosition - 2) + Math.abs(yPosition - 0);
		                break;
		        case 7:
		                returnValue = Math.abs(xPosition - 2) + Math.abs(yPosition - 1);
		                break;
		        case 8:
		                returnValue = Math.abs(xPosition - 2) + Math.abs(yPosition - 2);
		                break;
		
		        }
		        return returnValue;
		}
	static EightPuzzleBoard gState = new EightPuzzleBoard(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
}
