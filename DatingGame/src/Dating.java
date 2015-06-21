import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.BreadthFirstSearch;

public class Dating {

	public static void main(String[] args) {
		datingBFS();
		datingAStar();
	}
	
	public static void datingBFS(){
		try {
			FileWriter outFile = new FileWriter("DatingResultsBFS.txt");
			PrintWriter output = new PrintWriter(outFile);
			output.println("Function output from dating game problem.");
			output.println("Solved with AIMA's breadth first search algorithm.");
			
			Problem thisProblem = new Problem(new State(),
					FunctionFactory.getCActionsFunction(),
					FunctionFactory.getResultFunction(),
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
	private static void datingAStar() {

		try {
			FileWriter outFile = new FileWriter("DatingResultsAStar.txt");
			PrintWriter output = new PrintWriter(outFile);
			output.println("Function output from dating game problem.");
			output.println("Solved with AIMA's A* search algorithm.");
			
			Problem thisProblem = new Problem(new State(),
					FunctionFactory.getCActionsFunction(),
					FunctionFactory.getResultFunction(),
					new GoalState());
			Search thisSearch = new AStarSearch(new GraphSearch(),new DatingHeuristic());
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