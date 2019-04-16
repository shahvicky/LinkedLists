import java.math.BigInteger;
import java.util.*;
public class LargestConsecutiveSequence{
	
  public static int max(int x, int y, int z){
  	return (x>y?(x>z?x:z):(y>z?y:z));
  }
  
  public static int max(int x, int y){
  	return (x>y?x:y);
  }
  
  public static void main(String[] args){
  	//System.out.print("HIIIII");
    int[] arr = {8,9,4,5,17,18,6,1,7,2,3};
    
    BigInteger b = new BigInteger(String.valueOf(82));
    System.out.println("*****************"+b.nextProbablePrime());
    int test = b.intValue();
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    boolean lessFlag = false, moreFlag = false;
    for(int i=0; i<arr.length; i++){
      
      map.put(arr[i],1);
    	
      if(map.containsKey(arr[i]-1)){
      	lessFlag = true;
      }
      if(map.containsKey(arr[i]+1)){
      	moreFlag = true;
      }
      if(lessFlag && moreFlag){
      	//int count = 2+ max(map.get(arr[i]),map.get(arr[i]-1),map.get(arr[i]+1));
        int count = map.get(arr[i])+ map.get(arr[i]-1)+ map.get(arr[i]+1);
        map.put(arr[i],count);
        map.put(arr[i]+1,count);
        map.put(arr[i]-1,count);
        lessFlag = false;
        moreFlag = false;
      }
      else if(!lessFlag && moreFlag){
      	//int count = 1+ max(map.get(arr[i]),map.get(arr[i]+1));
        int count = map.get(arr[i])+ map.get(arr[i]+1);
        map.put(arr[i],count);
        map.put(arr[i]+1,count);
        moreFlag = false;
      }
      else if(lessFlag && !moreFlag){
      	//int count = 1+ max(map.get(arr[i]),map.get(arr[i]-1));
        int count = map.get(arr[i])+ map.get(arr[i]-1);
        map.put(arr[i],count);
        map.put(arr[i]-1,count);
        lessFlag = false;
      }
      for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        System.out.println(entry.getKey()+" -> "+entry.getValue());
      }
      System.out.println("****************************");
    }
    
    int max_count = 1;
    
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
      System.out.println(entry.getKey()+" -> "+entry.getValue());
      if(entry.getValue()>max_count){
      	max_count = entry.getValue();
      }
    }
    
    System.out.print(max_count);
    
  }
}