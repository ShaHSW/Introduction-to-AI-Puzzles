import java.util.List;
import java.io.*;
import aima.core.agent.Action;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;

public class WaterAndJugs {
	public static void main(String[] args) {

		try {
			FileWriter outFile = new FileWriter("WaterAndJugsResultsBFS.txt");
			PrintWriter output = new PrintWriter(outFile);
			output.println("Function output from water and jugs problem.");
			output.println("Solved with AIMA's breadth first search algorithm.");
			
			Problem thisProblem = new Problem(new State(),
					FunctionFactory.getIAF(),
					FunctionFactory.getRF(),
					new GoalState());
			Search thisSearch = new BreadthFirstSearch(new TreeSearch());
			SearchAgent thisAgent = new SearchAgent(thisProblem, thisSearch);
			
			output.println("The pathcost is " + thisAgent.getInstrumentation().getProperty(thisAgent.getInstrumentation().keySet().toArray()[0].toString()));
			output.println("The actions taken are:");
			List<Action> theseActions = thisAgent.getActions();
			for (int i = 0; i < theseActions.size(); i++) {
				String thisAction = theseActions.get(i).toString();
				output.println(thisAction);
			}
			output.close();
			
			System.out.println("Success at " + java.util.Calendar.getInstance().getTime() + "!");
		} catch (Exception e) {}
	}
}