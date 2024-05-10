import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.FileWriter; 
import java.io.BufferedWriter;
import java.io.IOException;

public class Scale_GUI
{

	//here we declare the four scale types that we will be working with
	ArrayList<Integer> Major = new ArrayList<Integer>(Arrays.asList(2,2,1,2,2,2));
	Scale2 testMaj = new Scale2("Major", Major);
		
	ArrayList<Integer> Minor = new ArrayList<Integer>(Arrays.asList(2,1,2,2,1,2));
	Scale2 testMin = new Scale2("Minor", Minor);
		
	ArrayList<Integer> HarmonicMinor = new ArrayList<Integer>(Arrays.asList(2,1,2,2,1,3));
	Scale2 testMinHar = new Scale2("HarmonicMinor", HarmonicMinor);
		
	ArrayList<Integer> Blues = new ArrayList<Integer>(Arrays.asList(3,2,1,1,3));
	Scale2 testBlues = new Scale2("Blues", Blues);
	

	
	//this is an array-list of the above scale objects
	ArrayList<Scale2> allScalesSearched = new ArrayList<Scale2>();
			
	//this string is used to display and hold user inputs
	String userInputString = " ";
	
	//GUI - basic elements


	Frame myFrame;
	Panel myPanel1;
	Panel myPanel2;
	Panel myPanel3;

	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
	
	JButton enter;
	
	Label displayInputs;
	TextArea displayScales;//very useful for displaying large pieces of text
	
	//here in the constructor we add the scales to the scale array
	public Scale_GUI() 
	{
		allScalesSearched.add(testMaj);
		allScalesSearched.add(testMin);
		allScalesSearched.add(testMinHar);
		allScalesSearched.add(testBlues);
	}


	public String getScaleDisplay()
	{
		//first string gets reset to be empty
		String outputScales = " ";
		
		//this loop runs for the amount of scale types that have been declared/generated, I declared 4 types of scales currently so it runs 4 times
		for(int i = 0; i < allScalesSearched.size(); i += 1)
		{
		
			//here i assign the current scale were working on and its located array to new array-lists to make things more clear and readable
			Scale2 currentScale = allScalesSearched.get(i);
			ArrayList<Integer> myLocated = currentScale.located;
		
			//this loop runs for the size of the located array of the current scale, so it runs once for every scale that contained the notes being searched for
			for(int x = 0; x < myLocated.size(); x += 1)
			{
			
				// current scale objects "all notes" array at the position of the starting note of the current found scale plus that scales string are added to display string
				outputScales = outputScales + "\n" +  currentScale.allNotes.get((myLocated.get(x)) - 1) + " " + currentScale.scaleType;
				
				//this is the algorithm for printing the specific notes after the specific scale
				outputScales = outputScales + " (";
						
				//here we assign the actual scale where the notes were found to an array-list because it makes this more readable
				ArrayList<Integer> scaleInstance = currentScale.allScales.get(myLocated.get(x) - 1);			
										
				//this loop runs for the size of the scale were printing from
				for(int z = 0; z < currentScale.allScales.get(0).size(); z += 1)
				{		
					//the current scale objects "all notes" array which contains note names as text, at the current scales "all scales" array at current located index gets added to display string
					outputScales = outputScales + currentScale.allNotes.get(scaleInstance.get(z) - 1 );
				
					//this loop adds a coma after each note as long as that note is not the last not in the scale
					if(z != currentScale.allScales.get(0).size()-1)
					{
						outputScales = outputScales + ", ";
					}
					
				}					
				
				//the notes of a scale are printed after the scale in-between parentheses ()
				outputScales = outputScales + ") ";
				
			}
		}
		
		//return the string with all the text generated
		return outputScales;
	}
	
	
	//this method just prints a string to a file, we pass it a modified version of the string returned from getScaleDisplay
	public void writeToFile(String toWrite)throws IOException 
	{	
		BufferedWriter writer = new BufferedWriter(new FileWriter("scalesOutput.txt", true));
		writer.write(toWrite);
		writer.close();
	}

