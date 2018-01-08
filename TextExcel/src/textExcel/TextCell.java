package textExcel;

//Checkpoint 2 TextCell class
public class TextCell implements Cell
{
	//A TextCell stores string values.
	private String string = "";
	public TextCell()
	{
		super();
	}
	
	public String abbreviatedCellText()
	{
		
		return "          ";
	}
	public String fullCellText()
	{
		
		return "";
	}
	
}
