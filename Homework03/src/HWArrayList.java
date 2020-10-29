import java.util.ArrayList;
import java.util.Arrays;

public class HWArrayList {
    public static void main(String[] args) {
        Integer[] numbers = {1,3,2,5,4,11,5,9,7};
        ArrayList<Number> arrayList = new ArrayList<>(Arrays.asList(numbers));
        sort(arrayList);
        System.out.println(arrayList.toString());
    }

    public static void sort(ArrayList<Number> list) {
        if(list.size()==0||list.size()==1) {
            return;
        }
        for(int i=0;i<list.size();i++) {
            Number number = list.get(i);
            int minIndex = i;
            for(int j=i+1;j<list.size();j++) {
                if(list.get(j).doubleValue()<number.doubleValue()) {
                    minIndex = j;
                    number = list.get(j);
                }
            }
            if(minIndex != i) {
                list.set(minIndex,list.get(i));
                list.set(i,number);
            }
        }
    }
}


