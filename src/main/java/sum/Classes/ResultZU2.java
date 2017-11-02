package sum.Classes;

public class ResultZU2 extends Result {

    @Override
    public void sum(Binary first, Binary second) {
        int k = first.getDigit(32);
        a = checkSign(first,k).getBinary();
        b = checkSign(second,k).getBinary();
        calculation(a,b);
    }

    @Override
    public Binary checkSign(Binary a,int i){
        if (a.getDigit(31) == 1) {
            a.revertToZU2Binary(i);
        }
        return a;
    }

    public ResultZU2(Binary a, Binary b) {
        super(a, b);
    }


}
