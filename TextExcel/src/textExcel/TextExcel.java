package textExcel;

import java.util.Scanner;
public class TextExcel
{
	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		for (int x = 0; x < 100; x--)
		{
			Scanner console = new Scanner(System.in);
			String input = console.nextLine();
			if (!input.equals("quit"))
			{
				System.out.println(spreadsheet.processCommand(input));
			}
			else
			{
				System.exit(0);
			}
		}
			
		
	}
}
