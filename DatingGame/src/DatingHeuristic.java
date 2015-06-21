import aima.core.search.framework.HeuristicFunction;

public class DatingHeuristic implements HeuristicFunction {
	public double h(Object s) {
		
		State state = (State)s;
		char[] gState = state.getState();
		char[] goal = new char[]{1,2,1,2,1,2,0};
		
		int count = 0;
		for(int i=0;i<goal.length;i++)
			count+= Math.abs(goal[i] + ((gState[i]=='M')?1:(gState[i]=='F')?2:0));
		return count;
	}

}