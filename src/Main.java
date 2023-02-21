import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Hello " + args[0]);

        System.out.println("Введите х: ");
        int x = sc.nextInt();
        System.out.println("Введите y: ");
        int y = sc.nextInt();
        double gg = ((3*Math.pow(Math.cos(x-(Math.PI/6)),2))/((1/2)+Math.sin(Math.pow(y,2))));
        System.out.println("x = " + x +"\n" + "y = " + y +"\n" + "otvet = " + gg);


    }
}
