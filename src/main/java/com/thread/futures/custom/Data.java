package com.thread.futures.custom;

public interface Data<T> {

	T get();

	boolean isDone();

	boolean cancel();
}
