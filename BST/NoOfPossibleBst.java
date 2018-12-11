class NoOfPossibleBst {

    int CountFunc(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for(int i=1; i<=n; i++) {
            int left = CountFunc(i-1);
            int right = CountFunc(n-i);
            sum = sum + left*right;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        NoOfPossibleBst obj = new NoOfPossibleBst();
        int res = obj.CountFunc(n);
        System.out.println(res);
    }
} 
