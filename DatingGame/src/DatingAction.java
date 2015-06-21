import aima.core.agent.impl.DynamicAction;


public class DatingAction extends DynamicAction {
	
	public DatingAction(String name) {
		super(name);
		//setAttribute(ATTRIBUTE_JUG_STATE, name);
	}
	public static final String leftshift = "moveLeft";
    public static final String rightshift = "moveRight";
    public static final String leapleft = "jumpLeftOnce";
    public static final String doubleleapleft = "jumpLeftTwice";
    public static final String leapright = "jumpRightOnce";
    public static final String doubleleapright = "jumpRightTwice";


 }
