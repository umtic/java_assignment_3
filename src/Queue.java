public class Queue{
	private int[]queue;
	public Queue(int newValue) {
		int newQueue[]=new int[1];
		newQueue[0]=newValue;
		this.queue=newQueue;}
	public void add(int newValue) {
		int newQueue[]=new int[queue.length+1];
		for (int i=0;i<queue.length;i++) {newQueue[i]=queue[i];}
		newQueue[queue.length]=newValue;
		this.queue=newQueue;}
	public void remove() {
		int newQueue[]=new int[queue.length-1];
		for(int i=1;i<queue.length;i++) {newQueue[i-1]=queue[i];}
		this.queue=newQueue;}
	public String getQueue() {
		String output="";
		for(int i=0;i<queue.length;i++) {output+=queue[i]+" ";}
		return output;}
	public int calculateDistance() {
		int total=0;
		for(int i=0;i<queue.length;i++) {
			int value1=queue[i];
			for(int j=1;i<j;j++) {
				int value2=queue[j];
				int distance=value1-value2;
				if(distance<0) {distance*=(-1);}
				total+=distance;}}
		return total;}
	public int distinctElements() {
		int[]distinct=new int[queue.length];
		distinct[0]=queue[0];
		int total=1;
		for(int i=1;i<queue.length;i++) {
			boolean isDistinct=true;
			for(int j=1;j<distinct.length;j++) {
				if(queue[i]==distinct[j]) {
				isDistinct=false;
				break;}}
			if(isDistinct) {
				distinct[i]=queue[i];
					total+=1;}}
		return total;}
	public void reverse(int index) {
		int j=index-1;
		int median=index/2;
		for(int i=0;i<median;i++) {
			int number=queue[i];
			queue[i]=queue[j];
			queue[j]=number;
			j-=1;}}
	public void removeGreater(int greater) {
		int pointer=0;
		for(int i=0;i<queue.length;i++) {
			if(queue[i]>greater) {pointer+=1;}}
		int[]newQueue=new int[queue.length-pointer];
		int j=0;
		for(int i=0;i<queue.length;i++) {
			if(queue[i]<=greater) {
				newQueue[j]=queue[i];
				j+=1;}}
		this.queue=newQueue;}
	public void sortElements() {
		for(int i=0;i<queue.length;i++) {
			for(int j=i+1;j<queue.length;j++) {
				if(queue[j]<queue[i]) {
					int number=queue[i];
					queue[i]=queue[j];
					queue[j]=number;}}}}}