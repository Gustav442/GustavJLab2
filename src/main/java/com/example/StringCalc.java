package com.example;

public class StringCalc {

    int add(String numbers){

if (numbers.isBlank())
        return 0;
else {
    String [] arrayNumbers = null;
    int sum = 0;
    arrayNumbers = numbers.split("[\n,]");

    for (var arraynumber:arrayNumbers){
    sum += Integer.parseInt(arraynumber);


    }
    return sum;
}
    }
}
