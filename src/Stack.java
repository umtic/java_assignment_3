public class Stack {
	private int[]stack;
	public Stack(int newValue) {
		int newStack[]=new int[1];
		newStack[0]=newValue;
		this.stack=newStack;}
	public void push(int newValue) {
		int newStack[]=new int[stack.length+1];
		for (int i=0;i<stack.length;i++) {newStack[i]=stack[i];}
		newStack[stack.length]=newValue;
		this.stack=newStack;}
	public void add(int newValue) {
		int newStack[]=new int[stack.length+1];
		for (int i=0;i<stack.length;i++) {newStack[i+1]=stack[i];}
		newStack[0]=newValue;
		this.stack=newStack;}
	public void remove() {
		int newStack[]=new int[stack.length-1];
		for(int i=1;i<stack.length;i++) {newStack[i-1]=stack[i];}
		this.stack=newStack;}
	public String getStack() {
		String output="";
		for(int i=0;i<stack.length;i++) {
			int value=stack[i];
			output+=value+" ";}
		return output;}
	public int calculateDistance() {
		int total=0;
		for(int i=0;i<stack.length-1;i++) {
			int value1=stack[i];
			for(int j=i+1;j<stack.length;j++) {
				int value2=stack[j];
				int distance=value1-value2;
				if(distance<0) {distance*=(-1);}
				total+=distance;}}
		return total;}
	public int distinctElements() {
		int[]distinct=new int[stack.length];
		distinct[0]=stack[0];
		int total=1;
		for(int i=1;i<stack.length;i++) {
			boolean isDistinct=true;
			for(int j=1;j<distinct.length;j++) {
				if(stack[i]==distinct[j]) {
				isDistinct=false;
				break;}}
			if(isDistinct) {
				distinct[i]=stack[i];
					total+=1;}}
		return total;}
	public void reverse(int index) {
		int j=index-1;
		int median=index/2;
		for(int i=0;i<median;i++) {
			int number=stack[i];
			stack[i]=stack[j];
			stack[j]=number;
			j-=1;}}
	public void removeGreater(int greater) {
		int pointer=0;
		for(int i=0;i<stack.length;i++) {
			if(stack[i]>greater) {pointer+=1;}}
		int[]newQueue=new int[stack.length-pointer];
		int j=0;
		for(int i=0;i<stack.length;i++) {
			if(stack[i]<=greater) {
				newQueue[j]=stack[i];
				j+=1;}}
		this.stack=newQueue;}
	public void sortElements() {
		for(int i=0;i<stack.length;i++) {
			for(int j=i+1;j<stack.length;j++) {
				if(stack[j]<stack[i]) {
					int number=stack[i];
					stack[i]=stack[j];
					stack[j]=number;}}}}}