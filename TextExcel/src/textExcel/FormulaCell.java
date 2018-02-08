package textExcel;

public class FormulaCell extends RealCell
{
	/*o	The Spreadsheet can pass a pointer to itself as a parameter you add to the FormulaCell constructor.  (Remember to use the keyword “this” discussed in class.)
	 * */
	public FormulaCell(String input)
	{
		super(input);
	}

	@Override
	public double getDoubleValue() 
	{
		String noparan = super.fullCellText().substring(super.fullCellText().indexOf("(") + 2, super.fullCellText().indexOf(")")-1); 
		
		// if contains SUM or AVG example: C12 = ( AVG A1-A5 )
		if (noparan.contains("SUM") || noparan.contains("AVG"))
		{
			double result = 0.0;
			if (noparan.contains("SUM"))
			{
				//get the A1 --> A5 values int columnofthefirstcell = noparan.substring(4,5);
				
			}
			else if (noparan.contains("SUM"))
			{
				
			}
			return result;
		}
		//has a cell reference?
		
		
		//if no cell references at all
		String[] arr = noparan.split(" "); 
		double result = Double.parseDouble(arr[0]);
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
