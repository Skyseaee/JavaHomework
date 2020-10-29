package HomeworkCode;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class RandomMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("pleast input the dimension n:");
        int dim = sc.nextInt();
        int[][] matrix= new int[dim][dim];
        matrix = CreateMatrix(matrix,dim);
        DrawMatrix(matrix,dim);
    }

    //Integer x = 3+new Integer(3);
    public static int[][] CreateMatrix(int[][] matrix,int dim) {
        for(int i=0;i<dim;i++) {
            for(int j=0;j<dim;j++) {
                matrix[i][j] = (int)(Math.random()*2);
            }
        }
        return matrix;
    }

    public static void DrawMatrix(int[][] matrix,int dim) {
        for(int i=0;i<dim;i++) {
            for(int j=0;j<dim;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
