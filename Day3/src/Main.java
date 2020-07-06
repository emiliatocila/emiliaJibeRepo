import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static ArrayList<String> stringPalindromes(ArrayList<String> words) {
        ArrayList<String> palindromes = new ArrayList<String>();

        forEachLoop:
        for(String palindrome : words) {
            int palindromeLength = palindrome.length();
            for(int i = 0; i < palindromeLength/2; i++) {
                if(palindrome.charAt(i) != palindrome.charAt(palindromeLength - i - 1)) {
                    continue forEachLoop;
                }
            }
                palindromes.add(palindrome);
        }

        return palindromes;
    }

    public static ArrayList<Integer> incrementNumber(ArrayList<Integer> number) {
        ArrayList<Integer> incrementedNumber = new ArrayList<Integer>();
        Stack<Integer> tempNumber = new Stack<Integer>();
        int nrOfDigits = number.size();
        int increment = 1;
        int currentDigit;

        for(int i = nrOfDigits - 1; i >= 0; i--) {
            currentDigit = number.get(i);
            if(increment == 1) {
                if(currentDigit != 9) {
                    increment = 0;
                    currentDigit += 1;
                    tempNumber.add(currentDigit);
                }
                else {
                    increment = 1;
                    currentDigit = 0;
                    tempNumber.add(currentDigit);
                    if(i == 0) {
                        tempNumber.add(1);
                    }
                }
            }
            else {
                tempNumber.add(currentDigit);
            }
        }
        while(!tempNumber.isEmpty()) {
            int digit = tempNumber.pop();
            incrementedNumber.add(digit);
        }

        return incrementedNumber;
    }

    public static int []rotateMatrix(int []matrix, int rowsCols) {
        int size = matrix.length;
        int[] rotatedMatrix = new int[size];
        int index = 0;

        for(int i = rowsCols; i > 0; i--) {
            for(int j = 0; j < rowsCols * rowsCols; j = j + rowsCols) {
                rotatedMatrix[index++] = matrix[size - i - j];
            }
        }

        return rotatedMatrix;
    }

    public static boolean isAnagram(String string1, String string2) {
        if(string1.length() != string2.length())
            return false;
        if(string1.equals(string2))
            return false;
        char []s1 = string1.toCharArray();
        char []s2 = string2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(!Arrays.equals(s1, s2))
            return false;
        return true;
    }

    public static ArrayList<ArrayList<Integer>> getAnagrams(ArrayList<String> strings) {
        ArrayList<ArrayList<Integer>> anagrams = new ArrayList<ArrayList<Integer>>();


        for(int i = 0; i < strings.size(); i++) {
            for(int j = i + 1; j < strings.size(); j++) {
                if(isAnagram(strings.get(i), strings.get(j))) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(j);
                    anagrams.add(pair);
                }
            }
        }
        return anagrams;
    }

    public static void main(String args[]) {

        System.out.println("~Data structures~");

        System.out.println("Palindromes:");
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("aaa", "a", "aba", "abcdcba", "abccba", "abcddba", "abcabc", "madam", "aaaa"));
        ArrayList<String> palindromes = stringPalindromes(words);
        for(String palindrome : palindromes) {
            System.out.println(palindrome);
        }

        System.out.println("Increment numbers:");
        ArrayList<Integer> number1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> number2 = new ArrayList<Integer>(Arrays.asList(1, 9));
        ArrayList<Integer> number3 = new ArrayList<Integer>(Arrays.asList(9, 9));
        ArrayList<Integer> number4 = new ArrayList<Integer>(Arrays.asList(1, 2, 0));
        ArrayList<Integer> number5 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2));
        ArrayList<Integer> number6 = new ArrayList<Integer>(Arrays.asList(2, 3, 9));
        ArrayList<Integer> number7 = new ArrayList<Integer>(Arrays.asList(1, 9, 9));
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>(Arrays.asList(number1, number2, number3, number4, number5, number6, number7));

        ArrayList<ArrayList<Integer>> outputs = new ArrayList<ArrayList<Integer>>();
        for(ArrayList number : numbers) {
            ArrayList<Integer> output = incrementNumber(number);
            outputs.add(output);
        }
        for(ArrayList output : outputs) {
            System.out.println(output);
        }

        System.out.println("Rotate matrix:");
        int []matrix = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int []rotatedMatrix = rotateMatrix(matrix, 3);
        for(int i = 0; i < rotatedMatrix.length; i++) {
            System.out.print(rotatedMatrix[i] + " ");
            if((i + 1) % 3 == 0) {
                System.out.println();
            }
        }

        System.out.println("Anagrams:");
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("cat", "dog", "god", "tca"));
        ArrayList<ArrayList<Integer>> anagrams = getAnagrams(strings);
        System.out.println(anagrams);

    }

}
