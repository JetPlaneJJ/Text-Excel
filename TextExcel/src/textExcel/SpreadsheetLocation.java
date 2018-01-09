package textExcel;
public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
	
	@Override
    public int getRow()
    {
        return this.row;
    }
    public int getCol()
    {
        return this.col;
    }
    public SpreadsheetLocation(String cellName)
    {
    	this.row = Integer.parseInt(cellName.substring(1)) -1; //ex: B2's row index is 1 
    	this.col = Spreadsheet.getColumnNumberFromColumnLetter(cellName); //gets the letter
    }

}
