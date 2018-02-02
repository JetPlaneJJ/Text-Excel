package textExcel;

public abstract class RealCell implements Cell
{
	private String string = "";
	
	public RealCell(String input)
	{
		this.string = input;
	}
	
	public abstract String abbreviatedCellText();

	public abstract String fullCellText();
	
	//It also needs a getDoubleValue method that returns the calculated value of the cell.
	public double getDoubleValue()
	{
		double d = Double.parseDouble(this.string);
		return d;
	}

}
