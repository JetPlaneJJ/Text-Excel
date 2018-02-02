package textExcel;

public class PercentCell extends RealCell
{
	public PercentCell(String input)
	{
		super(input);
	}

	//When the full spreadsheet prints, the value is always printed in percent form, and the decimal portion is truncated, not rounded.
	public String abbreviatedCellText()
	{
		//copied from TextCell method
		String original = fullCellText();
		String r = original.substring(0, original.indexOf(".")) + "%"; //ex: 89.55681% turns into 89%
		int spacesneeded = 10 - r.length();
		if (r.length() < 10)
		{
			for (int x = 0; x < spacesneeded; x++)
			{
				r += " ";
			}
		}
		else if (r.length() > 10)
		{
			r = r.substring(0, 10);
		}
		return r;
	}
	
	@Override
	public String fullCellText()
	{
		//returns the percent in decimal form
		String x = super.fullCellText().substring(0, super.fullCellText().length()-1);
		return Double.parseDouble(x)/100 + "";
	}

	@Override
	public double getDoubleValue()
	{
		return super.getDoubleValue();
	}

}
