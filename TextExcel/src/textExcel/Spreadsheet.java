package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cellz;
	public Spreadsheet()
	{
		cellz = new Cell[20][12];
		for (int x = 0; x < 20; x++)
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
		for (int row = 0; row < 20; row++)
		{
			int rowname = row+1;
			if (rowname <= 9)
			{
				grid += "\n" + rowname + "  |" ; //2 spaces
				//ex: (newline) 1  |
			}
			else
			{
				grid += "\n" + rowname + " |"; //only 1 space
			}
			for (int col = 0; col < 12; col++)
			{
				grid += cellz[row][col].abbreviatedCellText() + "|"; 
			}
		}
		grid += "\n";
		return grid;
	}
	public String processCommand(String command)
	{
		if (command.toLowerCase().equals("clear"))
		{
			//clear the entire grid
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
		else if (command.length() <= 3 && command.length() > 0)
		{
			//cell inspection
			int column = getColumnNumberFromColumnLetter(command.substring(0, 1));
			int row = Integer.parseInt(command.substring(1)) -1; 
			if (cellz[row][column].fullCellText().equals("          ")) //if cell empty
			{
				return "";
			}
			else
			{
				return "\"" + cellz[row][column].fullCellText() + "\"";
			}
			
		}
		else if (command.toLowerCase().indexOf("clear ") != -1) //clearing 1 cell
		{
			String cellspecific = command.substring(command.indexOf(" ") + 1);
			int column = getColumnNumberFromColumnLetter(cellspecific.substring(0, 1));
			int row = Integer.parseInt(cellspecific.substring(1)) -1;			
			cellz[row][column] = new EmptyCell();
			String result = getGridText();
			return result;
		}
		else if (command.indexOf(" = ") != -1 && command.indexOf("\"") != -1) //assignment to a TEXTCELL
		{
			String[] split = command.split(" ");
			int column = getColumnNumberFromColumnLetter(command.substring(0, 1));
			int row = Integer.parseInt(split[0].substring(1)) - 1; 
			String input = command.substring(command.indexOf("=") + 3, command.length()-1);
			
			cellz[row][column] = new TextCell(input); 
			String result = getGridText();
			return result;
		}
		else
		{
			return "";
		}
	}
	
}
