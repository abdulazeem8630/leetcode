class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        java.util.List<Integer> arr1 = new java.util.ArrayList<>();
        java.util.List<Integer> arr2 = new java.util.ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);
            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] result = new int[n];
        int index = 0;
        for (int num : arr1) {
            result[index++] = num;
        }
        for (int num : arr2) {
            result[index++] = num;
        }
        return result;
    }
}
