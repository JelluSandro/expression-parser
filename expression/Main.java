package expression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).evaluate(5));
        System.out.println(new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).toString());
        System.out.println(new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).toMiniString());
        System.out.println(new Multiply(new Const(2), new Variable("x"))
                .equals(new Multiply(new Const(2), new Variable("x")))
        );
        System.out.println(new Multiply(new Const(2), new Variable("x"))
                .equals(new Multiply(new Variable("x"), new Const(2)))
        );
        CommonOperation exp = new Add(
                new Subtract(
                        new Multiply(
                                new Variable("x"),new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))
                ),new Const(1));
        System.out.println(exp.toMiniString());
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(exp.evaluate(x));
    }
}
