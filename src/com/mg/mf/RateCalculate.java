package com.mg.mf;

public class RateCalculate {

    public static double foo1(double numbers, int years, double rate)
    {
        double add = 1 + rate;
        double sum = numbers;
        for(int i = 0; i < years; i++)
        {
            sum = sum*add;
        }
        //System.out.println(sum);
        return sum;
    }
    
    public static double foo2(double numbers, int years, double rate)
    {
        double sum = 0;
        for(int i = 0; i < years; i++)
        {
            sum = sum + foo1(numbers, years - i, rate);
        }
        System.out.println(sum);
        return sum;
    }
    
    
    public static void main(String[] args) {
        System.out.println(foo1(10000, 300, 0.06f));
        //foo2(408, 3, 0.75f);
        //foo2(5000, 3, 0.23f);
        
    }

}
