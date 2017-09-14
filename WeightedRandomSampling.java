package week1;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Gang Song on 9/13/17.
 */
public class WeightedRandomSampling {

    double[] aggregatedW = null;
    int[] counts = null;

    WeightedRandomSampling(double[] w){
        int len = w.length;
        aggregatedW = new double[len];
        counts = new int[len];
        double temp = 0;

        for(int i=0; i<len; i++){
            aggregatedW[i] = temp;
            //System.out.println(aggregatedW[i]);
            temp+= w[i];
        }
    }

    public int getWeightedRandomSample(){
        double rand = Math.random();
        //System.out.println("rand: " + rand);
        int p = Arrays.binarySearch(aggregatedW, rand);
        if (p < 0){
            p = -p-1;
        }
        return p-1;
    }
    /*
        numberofSamples:  the number of samples you want to return
     */
    public int[] getArrayOfRandomSamples(int numberofSamples){
        int[] ret = new int[numberofSamples];

        for(int i=0; i<numberofSamples; i++){
            int p = getWeightedRandomSample();
            ret[i] = p;
            //System.out.println("p: " + p);
            counts[p]++;
        }
        return ret;
    }

    // testing program
    public static void main(String[] args){
        // input weights:  sum of all weights must be 1
        double[] ww = {0.1, 0.3, 0.2, 0.3, 0.1};
        WeightedRandomSampling wrs = new WeightedRandomSampling(ww);

        wrs.getArrayOfRandomSamples(1000);
        for(int i=0; i<wrs.counts.length; i++){
            System.out.println(wrs.counts[i]);
        }
    }
}
