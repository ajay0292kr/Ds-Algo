package TwoPointers;

public class ContainerMostWater {
    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        System.out.print(containerMostWater(height));
    }
    public static int containerMostWater(int []height) {
        int left = 0;
        int right = height.length - 1;
        int currArea = 0;
        int result = Integer.MIN_VALUE;
        while (left < right ) {
            currArea = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, currArea);
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
