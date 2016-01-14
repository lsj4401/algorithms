public static void main(String[] args) {		
	// 2147483648 (10000000000000000000000000000000)
	countDigitOne(2147483647);
}

public static int countDigitOne(int n) {
	
	System.out.println("input : " + n);
    int res = 0;
    
    while (n>0) {
        if (masking(n,1)%2 == 1) {
            res++;
        }
        
        n = n>>1;
        System.out.println("next input : " + n);
    }
    
    System.out.println("final result : " + res);
    
    return res;
}

private static int masking (int input, int mask) {
	int res = input&mask;
	
	System.out.println("masking result : " + res);
	
    return input&mask;
}