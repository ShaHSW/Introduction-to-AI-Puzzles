# Introduction-to-AI-Puzzles


Path finding or graph traveling is an interesting problem to computer science.
This post talks about three basic search algorithms with heurist function and a java implementation in solving small puzzles – The Pairing Game. 

Search algorithm without heuristics

Breadth First Search Algorithm
Breadth First Search Algorithm chooses the neighbor node before moving to the next level.

 

Worst cases performance: O(|E|)= O(b^d)
Worst cases space complexity: O(|V|)= O(b^d)

Depth First Search Algorithm
Depth First Search algorithm chooses the node at next level before move to next branch.
 
Worst cases performance: O(|E|) if the graph traversed without repetition.  O(b^d) If the implicit graph with search to depth d
Worst cases space complexity: O(|V|) if the graph traversed without repetition. O(Max(path length) If the implicit graph without elimination of duplicate nodes.

Heuristics is to find a solution in a reasonable time frame for a problem when traditional methods fail to find any solutions.
It might be the best solution or simplest solution. 

Best First Search Algorithm
Best First Search algorithm chooses the unvisited node with the best heuristic values to visit next. 
 BFS only takes cost to get next node from current note. It doesn’t consider the cost of getting to next node from the goal. 

A* Search Algorithm
A* Search is BFS with lowest-cost breadth first search. 

Detailed example from UC-Berkeley: http://aima.eecs.berkeley.edu/slides-pdf/chapter04a.pdf 

The Water and Jugs Problem
There are two jugs. One holds 4 gallons and the other holds 3 gallons of water. Assume there is no external measure devices and unlimited water, which you can use to fill the jugs. How can we get exactly 2 gallons of water in the 4 gallons jug?

The implementation solution uses AIMA breadth first search.

The 8 Puzzles 
The 8 puzzle is a smaller version of 15 puzzles.
https://en.wikipedia.org/wiki/15_puzzle 

The implementation solution uses AIMA A* search with Manhattan distance heurist and nMaxSwap heuritics.

The Dating Game
This dating game consists of three males (M) three females (F), and an empty spot. The initial configuration is as follows:
	
F	F	F		M	M	M

The game has two legal moves with associated costs:
	A person (M or F) may move into an adjacent empty chair. This has a cost of 1.
	A person can jump over one or two other person into the empty chair. ThIS has a cost equal to the number of persons jumped over. 
The goal is the pair each M with F. The goal configuration as below:
M	F	M	F	M	F	


The implementation shows two ways to solving this problems with Best First Search and A* Search. 

AIMA-Java Core Algorithms
This java implementation is for the book Artificial Intelligence a Modern Approach 3rd ED: http://www.amazon.com/Artificial-Intelligence-Modern-Approach-Edition/dp/0136042597 

It gives readers the most comprehensive and up to date introduction to the theory and practice of AI. 
