package expression.generic;

public class main {
    public static void main(String[] args) throws Exception{
        GenericTabulator g = new GenericTabulator();
        Object[][][] a = g.tabulate("d", "y / z", -10, 16, -17, 5, -16, 15);
        System.out.println("lOL");
    }
}
