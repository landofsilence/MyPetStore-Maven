package per.jxnflzc;

/**
 * @author 河木
 * @version v1.0.0
 */
public class BigS {
	public static void main(String [] args){
		double [] array = {1001, 1004, 1003, 1000, 997, 999, 1004, 1000, 996, 1002, 998, 999};
		double average = average(array);

		System.out.println(bigS(average, array));

	}

	public static double bigS(double average, double [] array){
		double result = 0;

		for(int i = 0; i < array.length; i++){
			result += Math.pow(array[i] - average, 2);
		}
		result = result / array.length;

		return result;
	}

	public static double average(double [] array){
		double result = 0;

		for(int i = 0; i < array.length; i++){
			result += array[i];
		}
		result = result / array.length;

		return result;
	}
}
