package com.thread.futures.custom;

public class RealData<T> implements Data<T>{

	private T result ;
	
	public RealData (){
	    this.prepare();
	}

    private void prepare() {
        //准备数据阶段，只有准备完成之后才可以继续往下走
        try {
            System.out.println("第一步:下单");
            System.out.println("第一步:等待送货");
            Thread.sleep(5000);
            System.out.println("第一步:快递送到");
        } catch (InterruptedException e) {
            System.out.println("被中断:"+e);
            //重新设置中断状态
            Thread.currentThread().interrupt();
        }
        Main.Chuju chuju = new Main.Chuju();
        result = (T)chuju;
    }

//    public isInterrupted(){
//
//    }

    @Override
	public T get() {
		return result;
	}

	@Override
	public boolean isDone() {
		return false;
	}

    @Override
    public boolean cancel() {
        return true;
    }

}
