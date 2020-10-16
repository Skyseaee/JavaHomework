package HomeworkCode;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseInterger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the number will be test.");
        int number = sc.nextInt();
        boolean result = isPalindrome(number);
        System.out.println("the number you input is: "+number+" and the result of whether it is a isPalindrome "+result);
    }

    public static int reverse(int number) {
        ArrayList<Integer> arrayList = new ArrayList();
        while(number%10!=0) {
            int m = number%10;
            arrayList.add(m);
            number /= 10;
        }
        int finalNum=0;
        int digit = 1;
        for(int i=0;i<arrayList.size();i++) {
            finalNum += arrayList.get(arrayList.size()-1-i) * digit;
            digit *= 10;
        }
        return finalNum;
    }

    public static boolean isPalindrome(int number) {
        if(number==reverse(number))
            return true;
        else
            return false;
    }
}


