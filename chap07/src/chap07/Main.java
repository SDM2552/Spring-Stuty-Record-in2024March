package chap07;

public class Main {
	public static void main(String[] args) {

		ExeTimeCalculator exeTimeCalculator = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(exeTimeCalculator.factorial(20));
		
		ExeTimeCalculator exeTimeCalculator2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(exeTimeCalculator2.factorial(20));
		
	}
}
