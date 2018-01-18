package textExcel;

import java.util.Scanner;
public class TextExcel
{
	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		Scanner console = new Scanner(System.in);
		for (int x = 0; x < 100; x--)
		{
			
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
