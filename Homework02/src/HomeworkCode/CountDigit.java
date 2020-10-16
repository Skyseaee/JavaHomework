package HomeworkCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountDigit {
    public static void main(String[] args) {
        //随机生成100个随机整数
        int[] vectors = CreateNum();

        int[] result = new int[10];
        //统计各个个位数的数目
        for(int i=0;i<vectors.length;i++) {
            result[vectors[i]]++;
        }
        System.out.println(Arrays.toString(result)+" "+vectors.length);
    }

    public static int[] CreateNum() {
        int[] vectors = new int[100];
        for(int i=0;i<100;i++) {
            vectors[i] = (int)(Math.random()*10);
        }
        return vectors;
    }
}
