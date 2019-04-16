import java.util.*;
import java.math.*;

public class KDifference{
  public static void main(String[] args){
    int[] nums = {1,2,4,7};
	int k = 2;
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    for(int i=0; i<nums.length; i++){
      for(int j=i+1; j<nums.length; j++){
      	int diff = Math.abs(nums[i]-nums[j]);
        
        list.add(diff);
        }
      }
    int count = 1;
    Collections.sort(list);
    for(int value:list){
      if(count == k){
      	System.out.print(value+" ");
      }
      count++;
    	
    }    
    
  }
}