	//this sets up the GUI
	public void go()
	{
		myFrame = new Frame("Scale Finder");
		
		myPanel1 = new Panel();
		myPanel2 = new Panel();
		
		//decalare a button per note
		b1 = new JButton("C");
		b2 = new JButton("C#");
		b3 = new JButton("D");
		b4 = new JButton("D#");
		b5 = new JButton("E");
		b6 = new JButton("F");
		b7 = new JButton("F#");
		b8 = new JButton("G");
		b9 = new JButton("G#");
		b10 = new JButton("A");
		b11 = new JButton("A#");
		b12 = new JButton("B");
		
		enter = new JButton("Enter");
		
		b2.setOpaque(true);
		b4.setOpaque(true);
		b7.setOpaque(true);
		b9.setOpaque(true);
		b11.setOpaque(true);
		
		
		//make sharps and flats black
		b2.setBackground(Color.BLACK);
		b4.setBackground(Color.BLACK);
		b7.setBackground(Color.BLACK);
		b9.setBackground(Color.BLACK);
		b11.setBackground(Color.BLACK);
		
		b2.setForeground(Color.BLACK);
		b4.setForeground(Color.BLACK);
		b7.setForeground(Color.BLACK);
		b9.setForeground(Color.BLACK);
		b11.setForeground(Color.BLACK);
		
		myFrame.add(myPanel1, BorderLayout.NORTH);
		
		//make buttons piano note shaped
		Dimension buttonSize = new Dimension(50, 290);
		b1.setPreferredSize(buttonSize);
		b2.setPreferredSize(buttonSize);
		b3.setPreferredSize(buttonSize);
		b4.setPreferredSize(buttonSize);
		b5.setPreferredSize(buttonSize);
		b6.setPreferredSize(buttonSize);
		b7.setPreferredSize(buttonSize);
		b8.setPreferredSize(buttonSize);
		b9.setPreferredSize(buttonSize);
		b10.setPreferredSize(buttonSize);
		b11.setPreferredSize(buttonSize);
		b12.setPreferredSize(buttonSize);
		
		//make button handler object and assign it to all buttons
		buttonHandler test = new buttonHandler();
		
		b1.addActionListener(test);
		b2.addActionListener(test);
		b3.addActionListener(test);
		b4.addActionListener(test);
		b5.addActionListener(test);
		b6.addActionListener(test);
		b7.addActionListener(test);
		b8.addActionListener(test);
		b9.addActionListener(test);
		b10.addActionListener(test);
		b11.addActionListener(test);
		b12.addActionListener(test);
		
		enter.addActionListener(test);
		
		myPanel1.add(b1);
		myPanel1.add(b2);
		myPanel1.add(b3);
		myPanel1.add(b4);
		myPanel1.add(b5);
		myPanel1.add(b6);
		myPanel1.add(b7);
		myPanel1.add(b8);
		myPanel1.add(b9);
		myPanel1.add(b10);
		myPanel1.add(b11);
		myPanel1.add(b12);
		
		
		//put everything together
		Dimension panelSize1 = new Dimension(970, 300);
		myPanel1.setPreferredSize(panelSize1);
		
		displayScales = new TextArea("System Output");
		displayScales.setPreferredSize(new Dimension(950, 500));
		
		displayInputs = new Label("User Input                                                            ");
		
		myPanel2.add(displayInputs);
		myPanel2.add(enter);
		myPanel2.add(displayScales);
		
		myFrame.add(myPanel2, BorderLayout.CENTER);

		
		myFrame.setResizable(false);
		myFrame.setSize(1000,810);
		myFrame.setVisible(true);
	}
	
	
	/*public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}*/
	
	
	//inner class implements action listener
	public class buttonHandler implements ActionListener
	{
		//this array is used to store user inputs
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		
		//this arraylist holds the text found on the note buttons
		public ArrayList<String> buttonsText = new ArrayList<String>(Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));
		
		//this method takes a string notename and we pass in the getActionCommand from the button event
		public void pressed(String noteName)
		{
				//here we get the int for the index of the button pressed from the buttons text array-list
				int index = buttonsText.indexOf(noteName);
				
				//if the number is not already in the inputs array it is added to the inputs array
				if(! inputs.contains(index + 1))
				{
					//System.out.println("Adding note " + noteName + " index=" + index);
		
					inputs.add(index + 1);
				
					//and than the note in string form is added to the userInputs string and displayed to the screen so user can track inputs
					userInputString = userInputString + noteName + ", ";
				
					displayInputs.setText(userInputString);
				}
		}
		
		public void actionPerformed(ActionEvent e)
		{	
			
			//if the button pressed is the enter button, than we run the locate function using the array of user inputs as the search criteria
			if(e.getActionCommand().equals("Enter"))
			{
				
				testMaj.locate(inputs);
				testMin.locate(inputs);
				testMinHar.locate(inputs);
				testBlues.locate(inputs);
		
				
				String scalesText = "\nInput notes: " + userInputString + "\n"+ getScaleDisplay();
				
				System.out.println(scalesText);
				
				displayScales.setText(scalesText);
				
				//here we print the output to a file
				try 
				{
					writeToFile(scalesText);
				}catch (IOException x) 
				{
    				x.printStackTrace();
    			}	
				
				
				displayInputs.setText("User Input                                                            ");
				
				inputs.clear();
				
				userInputString = " ";
				
				//and if another note has been pressed other than enter, we run the pressed method defined above with the getActionCommand string
			}	else
			{
				pressed(e.getActionCommand());
			}
			
		}//end button method
			
	}//end buttonHandler
	

	//public static void main(String args[])
	//{
		//Scale_GUI test = new Scale_GUI();
		//test.go();
	//}//end main method
	
}//end Scale_GUI
