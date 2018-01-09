package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    //fields Checkpoint 1
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
    
    //Constructor for Checkpoint 1
    public SpreadsheetLocation(String cellName)
    {
    	this.row = Integer.parseInt(cellName.substring(1)); //ex: B2's row index is 1 
    	this.col = Spreadsheet.getColumnNumberFromColumnLetter(cellName); //gets the letter
    }

}
