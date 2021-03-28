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
                if (numbers.substring(0, 2).equals("//")) {

                    if (numbers.indexOf('[') > 0) {

                        newDelimiter = numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf(']'));
                        numbers = numbers.replace(newDelimiter.trim(), ",");
                        numbers = numbers.substring(numbers.indexOf(']') + 1);
                        numbers = numbers.substring(numbers.indexOf("\n") + 1);
                    } else
                        numbers = numbers.substring(numbers.indexOf("\n") + 1);

                }


            String[] arrayNumbers = numbers.split("[;\n,]");

            for (var arraynumber : arrayNumbers) {
                if (Integer.parseInt(arraynumber) > 0 && (Integer.parseInt(arraynumber) <= 1000))
                    sum += Integer.parseInt(arraynumber);

                else if (Integer.parseInt(arraynumber) < 0)
                    negativeNumberList.add(arraynumber);

            }

            if (!negativeNumberList.isEmpty())
                throw new RuntimeException("negative numbers NOT ALLOWED!!" + negativeNumberList);


        }
        return sum;
    }


}

