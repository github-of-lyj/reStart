package TwoPoint;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left != right){
            if (numbers[left] + numbers[right] == target)
                break;
            if (numbers[left] + numbers[right] < target)
                left++;
            if (numbers[left] + numbers[right] > target)
                right--;
        }
        int[] result = {left+1,right+1};
        return result;
    }
}
