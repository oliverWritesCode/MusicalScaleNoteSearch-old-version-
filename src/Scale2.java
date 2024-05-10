import java.util.*;

//scale2 extends intervals 
public class Scale2 extends Intervals
{

	//constructor for scale takes string name and array list of intervals between notes so any scale can be defined
	public Scale2(String sType, ArrayList<Integer> sIntervals )
	{
		scaleType = sType;
		intervals = sIntervals;
		this.generate();
	}
	
	//member variables here include scale name, intervals and a 2d array-list here to hold all possible scales of specified type
	public String scaleType;

	ArrayList<Integer> C = new ArrayList<Integer>();
	ArrayList<Integer> CSharp = new ArrayList<Integer>();
	ArrayList<Integer> D = new ArrayList<Integer>();
	ArrayList<Integer> DSharp = new ArrayList<Integer>();
	ArrayList<Integer> E = new ArrayList<Integer>();
	ArrayList<Integer> F = new ArrayList<Integer>();
	ArrayList<Integer> FSharp = new ArrayList<Integer>();
	ArrayList<Integer> G = new ArrayList<Integer>();
	ArrayList<Integer> GSharp = new ArrayList<Integer>();
	ArrayList<Integer> A = new ArrayList<Integer>();
	ArrayList<Integer> ASharp = new ArrayList<Integer>();
	ArrayList<Integer> B = new ArrayList<Integer>();
	
	//this is the 2d array-list
	public ArrayList<ArrayList<Integer>> allScales = new  ArrayList<ArrayList<Integer>>(12);
	
	//this array-list hold the starting note for all the scales found by the located function
	public ArrayList<Integer> located = new ArrayList<Integer>();
	
	//this array-list holds the names of the notes so we can turn the notes from numbers into text by indexing this at certain integer/note values
	public ArrayList<String> allNotes = new ArrayList<String>(Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));
	
	
	
	public void generate()
	{
		//population 2d array-list with all array-lists
		this.allScales.add(this.C);
		this.allScales.add(this.CSharp);
		this.allScales.add(this.D);
		this.allScales.add(this.DSharp);
		this.allScales.add(this.E);
		this.allScales.add(this.F);
		this.allScales.add(this.FSharp);
		this.allScales.add(this.G);
		this.allScales.add(this.GSharp);
		this.allScales.add(this.A);
		this.allScales.add(this.ASharp);
		this.allScales.add(this.B);
		
		//these loops populate each array-list with a scale composed of the specified intervals starting on every note, scales are also all printed for test purposes
		for(int i = 0; i < 12; i += 1)
		{	
			allScales.get(i).add(i+1);
			
			//this loop runs for the size of the intervals array so that scales containing varying amounts of notes can be generated
			for(int x = 0; x < (intervals.size());x += 1)
			{
				//here we add the value of the interval to the last note in the scale
				Integer toAssign = allScales.get(i).get(x) + intervals.get(x);
				
				//this makes sure all values fall within the 12 note scale 
				if (toAssign > 12)
				{
					toAssign = toAssign - 12;
				}
				
				//than we assign the note to the scale
				allScales.get(i).add(toAssign);
				//System.out.println(allScales.get(i).get(x));
			}
			//System.out.println("\n\n");
		}
		
	}
	
	
	public void locate(ArrayList<Integer> toFind)
	{
		//first clear old inputs
		located.clear();
		
		//this searches the 2d scale array for certain notes and adds all the root notes of the scales that were found into the located array
		for(int i = 0; i < 12; i += 1)
		{
			boolean found = allScales.get(i).containsAll(toFind);
			
			if(found == true)
			{
				located.add(i + 1);
			}
		}
		
	}
	 
	//here in main we just test the generate function, you can try it and make your own scales with any names or intervals
	public static void main(String args[])
	{
		
	}
	 
}


//array list of buttons?