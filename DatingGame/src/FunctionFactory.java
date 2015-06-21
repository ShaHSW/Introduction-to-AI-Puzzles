import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

public class FunctionFactory {
	
    private static ActionsFunction _cActionsFunction = null;
    private static ResultFunction _resultFunction = null;
    
    
    public static ActionsFunction getCActionsFunction() {
        if (null == _cActionsFunction) {
                _cActionsFunction = new datingCActionsFunction();
        }
        return _cActionsFunction;
    }
    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
                _resultFunction = new datingResultFunction();
        }
        return _resultFunction;
    }
    
    private static class datingCActionsFunction implements ActionsFunction{
		public Set<Action> actions(Object arg0) {
			Set<Action> actions = new LinkedHashSet<Action>();
			actions.add(new DatingAction(DatingAction.leftshift));
			actions.add(new DatingAction(DatingAction.rightshift));
			actions.add(new DatingAction(DatingAction.leapleft));
			actions.add(new DatingAction(DatingAction.doubleleapleft));
			actions.add(new DatingAction(DatingAction.leapright));
			actions.add(new DatingAction(DatingAction.doubleleapright));
			return actions;
		}
    }
    
    public static class datingResultFunction implements ResultFunction{
		public Object result(Object o, Action a) {
			if (a instanceof DatingAction) {
				DatingAction dga = (DatingAction) a;
				State state = (State) o;
				State newState = new State(state);
                
                if (dga.getName() == DatingAction.leftshift)
                	newState.moveLeft();
                else if (dga.getName() == DatingAction.rightshift)
                	newState.moveRight();
                else if (dga.getName() == DatingAction.leapleft)
                	newState.jumpLeftOnce();
                else if (dga.getName() == DatingAction.doubleleapleft)
                	newState.jumpLeftTwice();
                else if (dga.getName() == DatingAction.leapright)
                	newState.jumpRightOnce();
                else if (dga.getName() == DatingAction.doubleleapright)
                	newState.jumpRightTwice();
                
                o = newState;
        }
        // if action is not understood or is a NoOp
        // the result will be the current state.
        return o;
		}
    }
}