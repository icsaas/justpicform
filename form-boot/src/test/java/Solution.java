import java.util.*;

public class Solution {
    public static void main(String[] args) {


        Scanner cin = new Scanner(System.in);

        String str1=cin.nextLine();
        String str2 =cin.nextLine();
        String str3 = cin.next();
        System.out.println("###");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=cin.nextInt();
        }
        System.out.print(Arrays.toString(arr));
        HashMap<Integer,Integer> map = new HashMap<>();
        int len=arr.length;
        for(int i=0;i<len;i++){
            final Integer value=map.get(arr[i]);
            if(value!=null){
               System.out.println(value+":"+i);
            }
            map.put(100-arr[i],i);
        }



    }
}
