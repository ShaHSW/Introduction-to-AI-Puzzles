import aima.core.search.framework.GoalTest;

public class GoalState implements GoalTest {
	public boolean isGoalState(Object s) {
		char[] goal = new char[]{'M','F','M','F','M','F',0};
		State state = (State) s;
		char[] gState = state.getState();
		for(int i=0;i<gState.length;i++)
			if(gState[i] != goal[i])
				return false;
		return true;
	}
}