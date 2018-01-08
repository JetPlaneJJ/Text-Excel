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
		
		return string + "";
	}
	public String fullCellText()
	{
		
		return string + "";
	}
	
}
