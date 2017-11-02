package sum.Classes;



public class PrinterImpl {
  public PrinterImpl(Result result, String s) {
      Result z = result;
      String a = s;
      print(z, a);
  }
  public void print(Result z, String a) {
      if (z.getDigit(32) != 0) {
          System.out.print("Wynik działania w kodzie " + a + ": " + z.getDigit(31) + ".");
          for (int i = z.getDigit(32); i >= 0; i--) {
              System.out.print(z.getDigit(i));
          }
          System.out.println();
      }
  }
}
