package poly;
import java.math.BigInteger;
import java.util.ArrayList;

public class demo {

    public static void main(String[] args) {

        int n = 10;
        int k = 7;

        ArrayList<BigInteger> x = new ArrayList<>();
        ArrayList<BigInteger> y = new ArrayList<>();

        
        for (int i = 1; i <= k; i++) {
            x.add(BigInteger.valueOf(i));
        }


        y.add(new BigInteger(
                "13444211440455345511", 6));

        y.add(new BigInteger(
                "aed7015a346d635", 15));

        y.add(new BigInteger(
                "6aeeb69631c227c", 15));

        y.add(new BigInteger(
                "e1b5e05623d881f", 16));

        y.add(new BigInteger(
                "316034514573652620673", 8));

        y.add(new BigInteger(
                "2122212201122002221120200210011020220200",
                3));

        y.add(new BigInteger(
                "20120221122211000100210021102001201112121",
                3));

      

        System.out.println("Points:");

        for (int i = 0; i < k; i++) {

            System.out.println(
                    "(" + x.get(i) +
                    ", " + y.get(i) + ")"
            );
        }


        BigInteger answer = BigInteger.ZERO;

        for (int i = 0; i < k; i++) {

            BigInteger numerator = y.get(i);
            BigInteger denominator = BigInteger.ONE;

            for (int j = 0; j < k; j++) {

                if (i != j) {

                   
                    numerator = numerator.multiply(
                            x.get(j).negate()
                    );

                    denominator = denominator.multiply(
                            x.get(i).subtract(x.get(j))
                    );
                }
            }

            answer = answer.add(
                    numerator.divide(denominator)
            );
        }

       

        System.out.println();
        System.out.println(
                "Constant coefficient = " + answer
        );
    }
}