package nov_20_challange.nov11;

import static java.lang.Math.*;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] p1p2 = vectorCoords(p1, p2);
        int[] p1p3 = vectorCoords(p1, p3);
        int[] p1p4 = vectorCoords(p1, p4);

        double p1p2Length = vectorLength(p1p2);
        double p1p3Length = vectorLength(p1p3);
        double p1p4Length = vectorLength(p1p4);

        if(p1p2Length == 0 || p1p3Length == 0 || p1p4Length == 0){
            return false;
        }

        if(p1p2Length == p1p3Length){
            return diagonalCheck(p2, p3, p1p2, p1p3, p1p4, p1p2Length, p1p3Length, p1p4Length);
        }
        if(p1p2Length == p1p4Length){
            return diagonalCheck(p2, p4, p1p2, p1p4, p1p3, p1p2Length, p1p4Length, p1p3Length);
        }
        if(p1p3Length == p1p4Length){
            return diagonalCheck(p3, p4, p1p3, p1p4, p1p2, p1p3Length, p1p4Length, p1p2Length);
        }

        return false;

    }

    private boolean diagonalCheck(int[] p2, int[] p3, int[] sideA, int[] sideB, int[] diagonal1, double aLength, double bLength, double d1Length) {
        if(scalar(sideA, sideB) != 0){
            return false;
        }
        if(abs(d1Length - sqrt(sqr(aLength)+sqr(bLength))) > 1 ){
            return false;
        } else {
            int[] diagonal2 = vectorCoords(p2, p3);
            double d2Lenght = vectorLength(diagonal2);
            if(d2Lenght != d1Length){
                return false;
            }
            double scalar = scalar(diagonal1,diagonal2);
            if(scalar != 0){
                return false;
            }
        }
        return true;
    }

    private double vectorLength(int[] vector) {
        return sqrt(sqr(vector[0]) + sqr(vector[1]));
    }

    private double scalar (int[] vectorA, int[] vectorB){
        return vectorA[0]*vectorB[0]+vectorA[1]*vectorB[1];
    }

    private double sqr(double i) {
        return pow(i, 2);
    }

    private int[] vectorCoords(int[] p1, int[] p2) {
        return new int[]{p2[0] - p1[0], p2[1] - p1[1]};
    }

}
