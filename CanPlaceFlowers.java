package Arrays;

public class CanPlaceFlowers {
	public static void main(String[] args) {
		CanPlaceFlowers solution = new CanPlaceFlowers();
		int[] nums = {1,0,0,0,1};
		System.out.println(solution.canPlaceFlowers(nums, 2));
	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i<flowerbed.length; i++) {
        	if(flowerbed[i] == 1) continue;
            int left = i==0 ? 0 : flowerbed[i-1];
            int right = i == flowerbed.length-1 ? 0 : flowerbed[i+1];
            if(left == 0 && right == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
