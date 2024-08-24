class Solution {
    public int hammingDistance(int x, int y) {
        int val=x^y;
        int count=0;
        while(val!=0){
            if((val & 1)==1)count++;
            val/=2;
        }
        return count;
    }
}