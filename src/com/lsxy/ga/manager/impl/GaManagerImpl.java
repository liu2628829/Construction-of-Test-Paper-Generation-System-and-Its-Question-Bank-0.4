package com.lsxy.ga.manager.impl;

import com.lsxy.ga.RandomNo;
import com.lsxy.ga.manager.*;
import com.lsxy.ga.model.GaModle;
import com.lsxy.ga.model.Policy;
import com.lsxy.ga.model.TestQuestion;
import com.lsxy.ga.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GaManagerImpl extends AbstractManager implements GaManager {
	
	//主要管理参数声明
	private GaModleManager gaModleManager;//组卷主要参数管理
    private TypeManager typeManager;//类型管理
    private KnowledgePointManager knowledgePointManager;
    private TestQuestionManager testQuestionManager;
    private PolicyManager policyManager;
    private GaModle gm = null;//得到组卷系统参数
   //适应函数计算参数
    private double avgExposure=0.0;//平均曝光度，遗传得到的染色体曝光度要低于平均曝光度
    private int sumExposure =0; //总的曝光次数
    private double avgLateTime = 0.0; //在总时间所占比率的平均
    private long sumLateTimeZ = 0; //总的最近时间
    private List<List<TestQuestion>>  intiList = null; //初始种群
    List tyList=null;//题型列表
    /**
     * 根据课程的知识点与题型组成一张试题列表，此列表里放入按题型分类的试题的列表
     */
	public void intiLib(int[] knowledgePointIds,int[] typeIds){		
		intiList = null;
		intiList = new ArrayList<List<TestQuestion>>();
		List tqList = testQuestionManager.getQuestionsByIds(knowledgePointIds,typeIds);
		tyList = typeManager.getTypeByIds(typeIds);
	    for(int i=0;i< tyList.size();i++){ 
	    	List<TestQuestion> temp = new ArrayList<TestQuestion>();
	    	Type type = (Type)tyList.get(i);//获取题型
	    	for(int j=0;j<tqList.size();j++){
	    		TestQuestion tq = (TestQuestion)tqList.get(j);
	    		if(tq.getType().getId()==type.getId()){
	    			 temp.add(tq);
	    		 }
	       }
	       intiList.add(temp);
   	   }
	    
	    sumExposure = 0;
	    sumLateTimeZ = 0;
	    for(int j=0;j<tqList.size();j++){
	    	TestQuestion tq = (TestQuestion)tqList.get(j);
	    	sumExposure += tq.getCount();//进行累加，计算总的曝光次数
	    	sumLateTimeZ += tq.getLateTime().getTime();
	    }
//System.out.print("总曝光度次数"+sumExposure);
	    double tp = sumExposure/(double)tqList.size();//平均曝光次数，并转换为double类型
//System.out.print("平均曝光次数"+tp);
	    if(sumExposure!=0){
	    	avgExposure = tp/sumExposure;//平均曝光度
	    }else{
	    	avgExposure=0;
	    }
//System.out.print("平均曝光度"+avgExposure);

	    long ta = sumLateTimeZ/tqList.size();//平均最近答题时间
//System.out.print("平均最近答疑时间"+ta);
	    avgLateTime = ta/(double)sumLateTimeZ;
//System.out.print("在总时间所占比率的平均"+avgLateTime);	   
	    
    }
	
	/**
	 * 染色体的初始化，根据试题的总题量，得到染色体的长度，根据初始种群的大小，生成染色体；
	 * 染色体内题目按题型一次排列，便于进行下面的操作
	 * @return
	 */
	public List<List<TestQuestion>> ChromosomeInti(Policy p,GaModle gm){
	
		 
//System.out.print("检测参数"+gm.getId());
		//得到知识点的内容
		String kpStr = p.getKnowledgePointIds();
		int[] knowledgePointIds = null;//知识点Ids
		if(kpStr!=null&&!kpStr.trim().equals("")){
			String[] kpStrings = kpStr.split(",");
			knowledgePointIds = new int[kpStrings.length];
			for(int i=0;i<kpStrings.length;i++){
				knowledgePointIds[i] = Integer.parseInt(kpStrings[i]);
			}
		}
		
		//得到题型的具体内容
		String typeStr = p.getTypeQuantityMark();
		int[] typeIds = null;//题型Id列表
		int[] sourse=null;//题型的分数
		int[] counts=null;//每种题型的题量
		if(typeStr!=null&&!typeStr.trim().equals("")){
			String[] typeStrings = typeStr.split(",");
			int typeLength = typeStrings.length;
			typeIds = new int[typeLength/3];
			sourse = new int[typeLength/3];
			counts =new int[typeLength/3];
			for(int i=0,j=0;i<typeLength;i+=3,j++){
				typeIds[j] = Integer.parseInt(typeStrings[i]);
				sourse[j] = Integer.parseInt(typeStrings[i+1]);
				counts[j] = Integer.parseInt(typeStrings[i+2]);
			}
		}					
		/*
		 * 染色体的初始化
		 */
		
		intiLib(knowledgePointIds,typeIds); //初始种群
		List<List<TestQuestion>> chromosomeList = new ArrayList<List<TestQuestion>>();//染色体的列表	
		for(int i=0;i<gm.getPopulation()*2;i++){//根据系统规定的染色体的数量的两倍进行循环，来产生种群
			List<TestQuestion> tqList = new ArrayList<TestQuestion>();//一个染色体
//System.out.println("检测生成的随机数");			
			for(int j=0;j<intiList.size();j++){//根据题型去取试题
				List<TestQuestion> tqTypeList =intiList.get(j);//得到第一种题型的所有试题
				int[] random = RandomNo.getRandomList(tqTypeList.size(),i);//产生一个从0到tqTypeList.size()-1的随机数组，我们取前面几个加入到染色体内
//System.out.println("检测参数======》"+counts[j]+"("+counts.length+")");
				for(int k=0;k<counts[j];k++){//根据该种题型在染色体内所占的题量加入
					TestQuestion tq = tqTypeList.get(random[k]);
					tqList.add(tq);
				}	
				
			}
			chromosomeList.add(tqList);//把一个染色体加入到染色体列表
			
		}
		return chromosomeList;
	}
	
	
	/**
	 * 求染色体的适应值
	 */
	public int getAdaptive(List<TestQuestion> qsList,Policy p){
		
		double errorD = 0.0;//难度误差
		double errorDt = 0.0;//区分度误差
		double errorKp = 0.0;//知识点误差
		double errorLateTime = 0.0;//最近出题时间误差
		double errorExposure = 0.0;//曝光度误差
		double errorTime = 0.0;//总的考试时间误差
		
		double sumD = 0.0;//试题的难度和
		double sumDt = 0.0;//区分度的和
		double sumTime = 0.0;//考试时间和
		double sumEx = 0.0;//总的曝光度
		long sumLateTime = 0;//总的最近答题时间
	
		
		int length = qsList.size();//染色体长度
		for(int i=0;i<length;i++){
			TestQuestion t = qsList.get(i);
			
			sumD += t.getDifficulty();
			sumDt += t.getDifferentiate();
			sumTime += t.getAdviceTime();
			sumEx += t.getCount()/(double)sumExposure;
			sumLateTime += t.getLateTime().getTime();
		}

		/**
		 *  public static double abs(double a)
返回 double 值的绝对值。如果参数是非负数，则返回该参数。如果参数是负数，则返回该参数的相反数。特殊情况是：
如果参数是正零或负零，那么结果是正零。
如果参数是无穷大，那么结果是正无穷大。
如果参数是 NaN，那么结果就是 NaN。
		*/


		errorD = Math.abs(sumD/length - p.getDifficulty());//计算难度误差
	
		errorDt = Math.abs(sumDt/length - p.getDifferentiate());
		errorTime = Math.abs(sumTime/p.getTime()-1);
//测试参数
//System.out.println("测试参数");
//System.out.println("难度误差"+errorD);
//System.out.println("区分度误差"+errorDt);
//System.out.println("总的曝光度"+sumEx);		
//System.out.println("答题时间误差"+errorTime);	
		double thisAvgEx =0.0;
		if(sumEx!=0){
			thisAvgEx = sumEx/length;
		}else{
			thisAvgEx = 0;
		}
		if(thisAvgEx>avgExposure){
			errorExposure = thisAvgEx - avgExposure;//比平均曝光度大多少
		}else{
			errorExposure = 0.0;//如果小于平均曝光度，那么该染色体的曝光误差就为0
		}	
//System.out.println("曝光度误差"+errorExposure);		
		
		double avgS = sumLateTime/(double)sumLateTimeZ/(double)length;
		if(avgS>avgLateTime){
			errorLateTime = avgS - avgLateTime;
		}else
		{
			errorLateTime = 0.0;
		}
		
//System.out.println("平均最近答题时间比率误差"+errorLateTime);

	//计算知识点误差
		String chapterStr  = p.getChapterIdInverse();
		int[] chapterIds = null;//章节Ids
		int[] ratio = null;
		if(chapterStr!=null&&!chapterStr.trim().equals("")){
			String[] kpStrings = chapterStr.split(",");
			chapterIds = new int[kpStrings.length/2];
			ratio = new int[kpStrings.length/2];
			for(int i=0,j=0;i<kpStrings.length;j++,i+=2){
				chapterIds[j] = Integer.parseInt(kpStrings[i]);
				ratio[j] = Integer.parseInt(kpStrings[i+1]);
			}

		}
		
		double factor = 0.0;
		for(int i=0;i<qsList.size();i++){//计算总的赋分因子
			TestQuestion qs = qsList.get(i);
			factor += qs.getDifficulty()*15+qs.getAdviceTime();
		}
		
		
		for(int i=0;i<chapterIds.length;i++){
			double fa=0.0;
			for(int j=0;j<qsList.size();j++){
				if(chapterIds[i]==qsList.get(j).getChapter().getId()){
					TestQuestion qs = qsList.get(i);
					fa += qs.getDifficulty()*15+qs.getAdviceTime();
				}
			}
			double ra = fa/factor;//在题的赋分因子在总的试题赋分因子的比率
			double errorX = Math.abs(ra-ratio[i]/(double)100);//某一章的误差
			errorKp += errorX;//总误差
		}

	
	//函数适应值得计算 我们把适应值放大十万倍，然后去掉其小数部分，即转化为整型
	int fitenessAll = (int)((errorD+errorDt+errorKp+errorLateTime+errorExposure+errorTime)*100000);
  //  System.out.println("该染色体的适应值（适应值越小误差越小）"+fitenessAll);//适应值越小误差越小
	
	return fitenessAll;
	}

	
/**
 * 根据染色体的适应值，对染色进行排序
 */	
	public void sortChr(List<List<TestQuestion>>  chromosomeList){
		Policy p = policyManager.getPolicyById(1);
		int[] fitnesses = new int[chromosomeList.size()];//先把适应值存到数组中，这样就不用再排序的使用总是计算适应值了
		for(int i=0;i<chromosomeList.size();i++){
			fitnesses[i] = getAdaptive(chromosomeList.get(i),p); 
		}
		//我们采用快速排序法
		sort(fitnesses,chromosomeList,0,fitnesses.length-1);
	}

	/**
	 * 快速排序，从左往右，升序排列
	 **/
	private void sort(int[] number,List<List<TestQuestion>>  chromosomeList,int left,int right){
		if(left<right)
	    {
	      
	      int s=number[left];
	      int a = left;
	      int i=left;
	      int j=right+1;
	      while(true)
	      {
	        //令索引 i 從數列左方往右方找，直到找到大於 s 的數
	        while(i+1<number.length &&number[++i]<s);
	        //令索引 j 從數列右方往左方找，直到找到小於 s 的數
	        while(j>0&&number[--j]>s);
	        if(i>=j) break; //如果 i >= j，則離開迴圈
	        swap(number,chromosomeList,i,j);//如果 i < j，則交換索引i與j兩處的值，将大于 s 的数放在后面

	      }
	      //将左侧轴与j交换
	      number[left]=number[j];
	      number[j]=s;
	      List<TestQuestion> tqLista = chromosomeList.get(a);
		  List<TestQuestion> tqListj = chromosomeList.get(j);
		  chromosomeList.set(a, tqListj);
		  chromosomeList.set(j, tqLista);
	      
	      sort(number,chromosomeList,left,j-1);//轴左边进行递归

		  sort(number,chromosomeList,j+1,right);//轴右边进行递归

	   }
	  }


	/**
	 * 快速排序，从左往右，降序排列；List<TestQuestion>是试卷染色体，List<List<TestQuestion>>是种群

	 private void sort(int[] number,List<List<TestQuestion>>  chromosomeList,int left,int right){
	 if(left<right)
	 {

	 int s=number[left];
	 int a = left;
	 int i=left;
	 int j=right+1;
	 while(true)
	 {
	 //令索引 i 從數列左方往右方找，直到找到小於 s 的數
	 while(i+1<number.length &&number[++i]>s);
	 //令索引 j 從數列右方往左方找，直到找到大於 s 的數
	 while(j>0&&number[--j]<s);
	 if(i>=j) break; //如果 i >= j，則離開迴圈
	 swap(number,chromosomeList,i,j);//如果 i < j，則交換索引i與j兩處的值，将小于 s 的数放在后面

	 }
	 //将左侧轴与j交换
	 number[left]=number[j];
	 number[j]=s;
	 List<TestQuestion> tqLista = chromosomeList.get(a);
	 List<TestQuestion> tqListj = chromosomeList.get(j);
	 chromosomeList.set(a, tqListj);
	 chromosomeList.set(j, tqLista);

	 sort(number,chromosomeList,left,j-1);//轴左边进行递归

	 sort(number,chromosomeList,j+1,right);//轴右边进行递归

	 }
	 }
	 **/
	private static void swap(int[] number,List<List<TestQuestion>>  chromosomeList,int i, int j) {
	    int t;
	    t=number[i];
	    number[i]=number[j];
	    number[j]=t;
	    //适应度交换后，染色体也进行交换
//System.out.print("第"+i+"个与"+j+"交换");
	    List<TestQuestion> tqListi = chromosomeList.get(i);
	    List<TestQuestion> tqListj = chromosomeList.get(j);
	    chromosomeList.set(i, tqListj);
	    chromosomeList.set(j, tqListi);
	 }
	
	
	/**
	 * 交叉函数
	 */
	public void crossDo(List<List<TestQuestion>>  chromosomeList){
		Random ra = new Random();
		int length = chromosomeList.size();
		for(int i=0;i<chromosomeList.size();i++){
			if(gm.getCrossoverPossibility()<ra.nextInt(100)/(double)100){
				crossGe(chromosomeList,length);
			}
		}
	}
	/**
	 * 交叉的实现
	 * @param chromosomeList
	 * @param size
	 */
	private void crossGe(List<List<TestQuestion>>  chromosomeList,int size){
		
		Random ra = new Random();
		/**
		Random ra =new Random();
		for (int i=0;i<30;i++)
		{System.out.println(ra.nextInt(10)+1);}
		通过java.util包中的Random类的nextInt方法来得到1-10的int随机数
		 */
		List<TestQuestion> tqList1 = chromosomeList.get(ra.nextInt(size));
		List<TestQuestion> tqList2 = chromosomeList.get(ra.nextInt(size));
		
		for(int i=0;i<tqList1.size();i++){
			if(ra.nextInt(100)/(double)100<0.3){//百分之30的数据进行交换
				TestQuestion tq1 = tqList1.get(i);
				TestQuestion tq2 = tqList2.get(i);
				
				int state = 0;
				for(int j=0;j<tqList1.size();j++){
					if(tq1.getId()==tqList2.get(j).getId()){
						state=1;
						break;
					}
					if(tq2.getId()==tqList1.get(j).getId()){
						state=1;
						break;
					}
				}
				if(state==0){
					tqList1.set(i, tq2);
					tqList2.set(i, tq1);
				}else{
					i--;//如果取到的试题不符合，我们继续去初始化题库去取
				}
				
			}
		}
		
	}

	/**
	 * 变异函数
	 */
	public void mutationDo(List<List<TestQuestion>>  chromosomeList){
		Random ra = new Random();
		int length = chromosomeList.size();
		for(int i=0;i<chromosomeList.size();i++){
			if(gm.getMutationPossibility()<ra.nextInt(100)/(double)100){
				mutationGe(chromosomeList,length);
			}
		}
	}
	/**
	 *变异的实现
	 * @param chromosomeList
	 * @param size
	 */
	private void mutationGe(List<List<TestQuestion>>  chromosomeList,int size){
		Random ra = new Random();
		int length = chromosomeList.size();
		List<TestQuestion> tqList1 = chromosomeList.get(ra.nextInt(size));//随机选出一个染色体进行变异
		for(int i=0;i<tqList1.size();i++){
			
			if(ra.nextInt(100)/(double)100<0.2){//被随机选中的染色体的20%的数据进行变异
				TestQuestion tq1 = tqList1.get(i);
				TestQuestion tq2 = null;
				//这个循环根据试题类型，去初始化题库里去取符合该类型的试题
				for(int j=0;j<tyList.size();j++){
					Type type = (Type)tyList.get(j);
					if(tq1.getType().getId()==type.getId()){
						List<TestQuestion> tqList2= intiList.get(j);
						tq2 = tqList2.get(ra.nextInt(tqList2.size()));//得到替换的试题
					}	
				}
				//判断该试题中此染色体里是否存在，如果存在，那么就不需要此试题，再去初始化题库寻找新的试题
				int state = 0;
				for(int j=0;j<tqList1.size();j++){
					if(tq1.getId()==tq2.getId()){
						state=1;
						break;
					}
				}
				
				if(state==0){
					tqList1.set(i, tq2);
				}else{
					i--;//如果取到的试题不符合，我们继续去初始化题库去取
				}
				
				
			}
		}
	}
	
	
	/**
	 * 智能组卷算法
	 */
	public List<TestQuestion> gaStart(Policy p) {
		
  		System.out.println(p.getKnowledgePointIds());

		gm = gaModleManager.getGamodleByState();//得到组卷系统参数
		List<List<TestQuestion>>  chromosomeList = ChromosomeInti(p,gm);//染色体的初始化
		sortChr(chromosomeList);//把初始化两倍的染色体进行排序



		int a = (chromosomeList.size()+1)/2;//染色体长度的一半
		for(int i=chromosomeList.size()-1;i>=a;i--){//移除染体的后半部分，得到染色前半部分，这部分等于系统规定的染色体数量
			chromosomeList.remove(i);
		}
		
		List<List<TestQuestion>>  chromosomeListParant = new ArrayList<List<TestQuestion>>();;//这个是父类种群
		chromosomeListParant.addAll(chromosomeList);//保存父类种群


		
		int i=0;
		while(i<gm.getGeneration()){
			
			crossDo(chromosomeList);//交叉
			mutationDo(chromosomeList);//变异
			chromosomeList.addAll(chromosomeListParant);//子代和父代合并
/*
			for(int j=0;j<chromosomeList.size();j++ ) {
				System.out.println("排序前适应值：" + getAdaptive(chromosomeList.get(j), p));
			}
			*/
			sortChr(chromosomeList);//对合并后的染色体排序
/*
			for(int j=0;j<chromosomeList.size();j++ ) {
				System.out.println("排序后适应值：" + getAdaptive(chromosomeList.get(j), p));
			}
*/

System.out.println("合并后的长度"+chromosomeList.size());			
			for(int j=chromosomeList.size()-1;j>=a;j--){//移除染体的后半部分，得到染色前半部分，这部分等于系统规定的染色体数量
				System.out.println("第"+j+"移除");
				chromosomeList.remove(j);

			}		
System.out.println("移除后的长度"+chromosomeList.size());	

			chromosomeListParant.clear();//清空列表
			chromosomeListParant.addAll(chromosomeList);//保存父类种群

		//	System.out.println("适应值："+getAdaptive(chromosomeList.get(i),p));//一个假设种群里有100个体，即200染色体

			System.out.println("代数==》"+i);	
			i++;
		}



		return chromosomeList.get(0);
	}



	/**
	 * 这应该是遗传算法测试函数，测试的时候，进行调用
	 */
	public void testChromosomeList(){
		gm = gaModleManager.getGamodleByState();//得到组卷系统参数
		Policy p = policyManager.getPolicyById(7);//获得测试的组卷策略
		List<List<TestQuestion>>  chromosomeList = ChromosomeInti(p,gm) ;
		
		
		for(int i=0;i<chromosomeList.size();i++ ){
				
				List<TestQuestion> tqList = chromosomeList.get(i);
				//System.out.println("第"+(i+1)+"个染色体");
			for(int j=0;j<tqList.size();j++){
				TestQuestion tq = tqList.get(j);
				//System.out.print(tq.getId()+"|");
				//System.out.print(tq.getType().getName()+",");
			}
			//System.out.println();
		}
		
		for(int i=0;i<chromosomeList.size();i++ ){
			System.out.println("排序前适应值："+getAdaptive(chromosomeList.get(i),p));
		}
		crossDo(chromosomeList);//交叉
		for(int i=0;i<chromosomeList.size();i++ ){
			System.out.println("交叉后适应值："+getAdaptive(chromosomeList.get(i),p));
		}
		mutationDo(chromosomeList);//变异
		for(int i=0;i<chromosomeList.size();i++ ){
			System.out.println("变异后适应值："+getAdaptive(chromosomeList.get(i),p));
		}
System.out.println("染色的个数"+chromosomeList.size());		
		sortChr(chromosomeList);
		for(int i=0;i<chromosomeList.size();i++ ){
			System.out.println("排序后适应值："+getAdaptive(chromosomeList.get(i),p));
		}
		
		
	}
	
	
	
	public GaModleManager getGaModleManager() {
		return gaModleManager;
	}


	public void setGaModleManager(GaModleManager gaModleManager) {
		this.gaModleManager = gaModleManager;
	}


	public TypeManager getTypeManager() {
		return typeManager;
	}


	public void setTypeManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}


	public TestQuestionManager getTestQuestionManager() {
		return testQuestionManager;
	}


	public void setTestQuestionManager(TestQuestionManager testQuestionManager) {
		this.testQuestionManager = testQuestionManager;
	}

	public KnowledgePointManager getKnowledgePointManager() {
		return knowledgePointManager;
	}

	public void setKnowledgePointManager(KnowledgePointManager knowledgePointManager) {
		this.knowledgePointManager = knowledgePointManager;
	}

	public PolicyManager getPolicyManager() {
		return policyManager;
	}

	public void setPolicyManager(PolicyManager policyManager) {
		this.policyManager = policyManager;
	}











}
