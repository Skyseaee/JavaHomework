package HomeworkCode;

import java.util.Scanner;

public class FindMinIndex {
    public static void main(String[] args) {
        System.out.println("please input 10 num you want to compare.");
        int count=0;
        double[] array = new double[10];
        while (count<10) {
            Scanner sc = new Scanner(System.in);
            System.out.print("please input "+(count+1)+" number:");
            array[count] = sc.nextDouble();
            count++;
        }
        int index = indexOfSmal1estEIement(array);
        System.out.println("index of the samllest element of these numbers is:"+ index);
    }

    public static int indexOfSmal1estEIement(double[] array) {
        int index=0;
        double minNum = array[0];
        for(int i=0;i< array.length;i++) {
            if(minNum>array[i]) {
                index = i;
            }
        }
        return index;
    }
}
