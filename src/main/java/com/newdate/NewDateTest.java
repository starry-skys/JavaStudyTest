package com.newdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Stephen
 * @date 2020/5/6 20:09
 */
public class NewDateTest {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String format = dtf.format(now);
        System.out.println(format);

        LocalDate parse = LocalDate.parse(format,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(parse.toString());
    }
}
