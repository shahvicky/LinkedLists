//house-robber-ii, leetcode dynamic programming
public class HouseRobber2 {

	public static void main(String[] args) {
		

	}
	
	class Solution {
	    public int rob(int[] nums) {
	        if(nums.length == 0) {
	            return 0;
	        } else if(nums.length == 1) {
	            return nums[0];
	        } else if(nums.length == 2)   {
	            return Math.max(nums[0],nums[1]);
	        } else {
	            int ans1 = 0, ans2 = 0;
	            int[] max1 = new int[nums.length];
	            int[] max2 = new int[nums.length+1];
	            max1[0] = 0;
	            for(int i=1; i<max1.length; i++){
	                if(i==1 || i==2) {
	                    max1[i] = nums[i-1];
	                } else {
	                    max1[i] = Math.max(nums[i-1]+max1[i-2],nums[i-1]+max1[i-3]);
	                }
	                ans1 = Math.max(max1[i],ans1);
	            }
	            max2[0] = 0;
	            max2[1] = 0;
	            for(int i=2; i<max2.length; i++){
	                if(i==2 || i==3) {
	                    max2[i] = nums[i-1];
	                } else {
	                    max2[i] = Math.max(nums[i-1]+max2[i-2],nums[i-1]+max2[i-3]);
	                }
	                ans2 = Math.max(max2[i],ans2);
	            }
	            
	            return Math.max(ans1,ans2);
	            
	        }
	        
	    }
	}

}
