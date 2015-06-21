public class State {
	char[] state;
	
	public State(){
		state = new char[]{'M','M','M',0,'F','F','F'};
	}
	
	public State(char[] source){
		state = new char[source.length];
		System.arraycopy(source, 0, this.state, 0, state.length);
	}
	
	public State(State gameState){
		this(gameState.getState());
	}
	public char[] getState(){ return state;}
	public int getPositionOfEmptyChair(){
		for(int i=0;i<this.state.length;i++)
			if(this.state[i] == 0)
				return i;
		return -1;
	}
	
	private void swap(int index1,int index2){
		char temp = this.state[index1];
		this.state[index1] = this.state[index2];
		this.state[index2] = temp;
	}
	
	public void moveLeft(){
		int p = getPositionOfEmptyChair();
		if(p != 0)
		{
			char temp = this.state[p];
			this.state[p] = this.state[p-1];
			this.state[p-1] = temp;
		}
	}
	
	public void moveRight(){
		int p = getPositionOfEmptyChair();
		if(p != (this.state.length-1))
		{
			char temp = this.state[p];
			this.state[p] = this.state[p+1];
			this.state[p+1] = temp;
		}
	}
	
	public void jumpLeftOnce(){
		int p = getPositionOfEmptyChair();
		if(p > 1)
		{
			char temp = this.state[p];
			this.state[p] = this.state[p-2];
			this.state[p-2] = temp;
		}
	}
	
	public void jumpRightOnce(){
		int p = getPositionOfEmptyChair();
		if(p < (this.state.length-2))
		{
			char temp = this.state[p];
			this.state[p] = this.state[p+2];
			this.state[p+2] = temp;
		}
	}
	
	public void jumpLeftTwice(){
		int p = getPositionOfEmptyChair();
		if(p > 2)
		{
			char temp = this.state[p];
			this.state[p] = this.state[p-3];
			this.state[p-3] = temp;
		}
	}
	
	public void jumpRightTwice(){
		int p = getPositionOfEmptyChair();
		if(p < (this.state.length-3))
		{
			char temp = this.state[p];
			this.state[p] = this.state[p+3];
			this.state[p+3] = temp;
		}
	}
}
