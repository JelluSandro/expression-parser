package expression;

import expression.generic.GenericTabulator;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("found not 2 arguments");
            return;
        }
        int x1 = -2, y1 = -2, z1 = -2;
        int x2 = 2, y2 = 2, z2 = 2;
        GenericTabulator g = new GenericTabulator();
        Object[][][] tabulate = g.tabulate(args[0], args[1], x1, x2, y1, y2, z1, z2);
        for (int i = 0; i <= (x2 - x1); i++) {
            for (int j = 0; j <= (y2 - y1); j++) {
                for (int k = 0; k <= (z2 - z1); k++) {
                    System.out.println(tabulate[i][j][k]);
                }
            }
        }
    }
}