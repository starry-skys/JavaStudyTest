package com.thread.test.batch;

import java.util.ArrayList;
import java.util.List;

public class BatchUtil {
    static public <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<T>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((i + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }

    static public <T> List<List<T>> splitList1(List<T> list, int pageSize) {
        int listSize = list.size();
        int pageCount = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i < pageCount; i++) {
            List<T> subList = new ArrayList<T>();
            for (int j = 0; j < pageSize; j++) {
                int pc = i * pageSize; //每页起始下标
                int index = j + pc;
                if(index >= listSize) break;
                subList.add(list.get(index));
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
