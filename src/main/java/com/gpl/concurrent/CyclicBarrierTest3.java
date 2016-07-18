package com.gpl.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(3); // 三个线程同时到达
		 new SubTask1("A", cb).start();
		 new SubTask1("B", cb).start(); 
	     new SubTask1("C", cb).start();
	}
	 
}

class SubTask1 extends Thread { 
    private String name; 
    private CyclicBarrier cb; 

    SubTask1(String name, CyclicBarrier cb) { 
            this.name = name; 
            this.cb = cb; 
    } 

    public void run() { 
            //System.out.println("[并发任务" + name + "]  开始执行"); 
            //for (int i = 0; i < 999999; i++) ;    //模拟耗时的任务 
            
            try {
				Thread.sleep((long) (Math.random() * 10000));
				System.out.println("线程"+ Thread.currentThread().getName()+ "即将到达集合地点1，当前已有"
						+ (cb.getNumberWaiting() + 1)+ "个已到达"+ (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊": "正在等候"));
				try { 
				        //每执行完一项任务就通知障碍器 
				        cb.await(); 
				} catch (InterruptedException e) { 
				        e.printStackTrace(); 
				} catch (BrokenBarrierException e) { 
				        e.printStackTrace(); 
				}Thread.sleep((long) (Math.random() * 10000));
				System.out.println("线程"
						+ Thread.currentThread().getName()
						+ "即将到达集合地点2，当前已有"
						+ (cb.getNumberWaiting() + 1)
						+ "个已到达"
						+ (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊"
								: "正在等候"));
				try {
					cb.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.sleep((long) (Math.random() * 10000));
				System.out.println("线程"
						+ Thread.currentThread().getName()
						+ "即将到达集合地点3，当前已有"
						+ (cb.getNumberWaiting() + 1)
						+ "个已到达"
						+ (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊"
								: "正在等候"));
				try {
					cb.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    } 
}