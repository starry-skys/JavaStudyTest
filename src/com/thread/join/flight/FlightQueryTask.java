package com.thread.join.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @DATE 2018/11/1 16:31
 */
public class FlightQueryTask extends Thread implements FlightQuery {

    private String origin;
    private String dest;
    private List<String> flightList = new ArrayList<String>();

    public FlightQueryTask() {

    }

    public FlightQueryTask(String name,String origin,String dest) {
        super("["+name+"]");
        this.origin = origin;
        this.dest = dest;
    }

    @Override
    public void run() {
        System.out.printf("%s-query:%s to %s \n",getName(),origin,dest);

        int interval = ThreadLocalRandom.current().nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(interval);
            flightList.add(getName()+"-"+interval);
            System.out.printf("The flight %s query successful \n",getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return flightList;
    }
}
