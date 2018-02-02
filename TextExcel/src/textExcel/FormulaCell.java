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
		return super.getDoubleValue(); //this is only okay for Checkpoint 3
	}

	@Override
	public String abbreviatedCellText()
	{
		String s = getDoubleValue() + "";
		int spacesneeded = (int) (10 - s.length());
		if (s.length() < 10)
		{
			for (int x = 0; x < spacesneeded; x++)
			{
				s += " ";
			}
		}
		else if (s.length() > 10)
		{
			s = s.substring(0, 10);
		}
		return s;
	}

	@Override
	public String fullCellText()
	{
		// TODO Auto-generated method stub
		return string;
	}

}
