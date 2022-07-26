package com.banking.testCases;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class JavaStreams {
    @Test
    public void numsStreamTest() {
        Integer[] arr ={7,4,4,3,1,6,6,5,9,8,8,10,2,2};
        List<Integer> arrayList= Arrays.asList(arr); //Converting Array to list
        System.out.println("Count of numers greater than 4 :" + arrayList.stream().filter(s -> s > 4).count());
        System.out.print("numbers greater than 5: ");
        arrayList.stream().filter(s -> s > 5).forEach(s-> System.out.print(s+","));
        System.out.print("\nunique numbers in the list: ");
        arrayList.stream().distinct().forEach(s-> System.out.print(s+","));
        System.out.print("\nSorted list: ");
        arrayList.stream().sorted().forEach(s-> System.out.print(s+","));
        System.out.print("\nFiltered Sorted Even numbers: ");
        arrayList.stream().sorted().filter(s->s %2==0).forEach(s-> System.out.print(s+","));
    }
    @Test
    public void stringStreamTest() {
        String[] arr ={"Cricket","Basketball","Football","Badminton","Tennis"};
        List<String> arrayList= Arrays.asList(arr); //Converting Array to list
        System.out.print("\nSorted list: ");
        arrayList.stream().sorted().forEach(s-> System.out.print(s+","));
        System.out.print("\ngames ends with ball: ");
        arrayList.stream().filter(s -> s.endsWith("ball")).forEach(s-> System.out.print(s+","));
        System.out.print("\ngames starts with 'C': ");
        arrayList.stream().filter(s -> s.startsWith("C")).forEach(s-> System.out.print(s+","));
    }
    @Test
    public void testt() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).count();
        System.out.println(size);
    }
}
