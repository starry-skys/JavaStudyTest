package com.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Author zwb
 * @DATE 2020/7/14 10:01
 */
public class DelayTest {

    private static String host = "123.206.6.44";
    private static int port = 6379;
    private static Jedis jedis;

    private static final String prefix = "00000000";
    public static CountDownLatch countDownLatch = new CountDownLatch(10);

    static {
        JedisPool jedisPool = new JedisPool(host, port);
        jedis = jedisPool.getResource();
    }

    //生产者，生产5个订单
    public void produce(){
        for (int i = 1; i <= 5; i++) {
            Calendar calendar = Calendar.getInstance();
            //加3秒
            calendar.add(Calendar.SECOND,i+3);

            String orderId = prefix + i;
            jedis.zadd("order",calendar.getTimeInMillis()/1000, orderId);
            System.out.println("生产订单:" + orderId + ",当前时间" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }

    //消费者
    public void consume(){
        while (true){
            Set<Tuple> orders = jedis.zrangeWithScores("order", 0, 0);
            if(orders == null || orders.isEmpty()){
                System.out.println("没有生产者任务");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            Tuple tuple = (Tuple) orders.toArray()[0];
            double score = tuple.getScore();
            long nowTime = Calendar.getInstance().getTimeInMillis() / 1000;
            if(nowTime >= score){
                String orderId = tuple.getElement();
                Long removed = jedis.zrem("order", orderId);
                //大于零说明删除成功
                if(removed > 0){
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                            "消费了一个任务，消费的订单号为:" + orderId);
                }
            }
        }
    }

    class DelayMessage implements Runnable {

        @Override
        public void run() {
            countDownLatch.countDown();
            consume();
        }
    }

    @Test
    public void test() throws InterruptedException {
        //一个生产者，十个消费者
        DelayTest test = new DelayTest();
        test.produce();
        Thread.sleep(3000);
        for (int i = 0; i < 10; i++) {
            new Thread(new DelayMessage()).start();
            countDownLatch.await();
        }
    }
}
