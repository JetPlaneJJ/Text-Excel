package textExcel;

public class FormulaCell extends RealCell
{
	private String string = "";
	
	public FormulaCell(String input)
	{
		super(input);
		this.string = input;
	
	}

	@Override
	public double getDoubleValue()
	{
		// TODO Auto-generated method stub
		return 0; //this is only okay for Checkpoint 3
	}

	@Override
	public String abbreviatedCellText()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullCellText()
	{
		// TODO Auto-generated method stub
		return string;
	}

}
