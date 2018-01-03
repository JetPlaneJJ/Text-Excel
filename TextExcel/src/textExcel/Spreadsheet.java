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
		return null;
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
		String grid = " ";
		return null;
	}
	public String processCommand(String command)
	{
		//cell inspection. This should return the value at that cell.
		if (command.equals("clear"))
		{
			//clear the entire grid
			
		}
		else if (command.length() <= 3) //if just "A1" or "C15"
		{
			//cell inspection
			
		}
		else if (command.indexOf("clear ") != -1) //clear with a space
		{
			//clearing a particular cell
			
		}
		return "";
	}
	
}
