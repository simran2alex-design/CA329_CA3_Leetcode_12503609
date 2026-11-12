class Solution {
    public int missingNumber(int[] nums) {
        for (int number = 0; number <= nums.length; number++) {
            boolean found = false;
            for (int value : nums) {
                if (value == number) {
                    found = true;
                    break; }
            }
            if (!found) {
                return number;
            }
        }
        return 0;
    }
}
