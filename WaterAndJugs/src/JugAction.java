import aima.core.agent.impl.DynamicAction;

public class JugAction extends DynamicAction {
	public JugAction(String name) {
		super(name);
		setAttribute(jstate, name);
	}
	public static final String jstate = "jugState";
    public static final String fillupjug1 = "fillUpJug1";
    public static final String fillupjug2 = "fillUpJug2";
	public static final String dumpoutjug1 = "dumpOutJug1";
    public static final String dumpoutjug2 = "dumpOutJug2";
    public static final String pourfrom1to2 = "pourFrom1to2";
    public static final String pourfrom2to1 = "pourFrom2to1";
    
    public String getMove() {
        return (String) getAttribute(jstate);
	}	
 }
