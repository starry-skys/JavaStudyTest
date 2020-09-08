package com.stream.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Stephen
 * @date 2020/9/5 20:50
 */
public class DateTest {
    @Test
    public void test1() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Date> future = executorService.submit(() -> sdf.parse("20200905"));
            list.add(future);
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }

    }

    @Test
    public void test2(){
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.of(2020, 9, 5);
        System.out.println(localDate2);
        LocalDate localDate3 = LocalDate.parse("2020-09-05");
        System.out.println(localDate3);

        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate.getYear()); //2020
        System.out.println(currentDate.getMonth()); // SEPTEMBER
        System.out.println(currentDate.getMonthValue()); //9
        System.out.println(currentDate.getDayOfYear()); //249
        System.out.println(currentDate.getDayOfMonth()); //5
        System.out.println(currentDate.getDayOfWeek()); // SATURDAY

    }

    @Test
    public void test3(){
        LocalDate date1 = LocalDate.of(2020, 9, 5);
        LocalDate date2 = LocalDate.of(2020, 9, 6);
        System.out.println(date1.isBefore(date2)); //true
        System.out.println(date1.isAfter(date2)); //false
        System.out.println(date1.equals(date2)); //false
        System.out.println(date1.isLeapYear()); //true

        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);  //2020-09-05
        System.out.println(nowDate.plusDays(1)); //2020-09-06
        System.out.println(nowDate.plusWeeks(1)); //2020-09-12
        System.out.println(nowDate.plusMonths(1)); //2020-10-05
        System.out.println(nowDate.plusYears(1)); //2021-09-05
    }

    @Test
    public void test4(){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        Duration duration = Duration.between(today, tomorrow); //第二个参数减去第一个参数的时间差
        System.out.println(duration.toDays()); //总天数，1
        System.out.println(duration.toHours()); //小时，24
        System.out.println(duration.toMinutes()); //分钟，1440
        System.out.println(duration.getSeconds()); //秒，86400
        System.out.println(duration.toMillis()); //毫秒，86400000
        System.out.println(duration.toNanos()); // 纳秒，86400000000000

    }

    @Test
    public void test5(){
        LocalDate today = LocalDate.now(); //今天
        LocalDate date = LocalDate.of(2020,10,1); //国庆节
        //1. 用 between 创建 Period 对象
        Period period = Period.between(today, date);
        System.out.println(period); // P26D
        //2. 用 of 创建 Period 对象
        Period of = Period.of(2020, 9, 6);
        System.out.println(of); // P2020Y9M6D
        // 距离国庆节还有 0 年 0 月 26 天
        System.out.printf("距离国庆节还有 %d 年 %d 月 %d 天" , period.getYears(),period.getMonths(),period.getDays());
    }

    @Test
    public void test6(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
        ZoneId of = ZoneId.of("Asia/Shanghai");
        System.out.println(of);
        System.out.println(ZoneId.systemDefault()); //当前时区为： Asia/Shanghai
    }

    @Test
    public void test7(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 1. 日期时间转化为字符串。有两种方式
        String format = dtf.format(LocalDateTime.now());
        System.out.println(format); // 2020-09-05 23:02:02
        String format1 = LocalDateTime.now().format(dtf); //实际上调用的也是 DateTimeFormatter 类的format方法
        System.out.println(format1); // 2020-09-05 23:02:02
        // 2. 字符串转化为日期。有两种方式，需要注意，月和日位数要补全两位
        //第一种方式用的是，DateTimeFormatter.ISO_LOCAL_DATE_TIME ，格式如下
        LocalDateTime parse = LocalDateTime.parse("2020-09-05T00:00:00");
        System.out.println(parse); // 2020-09-05T00:00
        //第二种方式可以自定义
        LocalDateTime parse1 = LocalDateTime.parse("2020-09-05 00:00:00", dtf);
        System.out.println(parse1); // 2020-09-05T00:00
    }

    @Test
    public void test8() throws Exception{
        // SimpleDateFormat 改为 DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // Date 改为 LocalDate
        List<Future<LocalDate>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //日期解析改为 LocalDate.parse("20200905",dtf)
            Future<LocalDate> future = executorService.submit(() -> LocalDate.parse("20200905",dtf));
            list.add(future);
        }
        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }

    }
}
