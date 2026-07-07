class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        leftProd[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            leftProd[i] = leftProd[i + 1] * nums[i + 1];
        }

        int[] rightProd = new int[nums.length];
        rightProd[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            rightProd[i] = rightProd[i - 1] * nums[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProd[i] * rightProd[i];
        }

        return res;
    }
}  
