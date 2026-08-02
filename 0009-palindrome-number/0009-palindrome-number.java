class Solution {
    public boolean isPalindrome(int x) {
        int copy1 = x;
        int copy2 = x;
        if(copy1<0){
            return false;
        }
        int count = 0;
        while(copy1!=0){
            count++;
            copy1/=10;
        }
        int finalAns = 0;
        while(copy2!=0){
            int digit = copy2 % 10;
            int power = digit * (int)(Math.pow(10,count-1));
            finalAns += power;
            count--;
            copy2 /= 10;
        }
        if(x==finalAns){
            return true;
        }else{
            return false;
        }
    }
}