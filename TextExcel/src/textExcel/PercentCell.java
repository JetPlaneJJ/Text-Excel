package textExcel;

public class PercentCell extends RealCell
{
	private String stringwpercent = ""; //original input
	private String decimal = ""; //String w no percent
	private double resultvalue = 0.0; //the double value, divided by 100.0, result
	private String resultstring = ""; //result but string

	public PercentCell(String input)
	{
		super(input);
		this.stringwpercent = input; //ex: 5.6%
		this.decimal = input.substring(0, input.length()-1); //without the percent ex: 5.6
		this.resultvalue = Double.parseDouble(this.decimal)/100.0; //without the percent and turned into double and / 100.0
		this.resultstring = resultvalue + "";
	}

	//When the full spreadsheet prints, the value is always printed in percent form, and the decimal portion is truncated, not rounded.
	public String abbreviatedCellText()
	{
		//copied from TextCell method
		String r = decimal.substring(0, decimal.indexOf(".")) + "%"; //ex: 89.55681% turns into 89%
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
		/*return decimal.substring(0,1) + "%"; //ex: 9.55681% turns into 9%
		 */ 
		return resultstring;
	}

	@Override
	public double getDoubleValue()
	{
		// TODO Auto-generated method stub
		return resultvalue;
	}

}
