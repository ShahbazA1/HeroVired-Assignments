import java.util.Arrays;

public class MoveZeros {
    public void moveZeros(int[] nums) {
        int nonZeroPointer = 0; // Initialize the non-zero pointer

        // Task 2: Iterate through the array using the `i` pointer
        for (int i = 0; i < nums.length; i++) {
            // Task 3: Check if the element at index `i` is non-zero
            if (nums[i] != 0) {
                // Task 4: If the element is non-zero, swap it with the element at the non-zero pointer and increment the non-zero pointer
                int temp = nums[nonZeroPointer];
                nums[nonZeroPointer] = nums[i];
                nums[i] = temp;
                nonZeroPointer++;
            }
        }

        // Task 5: Fill the remaining elements from the non-zero pointer to the end of the array with zeros
        for (int i = nonZeroPointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Original Array: " + Arrays.toString(nums));
        solution.moveZeros(nums);

        // Task 6: Print the Modified Array
        System.out.println("Modified Array: " + Arrays.toString(nums));
    }
}
