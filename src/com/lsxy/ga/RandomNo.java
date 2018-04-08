package com.lsxy.ga;

import java.util.Random;

public class RandomNo {
    
    public static void main (String args[]) {
    	
    	int[] lists = getRandomList(10,10);
    	for(int i=0;i<10;i++){
    		System.out.print(lists[i]+",");
    	}	
    }
    
   //产生一定范围内数据无重复的随机数组  
   public static int[] getRandomList(int count,int b){
	   int[] list= new int[count];
	   
	   //初始化数组，即创建一个有序的数组
	   for(int i=0;i<count;i++){
		   list[i]=i;
	   }
	   for(int i=0;i<count;i++){
		  int k =getRandom(0,count,b);
		  int j =getRandom(0,count,i*b);
		  int temp;
		  temp=list[k];
		  list[k]=list[j];
		  list[j]=temp;
	   }
	  
	   
	   return list;
   }
    
    
   //得到一个随机数
    public static int getRandom(int start,int last,int i){
    	//i为种子的变量
    	int rd;
    	do{
    		Random r =  new Random();
    		rd = r.nextInt(last);
    	}while(rd<start);
    	return rd;
    }
      
}


