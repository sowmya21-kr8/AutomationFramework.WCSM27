package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider="getData")
	public void addToCart(String name,int price,int qty,String color,boolean isAvailable)
	{
		System.out.println("-------"+"-"+price+"-"+qty+"-"+color+"-"+isAvailable+"-------");
	}
	
	@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[2][5];//2 data sets of 5 details inside
	data[0][0]="Samsung";
	data[0][1]=1000;
	data[0][2]=12;
	data[0][3]="Black";
	data[0][4]=true;
	
	data[1][0]="iphone";
	data[1][1]=12000;
	data[1][2]=5;
	data[1][3]="white";
	data[1][4]=false;
	
	return data;
}
	
	@Test(dataProvider="getData1")
	public void addToCart(String name,int price,int qty,String color)
	{
		System.out.println("-------"+"-"+price+"-"+qty+"-"+color+"-"+"-------");
	}
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] data=new Object[3][4];//2 data sets of 5 details inside
		data[0][0]="Hp";
		data[0][1]=40000;
		data[0][2]=2;
		data[0][3]="Black";
		
		
		data[1][0]="Dell";
		data[1][1]=38000;
		data[1][2]=5;
		data[1][3]="silver";
		
		data[2][0]="Lenovo";
		data[2][1]=35000;
		data[2][2]=3;
		data[2][3]="silver";
		
		
		return data;
	}
	

}
