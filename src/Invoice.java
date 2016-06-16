import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class Invoice {
	public static void main(String[] args){
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		
		Scanner in = new Scanner(System.in);
		
		double input;
		double[] inputs = new double[100];
		int i = 0;
		double sum = 0;
		double tax = -1;
		
		while(tax==-1){
			try{
				tax = getTax();
			}catch(Exception e){
				System.out.println("Error, enter valid double");
			}
		}
		
		
		while(1==1){
			System.out.println("Enter Item Price: ");
			input = in.nextDouble();
			if(input == 0)break;
			inputs[i] = input;
			i++;
			sum += input;
		}
		
		for(int j = 0; j < i; j++){
			System.out.println("Price #" + (j+1) + " : " + nf.format(inputs[j]));
		}
		double taxTotal = sum*tax;
		System.out.println("Subtotal: " + nf.format(sum));
		System.out.println("Tax: " + nf.format(taxTotal));
		System.out.println("Grand Total: " + nf.format(sum+taxTotal));
	}
	
	public static double getTax() throws Exception{
		System.out.println("Enter tax rate: ");
		Scanner in = new Scanner(System.in);
		return in.nextDouble();
	}
}
