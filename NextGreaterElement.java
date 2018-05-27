package String;

public class NextGreaterElement {
	public static void main(String[] args) {
		NextGreaterElement solution = new NextGreaterElement();
		System.out.println(solution.nextGreaterElement(12443322));
	}
	
	public int nextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        
        int index = 0;
        for(int i=arr.length-1; i>0; i--) {
            if(arr[i] > arr[i-1]) {
                index = i;
                break;
            }
        }
        
        if(index == 0) return -1;
        
        char target = arr[index-1];
        
        for(int i=arr.length-1; i>=index; i--) {
            if(arr[i] > target) {
                swap(arr, i, index-1);
                break;
            }
        }
        
        int j = arr.length - 1;
        while(index < j) {
            swap(arr, index++, j--);
        }
        
        long val = Long.parseLong(new String(arr));
        
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
