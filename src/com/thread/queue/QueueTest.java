package com.thread.queue;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {

        PriorityBlockingQueue<Person> priorityBlockingQueue = new PriorityBlockingQueue<>(1, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });

        Person p2 = new Person(7, "李四");
        Person p1 = new Person(9, "张三");
        Person p3 = new Person(6, "王五");
        Person p4 = new Person(2, "赵六");
        priorityBlockingQueue.add(p1);
        priorityBlockingQueue.add(p2);
        priorityBlockingQueue.add(p3);
        priorityBlockingQueue.add(p4);

        System.out.println(priorityBlockingQueue);
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue);
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue);

    }
}
