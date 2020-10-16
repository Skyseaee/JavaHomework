package HomeworkCode;

import java.util.Scanner;

public class CountofMatrixdiv {
    public static void main(String[] args) {
        //读取矩阵的维度，生成相应的矩阵
        Scanner sc = new Scanner(System.in);
        System.out.print("pleast input the dimension n:");
        int dim = sc.nextInt();
        double[][] matrix=new double[dim][dim];
        //读取数据
        int count=0;
        while (count<dim*dim) {
            int i = count/dim;
            Scanner sc2 = new Scanner(System.in);
            System.out.print("please input "+(i+1)+" line "+(count-dim*i+1)+" column"+"number:");
            matrix[i][count-dim*i] = sc2.nextDouble();
            count++;
        }
        //计算和
        double result = sumMajorDiagonal(matrix);
        //打印相关内容
        for(int i=0;i<dim;i++) {
            for(int j=0;j<dim;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("sum of the MajorDiagonal is: "+result);

    }

    public static double sumMajorDiagonal (double[][] m) {
        double result=0.0;
        for(int i=0;i<m[0].length;i++) {
            for(int j=0;j<m[0].length;j++) {
                if(i==j) {
                    result+=m[i][j];
                }
            }
        }
        return result;
    }
}
