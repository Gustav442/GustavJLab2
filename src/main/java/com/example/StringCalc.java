package com.example;

import java.util.ArrayList;

public class StringCalc {
    int sum = 0;
    ArrayList<String> negativeNumberList = new ArrayList();

    int add(String numbers) {


        if (numbers.isBlank())
            return 0;


        else {
            if (numbers.length() > 1)
                if (numbers.substring(0, 2).equals("//"))
                    numbers = numbers.substring(4);


            String[] arrayNumbers = numbers.split("[;\n,]");




            for (var arraynumber : arrayNumbers) {
                if (Integer.parseInt(arraynumber) > 0)
                    sum += Integer.parseInt(arraynumber);
                else
                    negativeNumberList.add(arraynumber);

            }

            if (!negativeNumberList.isEmpty())
                throw new RuntimeException("negative numbers NOT ALLOWED!!"+negativeNumberList);


        }
        return sum;
    }


}

