package textExcel;

public class FormulaCell extends RealCell
{
	public FormulaCell(String input) //ex: A1 = ( 1 + 3 + 2 * 6 ) assume no cell ref for Checkpoint 1 Part B
	{
		super(input);
	}

	@Override
	public double getDoubleValue() 
	{
		double result = 0.0;
		String noparan = super.fullCellText().substring(super.fullCellText().indexOf("(") + 2, super.fullCellText().indexOf(")")-1); 
		String[] arr = noparan.split(" "); //ex: {1, +, 3, +, 2, *, 6} even numbers are # values, odd = operation
		result += Double.parseDouble(arr[0]);
		for (int x = 0; x < arr.length/2; x+=2) 
		{
			double b = Double.parseDouble(arr[x + 2]);
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

}
