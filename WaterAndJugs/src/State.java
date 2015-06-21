
	public class State {

		int jug1Capacity = 4;
		int jug2Capacity = 3;
		int jug1Level = 0;
		int jug2Level = 0;
		
		public State(){}
		
		public State(int water1, int water2){
			jug1Level = water1;
			jug2Level = water2;
		}
		
		public void setJug1(int water){
			jug1Level = water;
		}
		public void setJug2(int water){
			jug2Level = water;
		}
		public int getJug1(){
			return jug1Level;
		}
		public int getJug2(){
			return jug2Level;
		}		
		public void fillUpJug1(){
			jug1Level=jug1Capacity;
		}
		public void fillUpJug2(){
			jug2Level=jug2Capacity;
		}
		public void dumpOutJug1(){
			jug1Level=0;
		}
		public void dumpOutJug2(){
			jug2Level=0;
		}
		public void pourFrom1to2(){
			if(jug1Level > jug2Capacity - jug2Level)
			{
				jug1Level -= jug2Capacity - jug2Level;
				jug2Level = jug2Capacity;
			}
			else
			{
				jug2Level += jug1Level;
				jug1Level = 0;
			}
		}
		public void pourFrom2to1(){
			if(jug2Level > jug1Capacity - jug1Level)
			{
				jug2Level -= jug1Capacity - jug1Level;
				jug1Level = jug1Capacity;
			}
			else
			{
				jug1Level += jug2Level;
				jug2Level = 0;
			}
		}
	}