package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cellz;
//Spreadsheet constructor Checkpoint 1
	public Spreadsheet()
	{
		/*
		 * Your Spreadsheet constructor should initialize a 2D array
		 * of Cells with all elements containing EmptyCell objects.
		 */
		cellz = new Cell[20][12];
		for (int x = 0; x < 20; x++)
		{
			for (int y = 0; y < 12; y++)
			{
				cellz[x][y] = new EmptyCell();
			}
		}
	}
	/*public String processCommand(String command)
	{
		//from Checkpoint 1, DO NOT USE!
		return "";
	}*/
	public int getRows() //must be correct for Ch1
	{
		return 20;
	}
	public int getCols() //must be correct for Ch1 
	{
		return 12;
	}
	public Cell getCell(Location loc)
	{
		if (true) //not empty
		{
			return null;
		}
		else //if empty
		{
			Cell x = new EmptyCell();
			return x;
		}
	}
	/*public String getGridText()
	{
		//From checkpoint 1, do NOT USE!
		return null;
	}*/
	
	// You are free to use this helper method.  It takes a column letter (starting at "A")
	// and returns the column number corresponding to that letter (0 for "A", 1 for "B", etc.)  
	// WARNING!!  If the parameter is not a single, capital letter in the range of your Spreadsheet,
	// bad things might happen!
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}
	// You are free to use this helper method.  It takes a column number (starting at 0)
	// and returns the column letter corresponding to that number ("A" for 0, "B" for 1, etc.)
	// WARNING!!  If the parameter is not a number in the range of your Spreadsheet,
	// bad things might happen!
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
	
// Checkpoint 2 methods
	public String getGridText()
	{
		//12 col x 20 row
		/* Return a string containing the entire sheet 
		 * grid in the form described in the spec.
		*/
		String grid = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |";
		grid += 	"/n1  |";
		return null;
	}
	public String processCommand(String command)
	{
		if (command.equals("clear"))
		{
			//clear the entire grid. maybe insert EmptyCell in each array element?
			for (int row = 0; row < cellz.length; row++)
			{
				for (int col = 0; col < cellz[row].length; col++)
				{
					cellz[row][col] = new EmptyCell();
				}
			}	
		}
		else if (command.length() <= 3) //if just "A1" or "C15"
		{
			//cell inspection
			String cellspecific = command.substring(command.indexOf(" ") + 1); //ex: clear A1 >> cellspecific = A1
			int column = getColumnNumberFromColumnLetter(cellspecific.substring(0, 1));
			int row = Integer.parseInt(cellspecific.substring(1));
			//go to that cell??
			
		}
		else if (command.indexOf("clear ") != -1) //clear with a space
		{
			//clearing a particular cell
			String cellspecific = command.substring(command.indexOf(" ") + 1); //ex: clear A1 >> cellspecific = A1
			int column = getColumnNumberFromColumnLetter(cellspecific.substring(0, 1));
			int row = Integer.parseInt(cellspecific.substring(1));
			cellz[row][column] = new EmptyCell();
		}
		else
		{
			return "";
		}
		return "";
	}
	
}
