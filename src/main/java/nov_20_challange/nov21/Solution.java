package nov_20_challange.nov21;

class Solution {
/*
     count := 0

	pattern := fmt.Sprintf("%d", n)
	nPattern := len(pattern)
	nDigits := len(digits)

	for i := 1; i < nPattern; i++ {
		count += int(math.Pow(float64(nDigits), float64(i)))
	}

	for i := 0; i < nPattern; i++ {
		matched := false
		for _, digit := range digits {
			if digit < pattern[i:i+1] {
				count += int(math.Pow(float64(nDigits), float64(nPattern-1-i)))
			} else if digit == pattern[i:i+1] {
				matched = true
			}
		}

		if !matched {
			return count
		}
	}
	return count + 1*/

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int result = 0;
        String limit = String.format("%d", n);
        int limitLength = limit.length();

        for(int i = 1; i < limitLength; i++){
            result += Math.pow(digits.length,i);
        }

        for (int i = 0; i < limitLength; i++){
            boolean matched = false;
            for (String digitRepresentation : digits) {
                int digit = Integer.parseInt(digitRepresentation);
                int marker = Integer.parseInt(limit.substring(i, i + 1));
                if(digit < marker){
                    result += Math.pow(digits.length, limitLength-i-1);
                } else if (digit == marker){
                    matched = true;
                }
            }
            if(!matched){
                return result;
            }
        }
        return result+1;
    }
}
