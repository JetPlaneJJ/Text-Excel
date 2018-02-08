package textExcel;

public class FormulaCell extends RealCell
{
	public FormulaCell(String command, Spreadsheet s)
	{
		super(command);
	}

	@Override
	public double getDoubleValue() 
	{
		String noparan = super.fullCellText().substring(super.fullCellText().indexOf("(") + 2, super.fullCellText().indexOf(")")-1); 
		double result = 0.0;
		String[] arr = noparan.split(" "); //ex: AVG, A1-A5 or 1, +, 2
		
		
		//Cell cell s.getCell(s);
		
		
		// if contains SUM or AVG example: C12 = ( AVG A1-A5 ) this goes through the A column from 1 - 5 inclusive
		if (arr[0].equals("SUM") || arr[0].equals("AVG"))
		{
			int countCells = 0;
			//add everything together since AVG also needs the total anyway
			
			
			if (arr[0].equals("AVG"))
			{
				result /= countCells;
			}
			return result;
		}
		
		//has a cell reference?
		for (int a = 0; a < arr.length; a++)
		{
			//if arr[x] is a Cell Name, then change from that cell name to a DOUBLE VALUE within the array
		}
		
		//if no cell references at all or after changing all cell refs to double
		result += Double.parseDouble(arr[0]);
		for (int x = 0; x < arr.length-1; x += 2) 
		{
			double b = Double.parseDouble(arr[x+2]);
			if (arr[x+1].equals("+"))
			{
				result += b;
				/*System.out.println(result + " = result ++");*/
			}
			else if (arr[x+1].equals("*"))
			{
				result *= b;
				/*System.out.println(result + " = result **");*/
			}
			else if (arr[x+1].equals("-"))
			{
				result -= b;
				//System.out.println(result + " = result --");
			}
			else if (arr[x+1].equals("/"))
			{
				result /= b;
				//System.out.println(result + " = result //");
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

}
