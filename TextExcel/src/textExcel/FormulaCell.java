package textExcel;

public class FormulaCell extends RealCell
{
	//field, SPREADSHEET
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
		
		//change all cell references to double values
		for (int a = 0; a < arr.length; a++)
		{
			if (isCellReference(arr[a]) && !arr[a].equals("SUM") && !arr[a].equals("AVG"))
			{
				SpreadsheetLocation x = new SpreadsheetLocation(arr[a]);
				Cell c = this.s.getCell(x);
				arr[a] = c.getDoubleValue() + "";
			}
		}
		if (arr[0].equals("SUM") || arr[0].equals("AVG")) //FIX THIS!!!
		{
			//example AVG, A1-A5
			int countCells = 0;
			for (int a = 0; a < arr.length; a++)
			{
				
			}
			if (arr[0].equals("AVG"))
			{
				result /= countCells;
			}
			return result;
		}
		//if no cell references at all or after changing all cell refs to double
		result += Double.parseDouble(arr[0]);
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
