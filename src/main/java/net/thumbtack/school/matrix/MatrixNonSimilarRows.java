package net.thumbtack.school.matrix;


import java.util.*;
import java.util.function.Consumer;

public class MatrixNonSimilarRows {
    Set<int[]> matr = new HashSet<>();
    //должен записывать номер уникальной строки
    //по идее так


    public MatrixNonSimilarRows(int[][] matrix) {
        Set<String> setlin = new HashSet<>();
        int[][] matrixsort = new int[matrix.length][];
        int m2 = 0;
        for (int[] i : matrix) {
            Set<Integer> test = new HashSet<>();
            for (int n : i) {
                test.add(n);
            }
            int[] m = new int[test.size()];
            int v = 0;
            for (int j : test) {
                m[v] = j;
                v++;
            }
            matrixsort[m2] = m;
            m2++;
        }
        int[][] matrsortcopy = matrixsort.clone();
        for (int i = 0, r = 0; i < matrixsort.length; i++) {
            for (int j = 0; j < matrsortcopy.length; j++) {
                if (Arrays.equals(matrixsort[j], matrsortcopy[i])) {
                    r++;
                }
            }
            matr.add(matrix[i]);
            setlin.add(Arrays.toString(matrsortcopy[i]));
            if (matr.size() != setlin.size()) {
                matr.remove(matrix[i]);
            }
            r = 0;
        }
    }


    public Set<int[]> getNonSimilarRows() {
        return matr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixNonSimilarRows that = (MatrixNonSimilarRows) o;
        return Objects.equals(matr, that.matr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matr);
    }
}
