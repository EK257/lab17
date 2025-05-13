import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String g = "";
        while(true){
            try(BufferedWriter file = new BufferedWriter(new FileWriter("text.txt", true))){
                System.out.print("Введите x/save/upload: ");
                Scanner sc = new Scanner(System.in);
                String x = sc.nextLine();
                if(x.equals("save")){
                    file.write(g);
                    System.out.println("Сохранено");
                    g="";
                }
                else if(x.equals("upload")){
                    try(BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){
                        String line;
                        while((line = reader.readLine()) != null){
                            System.out.println(line);
                        }
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                else{
                    double z = Double.parseDouble(x);
                    Calcul u = new Calcul(z);
                    g = "x = " + z + ", y = x-sinx = " + u.y + ";\n";
                    System.out.print(g);
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
class Calcul implements Serializable{
    public double x, y;
    public Calcul(double x){
        this.x = x;
        this.y = calc(x);
    }
    public double calc(double x){
        return x-Math.sin(x);
    }
}