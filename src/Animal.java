
import java.util.Scanner;

public class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int forca=0;
    private int caloria=0;
    private int idade=0;
    private boolean estado;

    Scanner entrada = new Scanner(System.in);


    public Animal() {
    }

    public String informacoes(){
        return "Nome: " + nome + ", Classe: " + classe + ", Família: " + familia +
                           ", Idade: " + idade + ", Estado: " + estado + ", Caloria: " + caloria +
                           ", Força: " + forca;
    }

    public void nascer(){
        System.out.println("Digite o nome do animal:");
        nome = entrada.next();
        System.out.println("Digite a classe do animal:");
        classe = entrada.next();
        System.out.println("Digite a familia do animal:");
        familia = entrada.next();
        forca = 10;
        caloria = 10;
        estado = true;
    }

    public void morrer(){
        forca = 0;
        estado = false;
    }

    public void comer(){
        if(caloria <= 100 || estado == true){
            caloria += 10;
            forca -= 2;
        }else{
            System.out.println("O animal esta cheio ou morto");
        }
    }

    public void correr(){
        if(caloria != 0 || estado == true){
            forca -= 5;
            caloria -=5;
        }
    }

    public void dormir(){
        if(estado == true){
            forca +=10;
            caloria -= 2;
        }
    }
    

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getClasse() {
        return classe;
    }


    public void setClasse(String classe) {
        this.classe = classe;
    }


    public String getFamilia() {
        return familia;
    }


    public void setFamilia(String familia) {
        this.familia = familia;
    }


    public int getForça() {
        return forca;
    }


    public void setForça(int força) {
        this.forca = força;
    }


    public int getCaloria() {
        return caloria;
    }


    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public boolean isEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public Scanner getEntrada() {
        return entrada;
    }


    public void setEntrada(Scanner entrada) {
        this.entrada = entrada;
    }


    
}
