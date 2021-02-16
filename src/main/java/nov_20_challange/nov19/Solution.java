package nov_20_challange.nov19;

import java.util.Arrays;

class Solution {
    public String decodeString(String s) {

        char[] chars = s.toCharArray();

        return substring(chars);

    }

    private String substring(char[] chars){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(Character.isDigit(aChar)) {
                StringBuilder repetitions = new StringBuilder();
                while (Character.isDigit(aChar)){
                    repetitions.append(aChar);
                    i++;
                    aChar = chars[i];
                }
                int repetitionsNumber = Integer.parseInt(repetitions.toString());
                int brackets = 1, startIndex = i+1, endIndex = 0;
                for (i = startIndex; i < chars.length; i++){
                    char subChar = chars[i];
                    if(subChar == '['){
                        brackets++;
                    } else if (subChar == ']'){
                        brackets--;
                    }

                    if (brackets == 0){
                        endIndex = i;
                        break;
                    }
                }
                String substring = substring(Arrays.copyOfRange(chars, startIndex, endIndex));
                result.append(substring.repeat(Math.max(0, repetitionsNumber)));
            } else {
                result.append(aChar);
            }
        }
        return result.toString();
    }
}
