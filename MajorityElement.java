//brute force

/*public class MajorityElement {
     public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;
        for(int i = 0; i<nums.length; i++){
            int count = 0;
        
        for(int j = 0; j<nums.length; j++){
            if(nums[j] == nums[i]){
                count++;
            }
        }
        if(count > majorityCount){
            return nums[i];
        }
    }
     return -1;

}
}

//divide and conqure
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int freq = 1, ans = nums[0];
        for(int i = 1; i< n; i++){
            if(nums[i] == nums[i-1]){
                freq++;

            }else{
                freq =1; 
                ans = nums[i];

            }
            if(freq > n/2){
                return ans;
            }
            
        }
        return ans;

    }
}
    */