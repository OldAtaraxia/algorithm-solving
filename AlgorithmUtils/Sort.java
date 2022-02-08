package AlgorithmUtils;

public class Sort {

    /*
    * 细节:
    * 1. 时间复杂度为O(nlogn)
    * 2. 使用do-while循环, 防止nums[i] == nums[j] == x 时死循环. 确保指针移动
    * 3. 递归处理的子区间为[left, j]与[j + 1, right], 停下来时i == j + 1, 满足<=x的是[l,j]
    * */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left - 1, j = right + 1, x = nums[left];
        while (i < j) {
            do i++; while(nums[i] < x); // 不带等号, 否则若x为数组max则i不会停下来
            do j--; while (nums[j] > x);
            // 交换之前判断i < j
            if(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int k = 0, i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        while(i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while(j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left, j = 0; i <= right; i++, j++) {
            nums[i] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7, 8, 9, 3, 4, 2, 0};
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
