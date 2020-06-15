package com.thread.futures.custom;

public class FutureClient {

	public Data call(){
		//创建一个代理对象FutureData，先返回给客户端（无论是否有值）
		final FutureData futureData = new FutureData();
		//启动一个新的线程，去异步加载真实的对象
		new Thread(new Runnable() {
			@Override
			public void run() {
				futureData.setRunningThread();
				RealData realData = new RealData();
				//等真实数据处理完毕之后，把结果赋值给代理对象
				futureData.setRealData(realData);
			}
		}).start();
		
		return futureData;
	}
	
}
