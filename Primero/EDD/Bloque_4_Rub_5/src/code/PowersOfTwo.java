package code;

import java.util.ArrayList;
import java.util.List;

public class PowersOfTwo {
	
	public static String twoToThePowerOfN (int exponent) {
		if (exponent == 0)
			return "1";
		List<Integer> digits = new ArrayList();
		digits.add(1);
		int size = 1;
		int temporaryValue;
		int intoAccount = 0;
		for (int i=0; i< exponent; i++) {
			for (int j=0; j<size; j++) {
				temporaryValue = digits.get(j); 
				temporaryValue *= 2;
				temporaryValue += intoAccount;
				intoAccount = 0;
				if (temporaryValue > 9) {
					temporaryValue -= 10;
					intoAccount = 1;
				}
				digits.set(j, temporaryValue);
			}
			if (intoAccount==1) {
				digits.add(intoAccount);
				size++;
				intoAccount = 0;
			}
		}
		String stringOutcome = "";
		for (int i=digits.size()-1; i>=0; i--) {
			stringOutcome += digits.get(i);
		}
		return stringOutcome;
	}
}
