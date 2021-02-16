package nov_20_challange.nov22;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    private final String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> result = Arrays.stream(words).map(this::getWord).collect(Collectors.toSet());
        return result.size();
    }

    private String getLetter(char alphabetLetter){
        int OFFSET = 'a';
        return MORSE[((int) alphabetLetter) - OFFSET];
    }

    private String getWord(String alphabeticalWord){
        StringBuilder result = new StringBuilder();
        char[] chars = alphabeticalWord.toCharArray();
        for (char aChar : chars) {
            result.append(getLetter(aChar));
        }
        return result.toString();
    }
}
