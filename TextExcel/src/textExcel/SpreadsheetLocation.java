package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
    //fields Checkpoint 1
	private String cellName;
	private int row;
	private String col;
	
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
        // TODO: Fill this out with your own code
    	this.cellName = cellName;
    	this.row = Integer.parseInt(this.cellName.substring(1)) + 1;
    	//this.col = ?????
    			//how do I convert letters to numbers?
    }

}
