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
		
		if (string.length() < 10)
		{
			for (int x = 0; x < spacesneeded; x++)
			{
				string += " ";
			}
		}
		else if (string.length() > 10)
		{
			string = string.substring(0, 10);
		}
		
		return string;
	}
	public String fullCellText()
	{
		
		return string + "";
	}
	
}
