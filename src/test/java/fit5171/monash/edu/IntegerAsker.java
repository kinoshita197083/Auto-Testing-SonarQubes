package test.java.fit5171.monash.edu;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IntegerAsker {

    public IntegerAsker(Scanner scanner, PrintStream out){
        this.scanner = scanner;
        this.out = out;
    };

    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
