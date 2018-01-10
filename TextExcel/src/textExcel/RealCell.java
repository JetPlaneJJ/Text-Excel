package textExcel;

public class RealCell implements Cell
{
	private String string = "";
	
	public RealCell(String input)
	{
		this.string = input;
	}
	
	@Override
	public String abbreviatedCellText()
	{
		//copied from TextCell method
		int spacesneeded = 10 - string.length();
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
	public String fullCellText()
	{
		return string;
	}

}
