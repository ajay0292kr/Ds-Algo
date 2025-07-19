package Amazon;

public class ContainerWater {
    public static int containerMostWater(int[] height) {
        int maxWeight = 0;
        int l = 0, r = height.length - 1;
        int result = 0;
        while (l < r) {
            maxWeight = Math.min(height[l], height[r])*(r - l);
            result = Math.max(maxWeight, result);
            if (height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.print(containerMostWater(height));
    }
}
