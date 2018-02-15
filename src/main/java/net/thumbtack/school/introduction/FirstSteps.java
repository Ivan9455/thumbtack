package net.thumbtack.school.introduction;

import sun.font.FontRunIterator;

import java.util.Arrays;

public class FirstSteps {
    public int sum (int x, int y){
        return x+y;
    }

    public int mul(int x, int y){
        return x*y;
    }

    public int div (int x, int y){
        int z = (y!=0)?x/y : 0;
        return z;
    }

    public int mod (int x, int y){
        int z = (y!=0)?x%y : 0;
        return z;
    }

    public boolean isEqual (int x, int y){
        boolean z = (x==y)?true:false;
        return z;
    }

    public boolean isGreater (int x, int y){
        boolean z = (x>y)?true:false;
        return z;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y){
        boolean k1 = (xLeft<=x && xRight>=x)?true:false;
        boolean k2 = (yTop<=y && yBottom>=y)?true:false;
        boolean m = ( k1 && k2)?true:false;
        return m;
    }

    public int sum(int[] array){
        int z = 0;
        if(array.length!=0){
            for (int i = 0; i < array.length; i++) {
                z = z + array[i];
            }
        }
        return z;
    }

    public int mul(int[] array){
        int z = 0;
        if(array.length!=0){
            for (int i = 0; i < array.length; i++) {
                z = (i==0)?z +  array[i] : z*array[i];
            }
        }
        return z;
    }

    public int min(int[] array){
        int z = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(i==0||z>array[i]){
                z = array[i];
            }
        }
        return z;
    }

    public int max(int[] array){
        int z = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(i==0||z<array[i]){
                z = array[i];
            }
        }
        return z;
    }

    public double average(int[] array){
        double z = 0;
        if(array.length!=0){
            for (int i = 0; i < array.length; i++) {
                z = z + array[i];
            }
            z = z/array.length;
        }
        return z;
    }

    public boolean isSortedDescendant(int[] array){
        boolean z = true;
        if(array.length!=0){
            int max = 0;
            for (int i = 0; i < array.length; i++) {
                if(i==0 || max>array[i]){
                    max = array[i];
                }
                else{
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    public void cube(int[]array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)Math.pow(array[i],3);
        }
    }
    public boolean find(int[]array, int value){
        boolean z = true;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value ){
                z = true;
                break;
            }
            else{
                z = false;
            }
        }
        return z;
    }
    public void reverse(int[]array){
        int[] arr = array.clone();
        for(int i = 0; i < array.length; i++)
        {
            array[i] = arr[array.length - 1 -i];
        }
    }

    public boolean isPalindrome(int[]array){
        int[] arr = array.clone();
        boolean z = true;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == arr[array.length - 1 - i]){
                z = true;
            }
            else{
                z = false;
                break;
            }

        }
        return z;
    }

    public int sum(int[][] matrix){
        int summa = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                summa = summa + matrix[i][j];
            }
        }
        return summa;
    }

    public int max(int[][] matrix){
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if((i==0&&j==0) || maxx < matrix[i][j]){
                    maxx = matrix[i][j];
                }
            }
        }
        return maxx;
    }

    public int diagonalMax(int[][] matrix){
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if((i==0&&j==0) || maxx < matrix[i][j]){
                    maxx = matrix[i][j];
                }
            }
        }
        return maxx;
    }

    public boolean isSortedDescendant(int[][] matrix){
        boolean z = true;
        for (int i = 0; i < matrix.length; i++) {
            if(isSortedDescendant(matrix[i])){
                z = true;
            }
            else {
                z = false;
                break;
            }
        }
        return z;
    }
}
