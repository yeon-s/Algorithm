package practice;
public class RecursionTest_Sol {
	public static void main(String[] args) {
		System.out.println("1번 답---------------------");
//		1. 1부터 9까지 출력하기
		pr(0);
		System.out.println("2번 답---------------------");
//		2. 1부터 10까지의 합을 출력하는 재귀함수를 만드시오?
		doSum(0,10);
		System.out.println("3번 답---------------------");
//		3. 팩토리얼
		int result = fact(0);
		System.out.println(result);	
		System.out.println("4번 답---------------------");
//		4. 자연수를 넣어 그 각자리의 수의 합을 반환하는 재귀함수를 만들어라
		int sum = digitSum(12356,0);
		System.out.println("sum:" + sum);
		System.out.println("5번 답---------------------");
//		5. 문자열을 전달받아 그문자사이에 ,를 결합하여 반환하는 재귀함수를 만들어라
		String s = doStringComma("korea","");
//		k,o,r,e,a
		System.out.println(s);
		System.out.println("6번 답---------------------");
//		6. 피보나치수열 10개를 출력하라
		for(int i = 1; i <= 10;i++) {
			System.out.println(fibo(i));
		}
		System.out.println("7번 답---------------------");
//		7. 2진수 3자리를 구성할 수 있는 재귀함수를 만들어라
		doMakeBinary(3,"");
		System.out.println("끝---------------------");
	}
	public static void doMakeBinary(int digit, String result) {
		if(digit == 0) {
			System.out.println(result);
			return;
		}
		digit--;
		doMakeBinary(digit,result+"0");
		doMakeBinary(digit,result+"1");
	}
	
	public static int fibo(int num) {
		if(num == 1) {
			return 1;
		}
		if(num == 2) {
			return 1;
		}
		
		return fibo(num-1) + fibo(num-2);
	}
	public static String doStringComma(String s, String result) {
		if(s.length() == 0) {
			return result.substring(0, result.length()-1);
		}
		String temp = s.substring(1);
		result += s.charAt(0) + ",";
		return doStringComma(temp, result);
	}
	
	public static int digitSum(int data, int sum) {
		if(data == 0) {
			return sum;
		}
		int mok = data / 10;
		int nam = data % 10;
		sum += nam;
		return digitSum(mok,sum);
	}
	
	
	static int fact(int num) {
		if(num == 0) {return 1;}
		if(num == 1) {return 1;}
		return num * fact(--num);
	}
	public static void doSum(int sum,int num) {
		if(num == 0) {
			System.out.println(sum);
			return;
		}
		sum += num;
		num--;
		doSum(sum,num);
	}
//	 숫자 출력예제
	public static void pr(int num) {
		if(num > 9) {return;}
		
		System.out.println("num" + num);
		num++;
		pr(num);
		
	}

}
