package vtiger.Practice;

public class GenericMethodPractice {
public static void main(String[] args) {
 int summation=add(10,20);//caller function
	System.out.println(summation);
}
public static int add(int a,int b)  //called function
{
	int sum=a+b;
	return sum;
}
}
