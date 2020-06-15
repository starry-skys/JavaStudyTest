package com.thread.join.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 *
 * @DATE 2018/11/1 16:46
 */
public class FlightQueryTest {
    private static List<String> flightCompany = Arrays.asList("南方航空","东方航空","海南航空");

    private static List<String> search(String origin,String dest){
        List<String> result = new ArrayList<String>();

        List<FlightQueryTask> tasks = flightCompany.stream().map(f -> new FlightQueryTask(f, origin, dest)).collect(toList());
        tasks.forEach(Thread::start);
        tasks.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tasks.stream().map(FlightQuery::get).forEach(result::addAll);

        return result;
    }

    public static void main(String[] args) {
        List<String> results = search("北京", "上海");
        System.out.println("======result=====");
        results.forEach(System.out::println);
    }
}
