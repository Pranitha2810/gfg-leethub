class ProductOfNumbers {
    ArrayList<Integer> l;
    public ProductOfNumbers() {
        l = new ArrayList<>();
    }
    
    public void add(int num) {
        l.add(num);
    }
    
    public int getProduct(int k) {
        int n=l.size();
        int ans=1;
        for(int i=0;i<k;i++)
        {
           ans = ans*l.get(n-i-1);
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */