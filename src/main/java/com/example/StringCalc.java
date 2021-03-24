package com.example;

public class StringCalc {

    int add(String numbers){



if (numbers.isBlank())
        return 0;


else {
    if(numbers.length()>1)
    if(numbers.substring(0,2).equals("//"))
    numbers = numbers.substring(4);


    String [] arrayNumbers = numbers.split("[;\n,]");

    int sum = 0;


    for (var arraynumber:arrayNumbers) {
        sum += Integer.parseInt(arraynumber);


    }
    return sum;
}
    }
}
