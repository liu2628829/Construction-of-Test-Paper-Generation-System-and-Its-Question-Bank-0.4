package com.lsxy.ga.test;



	/**
	 *<p>Title: 快速演算法</p>
	* <p>Description:
	* 快速排序法的基本精神是在數列中找出適當的軸心，
	* 然後將數列一分為二，分別對左邊與右邊數列進行排序，
	* 而影響快速排序法效率的正是軸心的選擇。</p>
	* <p>下面介绍了三种方法,从理论分析效率递增，
	* 但是没有用大数组来进行测试</p>
	* <p>Copyright: Copyright (c) 2005</p>
	* @author paulLiu
	* @version 1.0
	*/
	public class QuickSort { 

	  public QuickSort() {
	  }
	  /**
	   * printArray 用来跟踪了算法演算过程
	   */
	  public static void printArray(int[] number) {
	    for(int k=0 ;k<number.length;k++){
	         System.out.print(number[k]);
	         System.out.print(" ");
	        }
	   System.out.print("\n");
	  }

	  /**
	   * sort 只是为了便于观察分析才设了这个方法，可有可无。
	   * @param number int[] 数组
	   */
	  public static void sort(int[] number) {
	    //sort(number,0,number.length-1);
	    System.out.println("以左边第一个元素为轴算法结束/////////////////////");
	    //改进一：int s=number[(right-left)/2]
	    System.out.println("第一次改进开始！！！");
	    //provesortfirst(number,0,number.length-1);
	   System.out.println("第一次改进结束/////////////////////");
	    //改变二
	    System.out.println("second改进");
	   thirdsort(number,0,number.length-1);
	  }

	  /**
	   * sort
	   * 开始时，以左边第一个元素为轴
	   * @param number int[]
	   * @param left int
	   * @param right int
	   */
	  private static void sort(int[] number, int left, int right) {
	    if(left<right)
	    {
	      
	      int s=number[left];
	      int i=left;
	      int j=right+1;
	      while(true)
	      {
	        //令索引 i 從數列左方往右方找，直到找到大於 s 的數
	        while(i+1<number.length &&number[++i]<s);
	        //令索引 j 從數列右方往左方找，直到找到小於 s 的數
	        while(j>0&&number[--j]>s);
	        if(i>=j) break; //如果 i >= j，則離開迴圈
	        swap(number,i,j);//如果 i < j，則交換索引i與j兩處的值
	         printArray(number);
	      }
	      //将左侧轴与j交换
	      number[left]=number[j];
	      number[j]=s;
	      sort(number,left,j-1);//轴左边进行递归
	         printArray(number);
	    sort(number,j+1,right);//轴右边进行递归
	          printArray(number);
	   }
	  }

	  /**
	   * provesortfirst
	   * 以中间的元素为轴
	   * @param number int[]
	   * @param left int
	   * @param right int
	   */
	  public static void provesortfirst(int[] number, int left, int right) {
	    if(left < right) {             
	      int s = number[(right+left)/2];             
	      int i = left - 1;             
	      int j = right + 1;             
	      while(true) {                 
	      // 向右找                
	      while(number[++i] < s) ;               
	      // 向左找               
	      while(number[--j] > s) ;                 
	      if(i >= j)                    
	        break;                 
	      swap(number, i, j); 
	       printArray(number);
	    }             
	    provesortfirst(number, left, i-1);  
	      printArray(number);
	    provesortfirst(number, j+1, right); 
	      printArray(number);
	   }
	 }

	  /**
	   * swap
	   * 交换值方法
	   * @param number int[]
	   * @param i int
	   * @param j int
	   */
	  private static void swap(int[] number, int i, int j) {
	    int t;
	    t=number[i];
	    number[i]=number[j];
	    number[j]=t;
	  }

	  public static void main(String[] args) {
	   int[] number={1,45,17,24,11,54,32,14,26};
	    sort(number);
	  }
	    
	private static void thirdsort(int[] number,  
			   int left,       int right) 
    {  
      if(left < right) {             
        int q = partition(number, left, right);         
        thirdsort(number, left, q-1);  
           printArray(number);
        thirdsort(number, q+1, right);      
           printArray(number);
      }   
    }  
    /**
     * partition 在轴设置方面有优点
     * @param number int[]
     * @param left int
     * @param right int
     * @return int
     */  
    private static int partition(int number[],                  
                                 int left, int right) 
    {       
      int s = number[right];  //先以右边最后一个为轴      
      int i = left - 1;        
      for(int j = left; j < right; j++) 
      {    if(number[j] <= s) 
           {    i++;       
             swap(number, i, j);     
              printArray(number);
           }       
         }         
         swap(number, i+1, right); 
         return i+1;     
       }    
}



