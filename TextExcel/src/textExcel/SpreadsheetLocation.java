package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    //fields Checkpoint 1
	private String cellName;
	private int row;
	private int col;
	
	@Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return this.row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return 0; //FIX THIS
    }
    
    //Constructor for Checkpoint 1
    public SpreadsheetLocation(String cellName)
    {
    	this.cellName = cellName;
    	this.row = Integer.parseInt(this.cellName.substring(1)) - 1; //ex: B2's row index is 1 
    	this.col = Spreadsheet.getColumnNumberFromColumnLetter(cellName); //gets the letter
    			//TODO: how do I convert letters to numbers?
    }

}
