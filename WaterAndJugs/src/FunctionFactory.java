import java.util.LinkedHashSet;
import java.util.Set;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import aima.core.agent.Action;

public class FunctionFactory {
	private static ActionsFunction thisIAF;
    private static ResultFunction thisRF;
    
    public static ActionsFunction getIAF() {
        if (null == thisIAF) {
                thisIAF = new thisActionsFunction();
        }
        return thisIAF;
    }
    public static ResultFunction getRF() {
        if (null == thisRF) {
                thisRF = new thisResultFunction();
        }
        return thisRF;
    }
    
    private static class thisActionsFunction implements ActionsFunction{
		public Set<Action> actions(Object arg0) {			
			Set<Action> actions = new LinkedHashSet<Action>();
			actions.add(new JugAction(JugAction.dumpoutjug1));
			actions.add(new JugAction(JugAction.dumpoutjug2));
			actions.add(new JugAction(JugAction.fillupjug1));
			actions.add(new JugAction(JugAction.fillupjug2));
			actions.add(new JugAction(JugAction.pourfrom1to2));
			actions.add(new JugAction(JugAction.pourfrom2to1));
			return actions;
		}    	
    }
    public static class thisResultFunction implements ResultFunction{
		public Object result(Object object, Action action) {
				State state = (State) object;
				State newState = new State(state.getJug1(),state.getJug2());
                JugAction jugaction = (JugAction) action;                
                if (jugaction.getName() == JugAction.dumpoutjug1)
                	newState.dumpOutJug1();
                else if (jugaction.getName() == JugAction.dumpoutjug2)
                	newState.dumpOutJug2();
                else if (jugaction.getName() == JugAction.fillupjug1)
                	newState.fillUpJug1();
                else if (jugaction.getName() == JugAction.fillupjug2)
                	newState.fillUpJug2();
                else if (jugaction.getName() == JugAction.pourfrom1to2)
                	newState.pourFrom1to2();
                else if (jugaction.getName() == JugAction.pourfrom2to1)
                	newState.pourFrom2to1();                
                object = newState;
        return object;
		}    	
    }
}