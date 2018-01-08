package textExcel;

//Checkpoint 2 TextCell class
public class TextCell implements Cell
{
	//A TextCell stores string values.
	private String string = "";
	public TextCell(String input)
	{
		this.string = input;
	}

	public String abbreviatedCellText()
	{
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
	public String fullCellText()
	{
		/*if (!(string.indexOf(" ") == -1))
		{
			return string.substring(0, string.indexOf(" "));
		}
		else
		{*/
			return string;
		//}
	}
	
}
