package textExcel;

public class ValueCell extends RealCell
{
	private double value = 0.0;
	private String string = "";
	public ValueCell(String input)
	{
		super(input);
		input = this.string;
		this.value = Double.parseDouble(input);
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
		return value;
	}

	@Override
	public String fullCellText()
	{
		// TODO Auto-generated method stub
		return string;
	}

}
