class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ans="";
        String x=str1+str2;
        String y=str2+str1;
        if(!x.equals(y)){
            return ans;
        }
        int n=str1.length();
        int m=str2.length();
        int gcd=gcd(n,m);
        return str1.substring(0,gcd);



    }
    public int gcd(int x,int y){

        if(x>y){
            return gcd(x-y,y);
        }
        else if(x<y){
            return gcd(x,y-x);
        }else{
            return x;
        }
    }
}