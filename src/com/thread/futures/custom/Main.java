package com.thread.futures.custom;

import com.thread.futures.FutureCook;

public class Main {

	static class Chuju{

	}

	static class Shicai{

	}

	public static void main(String[] args) throws InterruptedException {
		
		FutureClient fc = new FutureClient();
		Data data = fc.call();

		Thread.sleep(2000);
		Shicai shicai = new Shicai();
		System.out.println("第二步:食材到位");

		if(!data.isDone()){
			System.out.println("第三步:厨具还没到,请等待或者取消");
			data.cancel();
            System.out.println("已取消");
			return;
		}

		//真正需要数据的时候，再去获取
		Chuju chuju = (Chuju)data.get();
		System.out.println("第三步:厨具到位,可以烹饪了");

		cook(chuju,shicai);

	}

	public static void cook (Chuju chuju, Shicai shicai){
		System.out.println("最后:烹饪中...");
	}
}
