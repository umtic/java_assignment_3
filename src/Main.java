import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static String read(String file) {
		String output="";
		try {
			File text=new File(file);
			Scanner reader=new Scanner(text);
			while (reader.hasNextLine()) {
				String data=reader.nextLine();
				output+=data+"\n";}
			reader.close();
		} catch (FileNotFoundException error1) {
			System.out.println("File" + file + "not found");
			error1.printStackTrace();}
		return output;}
	public static void write(String file,String input) {
		try {
			FileWriter writer=new FileWriter(file);
			writer.write(input);
			writer.close();
		} catch (IOException error2) {
			System.out.println("An error occured.");
			error2.printStackTrace();}}
	public static Queue generateQueue() {
		String[]input=(read("queue.txt").split(" "));
		Queue queue=new Queue(Integer.parseInt(input[0]));
		if(input.length>1) {
			for(int i=1;i<input.length;i++) {
				try {
					queue.add(Integer.parseInt(input[i]));
				} catch (NumberFormatException error3) {}}}
		return queue;}
	public static Stack generateStack() {
		String[]input=(read("stack.txt").split(" "));
		Stack stack=new Stack(Integer.parseInt(input[0]));
		for(int i=1;i<input.length;i++) {
			try {
				stack.push(Integer.parseInt(input[i]));
		} catch (NumberFormatException error3) {}}
		return stack;}
	public static void execute(String input) {
		Queue queue=generateQueue();
		String queueOut="";
		Stack stack=generateStack();
		String stackOut="";
		String[]inputLine=input.split("\n");
		for(int i=0;i<inputLine.length;i++) {
			String[]inputWord=inputLine[i].split(" ");
			String dataStructure=inputWord[0];
			String command=inputWord[1];
			if(command.equals("calculateDistance")) {
				if(dataStructure.equals("Q")) {
					int total=queue.calculateDistance();
					queueOut+="After calculateDistance:\nTotal distance="+total+"\n";
					}
				if(dataStructure.equals("S")) {
					int total=stack.calculateDistance();
					stackOut+="After calculateDistance:\nTotal distance="+total+"\n";
				}
			}
			if(command.equals("addOrRemove")) {
				int addOrRemove=Integer.parseInt(inputWord[2]);
				if(addOrRemove>=0) {
					Random random=new Random();
					int newRandom=random.nextInt(50);
					if(dataStructure.equals("Q")) {
						for(int j=0;j<addOrRemove;j++) {queue.add(newRandom);}
						queueOut+="After addOrRemove "+addOrRemove+":\n"+queue.getQueue()+"\n";
						write("queue.txt",queue.getQueue());}
					if(dataStructure.equals("S")) {
						for(int j=0;j<addOrRemove;j++) {stack.add(newRandom);}
						stackOut+="After addOrRemove "+addOrRemove+":\n"+stack.getStack()+"\n";
						write("stack.txt",stack.getStack());}}
				else {
					addOrRemove*=(-1);
					if(dataStructure.equals("Q")) {
						for(int j=0;j<addOrRemove;j++) {queue.remove();}
						addOrRemove*=(-1);
						queueOut+="After addOrRemove "+addOrRemove+":\n"+queue.getQueue()+"\n";
						write("queue.txt",queue.getQueue());}
					if(dataStructure.equals("S")) {
						for(int j=0;j<addOrRemove;j++) {stack.remove();}
						addOrRemove*=(-1);
						stackOut+="After addOrRemove "+addOrRemove+":\n"+stack.getStack()+"\n";
						write("stack.txt",stack.getStack());}}}
			if(command.equals("distinctElements")) {
				if(dataStructure.equals("Q")) {
					int total=queue.distinctElements();
					queueOut+="After distinctElements:\nTotal distinct element="+total+"\n";}
				if(dataStructure.equals("S")) {
					int total=stack.distinctElements();
					stackOut+="After distinctElements:\nTotal distinct element="+total+"\n";}}
			if(command.equals("reverse")) {
				int index=Integer.parseInt(inputWord[2]);
				if(dataStructure.equals("Q")) {
					queue.reverse(index);
					queueOut+="After reverse "+index+":\n"+queue.getQueue()+"\n";
					write("queue.txt",queue.getQueue());}
				if(dataStructure.equals("S")) {
					stack.reverse(index);
					stackOut+="After reverse "+index+":\n"+stack.getStack()+"\n";
					write("stack.txt",stack.getStack());}}
			if(command.equals("removeGreater")) {
				int greater=Integer.parseInt(inputWord[2]);
				if(dataStructure.equals("Q")) {
					queue.removeGreater(greater);
					queueOut+="After removeGreater "+greater+":\n"+queue.getQueue()+"\n";
					write("queue.txt",queue.getQueue());}
				if(dataStructure.equals("S")) {
					stack.removeGreater(greater);
					stackOut+="After removeGreater "+greater+":\n"+stack.getStack()+"\n";
					write("stack.txt",stack.getStack());}}
			if(command.equals("sortElements")) {
				if(dataStructure.equals("Q")) {
					queue.sortElements();
					queueOut+="After sortElements:\n"+queue.getQueue()+"\n";
					write("queue.txt",queue.getQueue());}
				if(dataStructure.equals("S")) {
					stack.sortElements();
					stackOut+="After sortElements:\n"+stack.getStack()+"\n";
					write("stack.txt",stack.getStack());}}}
		write("queueOut.txt",queueOut);
		write("stackOut.txt",stackOut);}
	public static void main(String[] args) {execute(read(args[0]));}}