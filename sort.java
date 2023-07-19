
public class sort {
    public static int[] allBox;
    //7 10 5 2 4 3 9 8 1 6
    public static int partition(int l, int h)
    {
        int pivot=allBox[l];
        int start=l,end=h,temp2;
        while (start<end){
            while (allBox[start]<=pivot){
                start++;
            }
            while (allBox[end]>pivot){
                end--;
            }
            if(start<end){
                int temp=allBox[start];
                allBox[start]=allBox[end];
                allBox[end]=temp;
            }
        }
        temp2=allBox[l];
        allBox[l]=allBox[end];
        allBox[end]=temp2;
        return end;

    }
    public static void quickSort(int l, int h)
    {
        if(l<h){
            int p=partition(l,h);
            quickSort(l,p-1);
            quickSort(p+1,h);
        }
        //return;

    }

    public static void main(String[] args) {
        allBox=new int[]{7 ,10, 5, 2, 4, 3, 9, 8, 1, 6};
        quickSort(0,9);
        for (int i=0; i<10; i++){
            System.out.println(allBox[i]+" ");
        }
    }
}

