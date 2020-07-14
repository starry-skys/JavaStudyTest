package com.thread.futures.custom;

public class FutureData<T> implements Data<T>{

	private RealData<T> realData ;
	
	private boolean isReady = false;

	private Thread runningThread;
	
	public synchronized void setRealData(RealData realData) {
		//如果已经装载完毕了，就直接返回
		if(isReady){
			return;
		}
		//如果没装载，进行装载真实对象
		this.realData = realData;
		isReady = true;
		//进行通知
		notify();
	}
	
	@Override
	public synchronized T get() {
		//如果没装载好 程序就一直处于阻塞状态
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//装载好直接获取数据即可
		return realData.get();
	}


	public boolean isDone() {
		return isReady;
	}

	@Override
	public boolean cancel() {
		if(isReady){
            return false;
		}
        runningThread.interrupt();
		return true;
	}

	public void setRunningThread(){
        runningThread = Thread.currentThread();
    }
}
