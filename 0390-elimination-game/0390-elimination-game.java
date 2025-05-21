class Solution {
    public int lastRemaining(int n) {
       //(1) // 1 2 3 4 5 6 7 8 9 10 11 12 // remaining=12,head=1,step=1,left=true then head+=step
       //(2) //2,4,6,8,10,12 // remainiing=12/2=6,reaming%2==0,left=false then head does not change,step*=2;
       //(2) //2,4,6,8,10 // remaining%2==1,left=false,head+=step
       //(3)//2,6,10 same as step(1)
       //(4)//6
        int remaining=n;
        int step=1,head=1;
        boolean left=true;
        while(remaining>1)
        {
            if(left || remaining%2==1)
            {
                head+=step;
            }
            step*=2;
            remaining/=2;
            left=!left;
        }
        return head;
    }
}