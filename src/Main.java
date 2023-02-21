import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Hello " + args[0]);

        System.out.println("Введите х: ");
        double x = sc.nextInt();
        System.out.println("Введите y: ");
        double y = sc.nextInt();
        double gg = (double) ((3*Math.pow(Math.cos(x-(Math.PI/6)),2))/((1/2)+Math.sin(Math.pow(y,2))));
        System.out.println("x = " + x +"\n" + "y = " + y +"\n" + "otvet = " + gg);

        double phi;
        double n;
        double a;
        double a0;
        double a1;
        double a2;
        double b;
        double c;
        double d;

        System.out.println("Привет " + args[0] + "\n" + "Номер варианта: " + args[1] + "\n" + "a = " + args[2] + "\n" + "b = " + args[3] + "\n" + "c = " + args[4] + "\n" + "n = " + args[5] + "\n" + "x = " + args[6]);
        a = Double.parseDouble(args[2]);
        b = Double.parseDouble(args[3]);
        c = Double.parseDouble(args[4]);
        n = Double.parseDouble(args[5]);
        x = Double.parseDouble(args[6]);
        double one = ((5 * Math.pow(a, n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.cos(Math.pow(x,3)))));
        System.out.println(one + "\n");

        System.out.println("Привет " + args[7] + "\n" + "Номер варианта: " + args[8] + "\n" + "a = " + args[9] + "\n" + "x = " + args[10] + "\n" + "y = " + args[11] + "\n" + "phi = " + args[12]);
        a = Double.parseDouble(args[9]);
        x = Double.parseDouble(args[10]);
        y = Double.parseDouble(args[11]);
        phi = Double.parseDouble(args[12]);
        double two = ((Math.abs(x - y) / Math.pow((1 + 2 * x), a)) - Math.pow(Math.E, Math.sqrt(1 + phi)));
        System.out.println(two + "\n");

        System.out.println("Привет " + args[13] + "\n" + "Номер варианта: " + args[14] + "\n" + "a0 = " + args[15] + "\n" + "a1 = " + args[16] + "\n" + "a2 = " + args[17] + "\n" + "x = " + args[18]);
        a0 = Double.parseDouble(args[15]);
        a1 = Double.parseDouble(args[16]);
        a2 = Double.parseDouble(args[17]);
        x = Double.parseDouble(args[18]);
        double three = (Math.sqrt(a0 + a1 * x + a2 * Math.pow((Math.abs(Math.sin(x))), 1/3)));
        System.out.println(three + "\n");

        System.out.println("Привет " + args[19] + "\n" + "Номер варианта: " + args[20] + "\n" + "a = " + args[21] + "\n" + "x = " + args[22]);
        a = Double.parseDouble(args[21]);
        x = Double.parseDouble(args[22]);
        double four = Math.log(Math.pow(a,7)) + (1 / Math.tan(x*x)) + Math.PI / Math.sqrt(Math.abs(a + x));
        System.out.println(four + "\n");

        System.out.println("Привет " + args[23] + "\n" + "Номер варианта: " + args[24] + "\n" + "a = " + args[25] + "\n" + "b = " + args[26] + "\n" + "c = " + args[27] + "\n" + "d = " + args[28] + "\n" + "x = " + args[29]);
        a = Double.parseDouble(args[25]);
        b = Double.parseDouble(args[26]);
        c = Double.parseDouble(args[27]);
        d = Double.parseDouble(args[28]);
        x = Double.parseDouble(args[29]);
        double five = Math.pow(( Math.pow((a+b),2)/(c+d)) + (Math.pow(Math.E,Math.sqrt(x+1))),(1/5));
        System.out.println(five + "\n");

        System.out.println("Привет " + args[30] + "\n" + "Номер варианта: " + args[31] + "\n" + "x = " + args[32]);
        x = Double.parseDouble(args[32]);
        double six = Math.pow(Math.E, ((2*Math.sin(4*x + Math.cos(x*x) * Math.cos(x*x)))/(3*x)));
        System.out.println(six + "\n");

        System.out.println("Привет " + args[33] + "\n" + "Номер варианта: " + args[34] + "\n" + "x = " + args[35]);
        x = Double.parseDouble(args[35]);
        double seven = ((1/4) * (((1+Math.pow(x,2))/(1-x)) + ((1/2)*(Math.sin(x)/Math.cos(x)))));
        System.out.println(seven + "\n");
    }
}
