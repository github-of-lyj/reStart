package TwoPoint;

public class Valid_Palindrome_II {
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left <= right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else
                return false;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean mark = false;
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return isPalindrome(s.substring(left, right)) || isPalindrome(s.substring(left + 1, right + 1));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
