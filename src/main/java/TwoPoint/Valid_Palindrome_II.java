package TwoPoint;

public class Valid_Palindrome_II {
    /*
     * @author 林英杰
     * @since JDK 版本 1.8++
     * @Method validPalindrome(String s):删除前判断是否为回文字符串  isPalindrome(String s)：删除后判断是否是回文字符串
     * @param
     * @return
     * @Address
     * @TitleName
     */
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
        //双指针
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            //相等情况 左指针++ 右指针--
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                //不相等情况 剔除疑似障碍元素：考虑到障碍元素下标可能为 left+1 或为 right-1，因此都需要判断，若有一方为 True，则最终结果为 True
                return isPalindrome(s.substring(left, right)) || isPalindrome(s.substring(left + 1, right + 1));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
}

