package sum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sum.Classes.*;

import java.util.Scanner;

public class MainSpring {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner in = new Scanner(System.in);
        Scanner ina = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę całkowitą: ");
        int a = in.nextInt();
        System.out.println("Podaj działanie (dodawanie: +; odejmowanie: -): ");
        String symbol = ina.nextLine();
        // jeżeli działanie jest odejmowaniem to druga liczba zmieni znak
        int modulus = 1;
        if (symbol.equals("-")) {
            modulus = -1;
        }
        System.out.println("Podaj drugą liczbę całkowitą: ");
        int b = in.nextInt() * modulus;

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Binary first = context.getBean("first", Binary.class);
        Binary second = context.getBean("second",Binary.class);
        if(Math.abs(a) > Math.abs(b)){ first.calcBinary(a); second.calcBinary(b);}
        else{first.calcBinary(b);second.calcBinary(a);}

        Result sumzm = context.getBean("sumZM", Result.class);
        sumzm.sum(first.clone(),second.clone());

        PrinterImpl printZM = context.getBean("printZM", PrinterImpl.class);
        printZM.print(sumzm,"ZM");

        ResultZU1 sumzu1 = context.getBean("sumZU1", ResultZU1.class);
        sumzu1.sum(first.clone(),second.clone());

        PrinterImpl printZU1 = context.getBean("printZU1", PrinterImpl.class);
        printZU1.print(sumzu1,"ZU1");

        ResultZU2 sumZU2 = context.getBean("sumZU2",ResultZU2.class);
        sumZU2.sum(first,second);

        PrinterImpl printZU2 = context.getBean("printZU2", PrinterImpl.class);
        printZU2.print(sumZU2,"ZU2");

    }

}
