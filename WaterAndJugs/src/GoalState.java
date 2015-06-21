import aima.core.search.framework.GoalTest;

public class GoalState implements GoalTest{
		public boolean isGoalState(Object state) {
			
			State thisState = (State) state;
			
			if(thisState.getJug1() == 2 && thisState.getJug2()==0)
				return true;
			else
				return false;
		}

	}