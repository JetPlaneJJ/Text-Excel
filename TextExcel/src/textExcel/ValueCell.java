package textExcel;

public class ValueCell extends RealCell
{
	private String string = "";
	public ValueCell(String input)
	{
		super(input);
		this.string = input;
	}
	
	public String abbreviatedCellText()
	{
		//copied from TextCell method
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
	
	@Override
	public double getDoubleValue()
	{
		return Double.parseDouble(string);
	}

	@Override
	public String fullCellText()
	{
		return string;
	}

}
