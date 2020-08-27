/**		
 * 		This program will calculate the amount of income, the tax, investment and other expenses  
 * 		that the Pearson family pays in a years time period.
 * 		This program prompts for data by the user for the particular category and 
 * 		will produce a report with information as described in each section.
 * 
 * 		Author : Smit Bhavsar
 * 		Date : October 11, 2017
 * 		Course : ICS3U ~~Ms.Jansen
 * 
 */
import java.util.Scanner;

public class FamilyBudget {

	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);

		System.out.println("------------Income------------");
		System.out.print ("Enter Papa salary : $");
		double papaSal = input.nextDouble();
		System.out.print ("Enter amount of house insurance sold by mama : ");
		double houInsMama = input.nextDouble();
		System.out.print("Enter the amount of car insurance sold by mama : ");
		double carInsMama = input.nextDouble();
		System.out.print("Enter Juniors Hourly Rate : ");
		double junHourPay = input.nextDouble();
		System.out.print("Enter the number of hours Junior works/week : ");
		int junWeekWork = input.nextInt();
		System.out.print("Enter the number of hours Junior works/year : ");		
		int junYearWork = input.nextInt();

		// to calculate mama's salary, you calculate the amount of commission for 11.5% of the house insurance she sold and add it with 9.7% of the car insurance that she sold
		double mamaSal = (houInsMama * 0.115) + (carInsMama * 0.097) ;
		/* to calculate junior's salary, you multiply his hourly pay with the amount of hours he works weekly 
		 * and then multiply that by the number of weeks junior works in a year to find out his yearly salary */
		double junSal = junHourPay * junWeekWork * junYearWork ;
		// to calculate the entire family's salary, you just add up all 3 of their salaries
		double famSal = papaSal + mamaSal + junSal;
		// to calculate the family's average monthly salary, divide their yearly salary by 12 because there are 12 months in a year
		double avgMonSal = famSal / 12;
		System.out.println("Papa Income : $"+papaSal);
		System.out.println("Mama Income : $"+mamaSal); 
		System.out.println("Junior Income : $"+junSal); 
		System.out.println("Total Family Income : $"+famSal);
		System.out.println("Average Monthly Income : $"+avgMonSal); 

		// to calculate papa's tax, you take 32% of his salary (so multiply his salary by 0.32).
		double papaTax = papaSal * 0.32 ;
		// to calculate mama's tax, you take 23% of her salary (so multiply her salary by 0.23).
		double mamaTax = mamaSal * 0.23 ;
		// to calculate junior's tax, you take 14% of his salary (so multiply his salary by 0.14).
		double junTax = junSal * 0.14 ;
		/* to calculate the overall tax rate, you add up all of the family's taxes, divide it by their total salary 
		 * and then multiply it by 100 to get a percentage as an answer	 */
		double ovrTaxRate = (papaTax + mamaTax + junTax) / famSal * 100;
		// to calculate the family's net income, subtract each salary by the amount of tax they've paid
		double netInc = (papaSal - papaTax) + (mamaSal - mamaTax) + (junSal - junTax);
		// to calculate the average monthly net income, you divide the yearly net income by 12
		double monNetInc = netInc / 12;
		System.out.println("\n------------TAX------------");
		System.out.println("Tax paid by Papa : $"+papaTax); 
		System.out.println("Tax paid by Mama : $"+mamaTax); 
		System.out.println("Tax paid by Junior : $"+junTax); 
		System.out.println("Overall tax rate "+ovrTaxRate+"%"); 
		System.out.println("Total net income : $"+netInc); 
		System.out.println("Average monthly net income : $"+monNetInc);
		
		// since the family only invests 9% of their total net income, you multiply the net income by 0.09 to get the amount they're willing to invest
		double salInvs = netInc * 0.09 ;
		System.out.println(" ");
		System.out.println("------------Investment------------");
		System.out.print("Enter the price for one share of stock : $");
		double stockShare = input.nextDouble();
		// the number of stocks the family owns is calculated by dividing the amount they're willing to invest by the cost of stock per share
		double numOfStock = salInvs / stockShare;
		// since you can't have a decimal number of stocks, it must be rounded to nearest whole number
		numOfStock = Math.floor(numOfStock);
		System.out.println("$"+salInvs+" is invested on "+numOfStock+" shares of stock");

		System.out.println("\n------------Electricity------------");
		System.out.print("How many units of electricity used over the year? : ");
		double elecUnit = input.nextDouble();
		System.out.print("How many months is the discount for? : ");
		int eleDisc = input.nextInt();
		// the amount of units of electricity is multiplied by 0.18 because every unit of electricity used costs 18 cents
		double totEleUnit = (elecUnit * 0.18);
		/* the total discount is calculated by dividing the total electrical unit cost by 12 to get the cost per month,
		 * then multiply it by 0.10 because the company offers 10% off for a certain amount of month */
		double totEleDisc = totEleUnit / 12 *eleDisc* 0.1;
		// the total electricity utility tax is 2% of the cost of the total electricity unit
		double eleTax = totEleUnit * 0.02 ;
		/* to calculate the total electricity cost, you would add up the the total electricity cost per unit with the utility tax,
		 * and subtract it by the electricity */ 
		double totEleBill = totEleUnit + eleTax - totEleDisc;
		System.out.println("Total electricity bill : $"+totEleBill); 

		System.out.println("\n------------Phone Bill------------");
		System.out.print("Number of minutes spent over the year : ");
		int minYear = input.nextInt();
		System.out.print("Number of minutes in a block of time : ");
		int minBlock = input.nextInt();
		System.out.print("Cost for each block of time : ");
		double costBlock = input.nextDouble();
		// this is done to round the amount of minutes the family spends over the year to the nearest hundred
		double roundBlock = minYear ;
		roundBlock = Math.ceil(roundBlock /minBlock) ;   
		roundBlock = roundBlock * minBlock ;
		// the minutes per year that was previously rounded is divided by the amount minutes in a block to get a specific unit ...
		double totBlock = roundBlock / minBlock;
		// and using that unit, you can calculate the total price by multiplying the price/block with the cost/block
		double phoBill = totBlock * costBlock ;
		System.out.println("Cost of phone bill : $"+phoBill); 

		System.out.println("\n------------GAS------------");
		System.out.print("Enter distance (km) traveled over the year : ");
		double disTravYear = input.nextDouble();
		System.out.print("Enter vehicles efficieny (km/L) : ");
		double fuelEff = input.nextDouble();
		System.out.print("Enter average gas price for the year ($/L) : $");
		double gasPri = input.nextDouble();
		// to calculate the total price of gas the family spends throughout the entire year, you divide the distance traveled by fuel efficiency to
		// get km/L and then, this is multiplied by the gas price because is the price is for km/L, and that gets the total spent of gas 
		double totGas = (disTravYear / fuelEff * gasPri);
		System.out.print("Total cost of gasoline for the year : $"+totGas);

		System.out.println("\n\n------------Mortagage------------");
		System.out.print("Enter amount of each bi-weekly mortgage payment : $");
		double biWeekMort = input.nextDouble();
		// after getting how much the family pays for mortgage, it is divided by 26 because it is paid every other week, so 56/2=26
		double totMort = biWeekMort * 26;
		System.out.println("Total mortagage payments for the year :  $"+totMort); 

		// calculating money leftover will allow the program to more fluently calculate the rest of the expenses and the amount of savings
		double monLef = netInc - salInvs - totEleBill - phoBill - totGas - totMort;
		// to calculate the money used for groceries, the family uses 60% of the money leftover and use it towards groceries
		double groc = monLef * 0.6;
		// the family spends 20% of their money leftover on entertainment ...
		double ent = monLef * 0.2;
		// and another 20% of their money leftover goes straight into their savings
		double save = monLef * 0.2;		
		System.out.println("\n------------Other Expenses------------");
		System.out.println("Amount used on groceries : $"+groc); 
		System.out.println("Amount used on entertainment : $"+ent);
		System.out.println("Amount of Cash Savings : $"+save); 

		// gross income is equivalent to the family's total salary before taxes
		double groInc = famSal;
		// total tax that the family pays is equal to all of their taxes being added up
		double totTaxPaid = papaTax + mamaTax + junTax ;
		// total expenses is adding up all the things that the family spends on throughout the year 
		double totExp = totEleBill + phoBill + totGas + totMort + groc + ent;
		// the family's total reserve is equivalent to their savings plus the amount they've invested in stock market
		double totRes = save + salInvs;
		System.out.println("\n------------ Summary------------");
		System.out.println("Total household gross income : $"+groInc);
		System.out.println("Total tax paid : $"+totTaxPaid);
		System.out.println("Total expenses : $"+totExp);
		System.out.println("Total reserve : $"+totRes);	
	}

}