package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cellz;
	public Spreadsheet()
	{
		cellz = new Cell[21][12];
		for (int x = 0; x < 21; x++)
		{
			for (int y = 0; y < 12; y++)
			{
				cellz[x][y] = new EmptyCell();
			}
		}
	}
	
	public int getRows() 
	{
		return 20;
	}
	public int getCols() 
	{
		return 12;
	}
	public Cell getCell(Location loc)
	{
		
		return cellz[loc.getRow()][loc.getCol()];
		/*return cellz[loc.getRow()][loc.getCol()];*/
	}
	
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
	
// Checkpoint 2 
	public String getGridText()
	{
		//12 col x 20 row
		String grid = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |";
		for (int row = 1; row < 21; row++)
		{
			if (row <= 9)
			{
				grid += "\n" + row + "  |" ; //2 spaces
				//ex: (newline) 1  |
			}
			else
			{
				grid += "\n" + row + " |"; //only 1 space
			}
			for (int col = 0; col < 12; col++)
			{
				grid += cellz[row][col].abbreviatedCellText() + "|"; //each must be 10 spaces long no matter what
			}
		}
		grid += "\n";
		return grid;
	}
	public String processCommand(String command)
	{
		if (command.toLowerCase().equals("clear"))
		{
			//clear the entire grid. maybe insert EmptyCell in each array element?
			for (int row = 0; row < cellz.length; row++)
			{
				for (int col = 0; col < cellz[row].length; col++)
				{
					cellz[row][col] = new EmptyCell();
				}
			}
			String result = getGridText();
			return result;
		}
		else if (command.length() <= 3 && command.length() > 0) //if just "A1" or "C15"
		{
			//cell inspection
			//maybe use the getCell
			String cellspecific = command.substring(command.indexOf(" ") + 1); //ex: clear A1 >> cellspecific = A1
			int column = getColumnNumberFromColumnLetter(cellspecific.substring(0, 1));
			int row = Integer.parseInt(command.substring(1));
			if (cellz[row][column].isEmptyCell()) //if this cell is empty
			{
				return "";
			}
			else if (!cellz[row][column].fullCellText().equals(""))
			{
				return "\"" + cellz[row][column].fullCellText() + "\"";
			}
			else
			{
				return "";
			}
			
		}
		else if (command.toLowerCase().indexOf("clear ") != -1) //clearing a particular cell
		{
			String cellspecific = command.substring(command.indexOf(" ") + 1); //ex: clear A1 >> cellspecific = A1
			int column = getColumnNumberFromColumnLetter(cellspecific.substring(0, 1));
			int row = Integer.parseInt(cellspecific.substring(1));
			cellz[row][column] = new EmptyCell();
			String result = getGridText();
			return result;
		}
		else if (command.indexOf(" = ") != -1) //assignment
		{
			String[] split = command.split(" ");
			int column = getColumnNumberFromColumnLetter(command.substring(0, 1));
			int row = Integer.parseInt(split[0].substring(1));
			String input = command.substring(command.indexOf("=") + 3, command.length()-1);
			
			cellz[row][column] = new TextCell(input); //that's an assumption that it is a text cell, not something else
			
			
			String result = getGridText();
			return result;
		}
		else
		{
			return "";
		}
	}
	
}
