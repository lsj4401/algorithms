import java.util.Scanner;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("input ExcelSheet : ");
		String s = in.next();
		System.out.println(titleToNumber(s));
	}
	
    public static int titleToNumber(String s) {
        
        int sum = 0;
        int len = s.length() -1;
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        
        for(int i = len ; i >= 0 ; i --){
        	sum += Math.pow(26,len-i)*(alpha.indexOf(s.substring(i,i+1))+1);
        }
        
        return sum;
        
    }

}

