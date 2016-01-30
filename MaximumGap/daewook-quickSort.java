public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;

        // Arrays.sort(nums);
        quickSorting(nums, 0, nums.length - 1);
        int max = 0;

        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i+1] - nums[i] > max)
                max = nums[i+1] - nums[i];
        }

        return max;
    }

    public void quickSorting(int[] arr, int startIndex, int finishIndex) {
		if (startIndex < finishIndex) {
			int pvtIdx = (startIndex + finishIndex) / 2;
			int leftIndex = startIndex;
			int rightIndex = finishIndex;
			int tmp = 0;

			while (leftIndex < rightIndex) {
				while (arr[leftIndex] < arr[pvtIdx] && leftIndex < rightIndex) {
					leftIndex++;
				}
				while (arr[rightIndex] >= arr[pvtIdx] && leftIndex < rightIndex) {
					rightIndex--;
				}
				tmp = arr[leftIndex];
				arr[leftIndex] = arr[rightIndex];
				arr[rightIndex] = tmp;
				if (leftIndex == pvtIdx) {
					pvtIdx = rightIndex;
				}
			}

			tmp = arr[leftIndex];
			arr[leftIndex] = arr[pvtIdx];
			arr[pvtIdx] = tmp;
			pvtIdx = rightIndex;

			quickSorting(arr, startIndex, pvtIdx - 1);
			quickSorting(arr, pvtIdx + 1, finishIndex);
		}
	}

}
