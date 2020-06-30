public class BoxTest {
    /**
     * 数字在-128至127之间时，会直接使用缓存中的对象，而不是重新创建一个对象
     * @param args
     */
    public static void main(String[] args){
        Integer integer1 = 3;
        Integer integer2 = 3;

        if (integer1 == integer2){
            System.out.println("integer1 == integer2");
        }
        else
            System.out.println("integer1!=integer2");
        Integer integer3 = 300;
        Integer integer4 = 300;

        if(integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3!=integer4");
    }
}
