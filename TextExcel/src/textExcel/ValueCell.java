package textExcel;

public class ValueCell extends RealCell
{
	//don't need to store strings!
	public ValueCell(String input)
	{
		super(input);
	}
	
	public String abbreviatedCellText()
	{
		return super.abbreviatedCellText();
	}
	
	@Override
	public double getDoubleValue()
	{
		return super.getDoubleValue();
	}

	@Override
	public String fullCellText()
	{
		return super.fullCellText();
	}

}
