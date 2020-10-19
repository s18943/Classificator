package com.company;

public class InelVector {
  double[] xyz;
  String definition;

    public InelVector(String[] arrDef){
        int length = arrDef.length-1;
        definition = arrDef[length];
        xyz = new double[length];
        for(int i=0; i<length;i++){
            xyz[i]=Double.parseDouble(arrDef[i]);
        }
    }

    public double distance(InelVector two){
        int length = xyz.length>two.xyz.length ? two.xyz.length : xyz.length ;
        double sum=0;
        for(int i = 0; i < length; i++){
            sum+=Math.pow(xyz[i]-two.xyz[i],2);
        }
        return Math.sqrt(sum);
    }
}
