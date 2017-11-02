package sum.Classes;

/** Klasa sumuje liczby w kodzie binarnym
 *
 */

public class Result {
    int[] sum = new int[33];
    int[] a;
    int[] b;

    public void sum(Binary first, Binary second) {
        int k = first.getDigit(32);
        a = first.getBinary();
        b = first.getDigit(31) != second.getDigit(31) ? checkSign(second, k).getBinary() : second.getBinary();
        calculation(a,b);
    }

    /** metoda sumuje dwie liczby binarne dodając do siebie odpowiadające sobie elementy tablicy
     * @param a - wartość liczby bezwględnie większej jako tablica
     * @param b - wartość liczby bezwględnie mniejszej jako tablica
     */
    void calculation(int[] a, int[] b){
        int i = a[32];
        sum[32] = a[32];
        int l = 0;
        for (int j = 0; j <= i; j++) {
            sum[j] += l;
            if (a[j] + b[j] + sum[j] == 0) {
                sum[j] = 0;
            } else if (a[j] + b[j] + sum[j] == 1) {
                sum[j] = 1;
                l = 0;
            } else if (a[j] + b[j] + sum[j] == 2) {
                sum[j] = 0;
                l = 1;
            } else {
                sum[j] = 1;
                l = 1;
            }
        }
        setSign();
    }

    /** Liczby przyjmują różne kodowania(ZM,ZU1,ZU2) tylko dla wartości ujemnych
     *
     * @param a liczba w kodzie binarnym ZM
     * @param i - liczba elementów tablicy do zmiany
     * @return - zwraca zmienioną liczbe w kodzie binarnym ZM na ZU2
     */
    Binary checkSign(Binary a, int i){
        a.revertToZU2Binary(i);
        return a;
    }

    /** ustala znak dla wyniku
     */
    public void setSign (){sum[31] = a[31];}

    public int getDigit(int i){return sum[i];}

    public Result(Binary a, Binary b) {
        sum(a, b);
    }
}

