
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int i=0;
        Scanner entrada = new Scanner(System.in);
        Animal animal = new Animal();

        while(i!=6){
            System.out.println("Selecione a opção desejada:");
            
            i = entrada.nextInt();
            switch (i) {
                case 1:
                animal.nascer();
                case 2:
                animal.morrer();
                case 3:
                animal.comer();
                case4:
                animal.correr();
                case5:
                animal.dormir();
                case 6:
                    break;
            }
        }
    }


    
}
