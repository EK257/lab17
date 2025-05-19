import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите x: ");
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        Calc cl = new Calc(x);
        System.out.println("x="+ x+ ", y=" + cl.y);
        System.out.print("Введите save/upload: ");
        sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.equals("save")){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("text.txt"))){
                oos.writeObject(cl);
                System.out.println("Сохранено");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        else if(s.equals("upload")){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("text.txt"))){
                Calc c = (Calc) ois.readObject();
                System.out.println("x="+ c.x+ ", y=" + c.y);
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.println("Неправильная команда");
        }
    }
}
class Calc implements Serializable {
    public double x, y;
    public Calc(double x){
        this.x = x;
        this.y = calc(x);
    }
    public double calc(double x){
        return x-Math.sin(x);
    }
}
