package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Perceptron {
    private double a;
    private double t;
    private double y;
    private double d;
    private double sum;
    private double[] W;
    private ArrayList<String> alphabet;
    private Random r;

    public Perceptron(double a) {
        this.a = a;
        r = new Random();
        sum = 0;
        alphabet = new ArrayList<>();
        t = r.nextDouble()*5;
    }

    public void Train(ArrayList<InelVector> trainSet) {
        W = new double [trainSet.get(0).xyz.length];
        for(int i=0;i<W.length;i++)
        {
            W[i] = r.nextDouble();
        }
        alphabet.add(trainSet.get(0).definition);
        alphabet.add(trainSet.get(trainSet.size()-1).definition);
        Collections.shuffle(trainSet);
//        double countRight=0;
        for (int i=0;i<trainSet.size();i++){
            y=Test(trainSet.get(i).xyz);
            d=alphabet.indexOf(trainSet.get(i).definition);
            if(d!=y){
                Learn(trainSet.get(i).xyz);
                i--;
//                countRight-=2;
            }
//            else{
//                countRight++;
//            }
        }
//        System.out.println(countRight+" "+trainSet.size());
//        System.out.println("Accuracy: " + (Math.round(countRight/(double)trainSet.size()*100)+"%"));
    }
    private void Learn(double[] xyz){
        int length = xyz.length>W.length ? W.length : xyz.length ;
        for(int i = 0; i < length; i++){
            W[i] += (d-y) * a * xyz[i];
        }
        t += (d-y) * a * (-1);
    }
    private double Test(double[] xyz){
        int length = xyz.length>W.length ? W.length : xyz.length ;
        sum=0.0;
        for(int i = 0; i < length; i++){
            sum+=xyz[i]*W[i];
        }
        return sum>t? 1 : 0;

    }

    public String determ(InelVector inelVector) {
        y=Test(inelVector.xyz);
        d=alphabet.indexOf(inelVector.definition);
        System.out.println(alphabet.get((int)y));
//        System.out.println("Accuracy: "+Math.round(Math.abs((Math.abs(t) - Math.abs(sum))/t*100))+"%");
        System.out.println("______________________");
        return alphabet.get((int)y);
    }
}
