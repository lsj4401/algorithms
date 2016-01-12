	//Factorial 정의
	//재귀 이용 
	// public static int ftl(int n) {
	//	if (n == 1) return 1;
	//	return n * n (n - 1);
	// }
	public static int ftl(int n){
		int x = 1;
		if(n == 0 || n == 1){
			x = 1;
		}else if(n != 0 || n != 1){
			while(n>1){
				x = x*n;
				n--;
			}
		}
		return x;
	} // 빠진듯 .!?

	//계단 오르는 갯수 구하기
	public static int climbStairs(int n) {

		if(n == 0) return 0;
	
		int x = n/2;
		int r = 0;
				
		if(n%2 == 1){//홀수일때
			int y = 1;
			while(x>-1){
				r = r + ftl(x+y)/(ftl(x)*ftl(y));
				x--;
				y++;
				y++;
				// y += 2; 하셔도 괜찮 
			}
		}else{//짝수일때
			int y = 0;
			while(x>-1){
				r = r + ftl(x+y)/(ftl(x)*ftl(y));
				x--;
				y++;
				y++;
			}
		}
    	return r;
    }
  }
