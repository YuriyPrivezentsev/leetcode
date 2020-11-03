package nov_20_challange.nov03;

class Solution {
    //TODO: simplify
    public int maxPower(String s) {
        if(s.isBlank()){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int power = 1, result = 1;
        char[] chars = s.toCharArray();
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if(prev == current){
                power++;
            } else {
                prev = current;
                if(result < power){
                    result = power;
                }
                power = 1;
            }

        }
        //noinspection ManualMinMaxCalculation
        if(result < power){
            return power;
        }
        return result;
    }
}
