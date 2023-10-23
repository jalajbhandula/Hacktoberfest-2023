class Solution {
    public int maximumScore(int[] nums, int k) {
        int result=0;

        Stack<int[]> leftStack=new Stack<>();

        Stack<int[]> rightStack=new Stack<>();


        int i=k;
        
        while(i<nums.length){
            int minimumValue=nums[i];
            int j=i;
            while(j<nums.length && nums[j]>=minimumValue){
                j++;
            }
            rightStack.push(new int[]{nums[i],j-1});
            i=j;
        }

        i=k;
        
        while(i>=0){
            int minimumValue=nums[i];
            int j=i;
            while(j>=0 && nums[j]>=minimumValue){
                j--;
            }
            leftStack.push(new int[]{nums[i],j+1});
            i=j;
        }

        while(!leftStack.isEmpty() && !rightStack.isEmpty()){
            int[] leftArray=leftStack.peek();
            int[] rightArray=rightStack.peek();

            int left=leftArray[0];
            i=leftArray[1];

            int right=rightArray[0];
            int j=rightArray[1];

            if(left>right){
                rightStack.pop();
                result=Math.max(result,right*(j-i+1));
            }else if(left==right){
                leftStack.pop();
                rightStack.pop();
                result=Math.max(result,right*(j-i+1));
            }else{
                leftStack.pop();
                result=Math.max(result,left*(j-i+1));
            }
        }

        return result;
    }
}
