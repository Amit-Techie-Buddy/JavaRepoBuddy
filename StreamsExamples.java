package com.johndeere.gdl.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String args[]){

        //Longest string in the list.
        List<String> lst = Arrays.asList("fffffffffff","dfdddddddddddddd","eeeeeeeeeee");
        Optional<String> result = lst.stream().max(Comparator.comparingInt(String::length));
        System.out.println(result);

        //Calculate the average age of a list of Person objects using Java streams
        List<Person> persons = Arrays.asList(new Person("John", 20), new Person("Doe", 30), new Person("Smith", 40));
        double avgAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println(avgAge);

        //Check if a list of integers contains a prime number using Java streams
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        boolean containsPrime = numbers.stream().anyMatch(new StreamsExamples() :: isPrime);
        System.out.println(containsPrime);

        //Merge two sorted lists into a single sorted list using Java streams
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        mergedList.stream().forEach(System.out::println);

        //Flattened list of lists
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        listOfLists.stream().flatMap(List::stream).forEach(System.out::println);

        //Remove duplicates from a list while preserving the order using Java streams
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        numbersList.stream().distinct().forEach(System.out::println);

        //Given a list of transactions, find the sum of transaction amounts for each day using Java streams
        List<Transaction> transactions = Arrays.asList(new Transaction("2021-01-01", 100), new Transaction("2021-01-01", 200),
                new Transaction("2021-01-02", 300), new Transaction("2021-01-02", 400));
        transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)))
                .forEach((date, sum) -> System.out.println(date + " : " + sum));

        //Count and arrange most frequent number in the list
        List<Integer> numbersList2 = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        numbersList2.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparingLong(e -> -e.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        //Given a list of strings, find the frequency of each word using Java streams
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .forEach((word, count) -> System.out.println(word + " : " + count));

        //Implement a method to partition a list into two groups based on a predicate using Java streams
        List<Integer> numberList3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numberList3.stream().collect(Collectors.partitioningBy(n->n%2==0));
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);




    }

    public boolean isPrime(int number){
        if(number <=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}

class Transaction{
    String date;
    int amount;

    public Transaction(String date, int amount){
        this.date = date;
        this.amount = amount;
    }

    public String getDate(){
        return date;
    }

    public int getAmount(){
        return amount;
    }


}
