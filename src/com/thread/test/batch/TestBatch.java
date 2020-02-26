package com.thread.test.batch;

import com.thread.test.batch.BatchUtil;

import java.util.ArrayList;
import java.util.List;

public class TestBatch {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(Integer.toString(i));
        }

        List<List<String>> lists = BatchUtil.splitList1(list, 2);
        int listSize = lists.size();
        for (int i = 0; i < listSize; i++) {
            List<String> stringList = lists.get(i);
            System.out.println(stringList.toString());
        }
    }
}
