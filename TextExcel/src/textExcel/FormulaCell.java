package textExcel;

public class FormulaCell extends RealCell
{
	private Spreadsheet s;
	public FormulaCell(String command, Spreadsheet s)
	{
		super(command);
		this.s = s;
	}

	@Override
	public double getDoubleValue() 
	{
		String noparan = super.fullCellText().substring(super.fullCellText().indexOf("(") + 2, super.fullCellText().indexOf(")")-1); 
		double result = 0.0;
		String[] arr = noparan.split(" ");	
		
		//checking if SUM or AVG
		if (arr[0].toUpperCase().equals("SUM") || arr[0].toUpperCase().equals("AVG")) //FIX THIS!!!
		{
			int countCells = 0;
			if (arr[1].contains("-")) //if multiple cells
			{	
				SpreadsheetLocation start = new SpreadsheetLocation(arr[1].substring(0, arr[1].indexOf("-"))); 
				int startrow = start.getRow();
				int startcol = start.getCol();
				SpreadsheetLocation end = new SpreadsheetLocation(arr[1].substring(arr[1].indexOf("-")+1));
				int endrow = end.getRow();
				int endcol = end.getCol();
				for (int rows = startrow; rows <= endrow; rows++) //go thru all cells between start and end
				{
					for (int cols = startcol; cols <= endcol; cols++)
					{
						String currentcellname = Spreadsheet.getColumnLetterFromColumnNumber(cols)+""+(rows+1);
						SpreadsheetLocation current = new SpreadsheetLocation(currentcellname);
						Cell c = s.getCell(current); 
						result += c.getDoubleValue();
						countCells++;
					}
				}
			}
			else if (arr[1].length() <= 3) 
			{
				SpreadsheetLocation x = new SpreadsheetLocation(arr[1]);
				Cell c = s.getCell(x);
				result += c.getDoubleValue(); //this is getting  an error
				countCells++;
			}
			if (arr[0].equals("AVG"))
			{
				result /= countCells;
			}
			return result;
		}
		
		//checking cell references
		for (int a = 0; a < arr.length; a++)
		{	
			if (isCellReference(arr[a]))
			{
				SpreadsheetLocation x = new SpreadsheetLocation(arr[a]);
				Cell c = s.getCell(x);
				arr[a] = c.getDoubleValue() + "";
			}
		}
		
		result += Double.parseDouble(arr[0]);
		//going thru the ( 3 + A2 + 5 )
		for (int x = 0; x < arr.length-1; x += 2) 
		{
			double b = Double.parseDouble(arr[x+2]);
			if (arr[x+1].equals("+"))
			{
				result += b;
			}
			else if (arr[x+1].equals("*"))
			{
				result *= b;
			}
			else if (arr[x+1].equals("-"))
			{
				result -= b;
			}
			else if (arr[x+1].equals("/"))
			{
				result /= b;
			}
		}
		return result;
	}

	@Override
	public String abbreviatedCellText()
	{
		String s = getDoubleValue() + "";
		int spacesneeded = 10 - s.length();
		if (s.length() < 10)
		{
			for (int x = 0; x < spacesneeded; x++)
			{
				s += " ";
			}
		}
		else if (s.length() > 10)
		{
			s = s.substring(0, 10);
		}
		return s;
	}

	@Override
	public String fullCellText()
	{
		return super.fullCellText().substring(super.fullCellText().indexOf("("));
	}

	public static boolean isCellReference(String input)
	{
	    return Character.isLetter(input.charAt(0));
	}
}
