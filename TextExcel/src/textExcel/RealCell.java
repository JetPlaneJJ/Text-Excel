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

	public double getDoubleValue()
	{
		if (this.string.length() > 0)
		{
			double d = Double.parseDouble(this.string);
			return d;
		}
		return 0.0;
	}

}
