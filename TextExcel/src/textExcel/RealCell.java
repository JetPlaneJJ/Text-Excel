package textExcel;

public abstract class RealCell implements Cell
{
	private String string = ""; //stores command
	
	public RealCell(String input)
	{
		this.string = input;
	}
	
	public String abbreviatedCellText()
	{
		int spacesneeded = 10 - this.string.length();
		String result = this.string;
		if (result.length() < 10)
		{
			for (int x = 0; x < spacesneeded; x++)
			{
				result += " ";
			}
		}
		else if (result.length() > 10)
		{
			result = result.substring(0, 10);
		}
		return result;
	}

	public String fullCellText()
	{
		return this.string;
	}
	
	//It also needs a getDoubleValue method that returns the calculated value of the cell.
	public double getDoubleValue()
	{
		double d = Double.parseDouble(this.string);
		return d;
	}

}
