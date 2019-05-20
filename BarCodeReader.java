import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BarCodeReader 
{
	
	public static void main (String [] args) throws FileNotFoundException 
	{
		FileReader file = new FileReader("src/Food.txt");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(file);
		ArrayList<Food> list = new ArrayList<Food>();
		ArrayList<Food> list2 = new ArrayList<Food>();
		
		while(reader.hasNext()) 
		{
			
			String input = reader.nextLine();
			String[] a = input.split("\\*");

			Food item = new Food(a[0], Integer.parseInt(a[1]), Double.parseDouble(a[2]), a[3]);

			list.add(item);

		}
		
		double total = 0;

		double subtotal = 0;
		double tax = 0;

		FileReader orderFile = new FileReader("src/Order.txt");
		@SuppressWarnings("resource")
		Scanner orderReader = new Scanner(orderFile);

		while(orderReader.hasNext()) {

			int barcode = orderReader.nextInt();
			Food item = new Food(barcode);
			list2.add(item);
	}

		for(int i = 0; i < 14; i++)
		{
			int item = list2.get(i).findOrder(list2.get(i).getBarcode(), list, list2);
			if(item != 0) 
			{
				total += list.get(item).getPrice();
				subtotal += list.get(item).getPrice();
				
				if(list.get(item).getTax()) 
				{
					tax += list.get(item).getPrice()*0.04;
				}
			}
		else 
		{
			System.out.println("no such thing");
		}


		System.out.println(list.get(item));
	}
System.out.println("\nSubtotal: $" + String.format("%5.2f", subtotal));
System.out.println("\nTax: $" + String.format("%4.2f", tax));
System.out.println("\nTotal: $" + String.format("%5.2f", total + tax));

}
}
