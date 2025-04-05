
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Animal animal = new Animal();
        AnimalDAO animalDAO = new AnimalDAO();
        System.out.println("Digite o nome do animal:");
        String nome = entrada.next();
        animal.setNome(nome);
        System.out.println("Digite a classe do animal:");
        String classe = entrada.next();
        animal.setClasse(classe);
        System.out.println("Digite a família do animal:");
        String familia = entrada.next();
        animal.setFamilia(familia);

        animalDAO.nascer(animal);

        // for(int i=0;i!=6;){
        //     System.out.println("0-Informações sobre o animal");
        //     System.out.println("1-Nascer");
        //     System.out.println("2-Morrer");
        //     System.out.println("3-Comer");
        //     System.out.println("4-Correr");
        //     System.out.println("5-Dormir");
        //     System.out.println("6-Sair");
        //     System.out.println("Selecione a opção desejada:");
            
        //     i = entrada.nextInt();
        //     switch (i) {
        //         case 1:
        //         animal.nascer();
        //         System.out.println(animal.informacoes());
        //         break;
        //         case 2:
        //         animal.morrer();
        //         System.out.println(animal.informacoes());
        //         break;
        //         case 3:
        //         animal.comer();
        //         System.out.println(animal.informacoes());
        //         break;
        //         case 4:
        //         animal.correr();
        //         System.out.println(animal.informacoes());
        //         break;
        //         case 5:
        //         animal.dormir();
        //         System.out.println(animal.informacoes());
        //         break;
        //         case 6:
        //             break;
        //     }
        // }
        entrada.close();
    }


    
}
