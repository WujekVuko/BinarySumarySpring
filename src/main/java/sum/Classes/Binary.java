package sum.Classes;

/** Ta klasa konwertuje liczbę dziesiętną na binarną
 * liczby binarne są zapisane w tablicy od tyłu - jeżeli liczba ma wyglądać 1.011 to jest zapisana:
 * binary[0]=1 binary[1]=1 binary[2]=0 binary[31]=1, oraz binary[32] zapisujące ile elementów tablicy zostało zmienionych
 */

public class Binary implements Cloneable {
    private int[] binary = new int[33];
    public int[] getBinary(){return binary;}
    public void setBinary(int[] binary) {
        this.binary = binary;
    }
    int getDigit(int i){return binary[i];}

    /** metoda zamienia liczbę binarną w kodzie ZM na liczbę binarną w kodzie ZU1
     * @param i - liczba elementów tablicy, które należy zmienić
     */
    void revertToZU1Binary(int i) {
        for (int k = i; k >= 0; k--) {
            binary[k] = binary[k] == 1 ? 0 : 1;
        }
    }

    /** metoda zamienia liczbę binarną w kodzie ZM na liczbę binarną w kodzie ZU2
     * @param i - liczba elementów tablicy, które należy zmienić
     */
    void revertToZU2Binary(int i) {
        binary = this.getBinary();
        boolean z = false;
        for (int k = 0; k <= i; k++) {
            if (z) {
                binary[k] = binary[k] == 1 ? 0 : 1;
            } else if (binary[k] == 1) {
                z = true;
            }
        }

    }

    /** metoda klonuje obiekty klasy binary
     * @return - zwraca klon zadanego obiektu
     * @throws CloneNotSupportedException -
     */
    public Binary clone() throws CloneNotSupportedException{
        Binary cloned = (Binary) super.clone();
        cloned.binary = binary.clone();
        return cloned;
    }

    /** metoda sprawdza znak liczby i jeżeli jest ujemna zamienia binary[31] na wartość 1
     * następne zamienia liczbę dziesiętną na binarną wpisując ją w tablicę
     * @param decimal - liczba w formie dziesiętnej do zmiany
     */
    public void calcBinary(int decimal){
        if(decimal < 0){
            binary[31] = 1;
            decimal *= -1;
        }
        int i = 0;
        while (decimal > 0) {
            binary[i] = decimal % 2;
            decimal /= 2;
            i++;
        }
        binary[32] = i;
    }

    public Binary(){}
    public Binary(int decimal){
        calcBinary(decimal);
    }
}
