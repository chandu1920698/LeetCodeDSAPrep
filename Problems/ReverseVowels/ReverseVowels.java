/*
Class Name  : ReverseVowels
Description : This class is used to reverse the vowels in the string.
Author      : Chandra Sekhar Reddy Muthumula
Date        : Sep 11, 2022
Website Link: https://www.faceprep.in/c/pattern-programs-in-c/

Modification Log: 
Date					Name                                            Description
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added reverseVowels 
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added isVowel 
*/
class ReverseVowels {
	public static void main (String[] args) {
		System.out.println("Original String : 'abcde' -> After  reversing vowels : '" + reverseVowels("abcde") + "'");
		System.out.println("Original String : 'qwerty' -> After  reversing vowels : '" + reverseVowels("qwerty") + "'");
		System.out.println("Original String : 'ace' -> After  reversing vowels : '" + reverseVowels("ace") + "'");
		System.out.println("Original String : 'qazxswedc' -> After  reversing vowels : '" + reverseVowels("qazxswedc") + "'");
		System.out.println("Original String : 'aeiou' -> After  reversing vowels : '" + reverseVowels("aeiou") + "'");
		System.out.println("Original String : 'aaeeiioouu' -> After  reversing vowels : '" + reverseVowels("aaeeiioouu") + "'");
		System.out.println("Original String : 'qwrtyp' -> After  reversing vowels : '" + reverseVowels("qwrtyp") + "'");
		System.out.println("Original String : 'AEIOUaeiou' -> After  reversing vowels : '" + reverseVowels("AEIOUaeiou") + "'");
		System.out.println("Original String : 'a' -> After  reversing vowels : '" + reverseVowels("a") + "'");
		
	}
    public static String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        if (1 <= s.length() && s.length() <= 300000 ) {
            while (start < end) {
                boolean startFlag = false;
                boolean endFlag = false;
                if( !isVowel(ch[start]) ) {
                    start++;
                    continue;
                }
                if (!isVowel(ch[end])) {
                   end--;
                    continue;
                }
                if (ch[end] != ch[start]) {
                    char temp = ch[end];
                    ch[end] = ch[start];
                    ch[start] = temp;
                    start++;end--;
                } else if (ch[end] == ch[start]) { start++;end--;}
            }
        }
             

        return String.copyValueOf(ch); 
    }
    
    public static boolean isVowel (char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ) {
          return true;   
        } 
        return false;
    }
}

/*
OUTPUT:

Original String : 'abcde' -> After  reversing vowels : 'ebcda'
Original String : 'qwerty' -> After  reversing vowels : 'qwerty'
Original String : 'ace' -> After  reversing vowels : 'eca'
Original String : 'qazxswedc' -> After  reversing vowels : 'qezxswadc'
Original String : 'aeiou' -> After  reversing vowels : 'uoiea'
Original String : 'aaeeiioouu' -> After  reversing vowels : 'uuooiieeaa'
Original String : 'qwrtyp' -> After  reversing vowels : 'qwrtyp'
Original String : 'AEIOUaeiou' -> After  reversing vowels : 'uoieaUOIEA'
Original String : 'a' -> After  reversing vowels : 'a'

*/