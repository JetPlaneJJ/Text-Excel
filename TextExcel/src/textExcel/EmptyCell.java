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
