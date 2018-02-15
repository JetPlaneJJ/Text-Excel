package textExcel;

public class EmptyCell implements Cell
{
	public EmptyCell()
	{
		super();
		
	}
	public String abbreviatedCellText()
	{
		
		return "          ";
		// text for spreadsheet cell display, must be exactly length 10
	}
	public String fullCellText()
	{
		
		return "          "; 	
	}
	@Override
	public double getDoubleValue()
	{
		return 0.0;
	}
	
}
