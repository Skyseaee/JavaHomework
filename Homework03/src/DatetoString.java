import java.util.Date;

public class DatetoString {
    public static void main(String[] args) {
        long index = 10000;
        for(int i=0;i<8;i++) {
            Date date01 = new Date(index);
            System.out.println("The date is:" + date01.toString() + ", its parameter is "+index);
            index *= 10;
        }
    }
}
