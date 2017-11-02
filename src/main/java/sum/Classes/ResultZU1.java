package sum.Classes;

public class ResultZU1 extends Result {
    @Override
    public void sum(Binary first, Binary second) {
        int k = first.getDigit(32);
        a = checkSign(first,k).getBinary();
        b = checkSign(second,k).getBinary();
        calculation(a,b);
    }
    @Override
    public void setSign() {
        int l = 0;
        int i = a[32];
        sum[31] = (a[31] + b[31] + l) % 2 == 0? 0: 1;
        l += a[31] + b[31] > 1? 1:0;

        if (l > 0) {
            l = 1;

            for (int j = 0; j <= i; j++) {
                sum[j] += l;
                if (sum[j] == 0) {
                    sum[j] = 0;
                } else if (sum[j] == 1) {
                    sum[j] = 1;
                    l = 0;
                } else if (sum[j] == 2) {
                    sum[j] = 0;
                    l = 1;
                } else {
                    sum[j] = 1;
                    l = 1;
                }

            }

        }

    }
    @Override
    public Binary checkSign(Binary a,int i){
        if (a.getDigit(31) == 1) {
            a.revertToZU1Binary(i);
        }
        return a;
    }

    public ResultZU1(Binary a, Binary b) {
        super(a,b);
    }
}
