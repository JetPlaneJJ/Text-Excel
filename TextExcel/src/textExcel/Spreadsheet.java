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
		//TODO: fix this!
		cellz = new Cell[20][12];
		//outer = row
		//inner = col
		for (int x = 0; x < 20; x++)
		{
			for (int y = 0; y < 12; y++)
			{
				cellz[x][y] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows() //must be correct for Ch1
	{
		// TODO Auto-generated method stub
		SpreadsheetLocation x = new SpreadsheetLocation(null);
		return x.getRow();
	}

	@Override
	public int getCols() //must be correct for Ch1 
	{
		// TODO Auto-generated method stub
		SpreadsheetLocation x = new SpreadsheetLocation(null);
		return x.getCol();
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
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
}
