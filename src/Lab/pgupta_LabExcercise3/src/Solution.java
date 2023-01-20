import java.util.Scanner;

class Solution {
    public static int[] runningSum(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = 0; j <= i; j++){
                sum += nums[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        while (1 >= size || size >= 1000){
            System.out.println("Enter size value between 1 and 1000");
            System.out.print("Enter the size of the array: ");
            size = input.nextInt();
        }

        int [] nums = new int[size];

        for (int i = 0; i <nums.length; i++){
            System.out.printf("Enter the %d elements in array: ", i+1);
            nums[i] = input.nextInt();
        }

        System.arraycopy(runningSum(nums), 0, nums, 0, nums.length);
        System.out.print("The result is: [");
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ",");
        }
        System.out.print("\b]");
    }

}

