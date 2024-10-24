package sdet;

public class LargestElement {
    public static void main(String args[]) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int largest = arr[0];
        for(int  i=0; i<arr.length;i++){
            if(!(largest >arr[i]) ){
                largest=arr[i];
            }
        }
        System.out.println(largest);
    }
}
