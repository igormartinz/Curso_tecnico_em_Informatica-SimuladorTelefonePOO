package ligacaocelular;
import java.util.Scanner;

//Uma classe abstrata e encapsulada em Celular
public abstract class Celulares implements Celular{
    
    // Atributos do celular
    protected float credito;
    protected boolean bloqueado;
    protected int volume;
    protected boolean ligacao;
    protected String dono;
    protected String senha;
    protected String modelo;
    protected float custoL;

    Scanner tec = new Scanner(System.in);
    
    //Liga o celular e pede senha.
    @Override
    public void ligar() {
        this.setBloqueado(true);
        System.out.println("\n\n\n-----------------------------------------------------------");
        System.out.println("\nO aparalho foi ligado.\n");
        System.out.println("-----------------------------------------------------------\n");
        senha();
    }
    
    //Deliga o celular.
    @Override
    public void desligar() {
        this.bloqueado = true;
        System.out.println("\n\n\n-----------------------------------------------------------");
        System.out.println("\nO aparelho foi desligado.\n");
        System.out.println("-----------------------------------------------------------\n");
        menu();
    }
    
    //Adiciona credito
    @Override
    public void depcredito() {
        if (this.bloqueado == false){
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.print("Digite qual valor deseja adicionar: R$");
            setCredito(tec.nextFloat());
            System.out.print("\nDigite sua senha para confirmar:");
            if (this.senha.equals(tec.next())){
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.printf("\nOperaçao bem sucedida!\nCrédito atual R$%.2f\n\n",this.credito);
                System.out.println("-----------------------------------------------------------\n");
                menu();
            }else{
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.println("\nSenha incorreta!\nTente novamente!\n");
                System.out.println("-----------------------------------------------------------\n");
                depcredito();
            }
        }else{
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.println("\nImpossível adicionar!\n(Celular bloqueado)\n");
            System.out.println("-----------------------------------------------------------\n");
            menu();
        }
    }
    
    // Exibe os dados do celular
    @Override
    public void status() {
        System.out.println("\n\n\n--------SITUAÇAO-------\n");
        System.out.println("Modelo: "+this.modelo);
        System.out.println("Dono do aparelho: "+this.dono);
        System.out.print("Volume: ");
        if(this.volume == 0){
            System.out.print("Mudo!");
        }else{
            for(int c = 1; c <= this.volume; c++){
            System.out.print("/");
        }
        }
        System.out.println("");
        System.out.printf("Crédito: %.2f\n",this.credito);
        System.out.print("Está bloqueado: ");
        if (this.bloqueado == true){
            System.out.println("Sim");
        }else{
            System.out.println("Nao");
        }
        System.out.print("Pode fazer ligaçao: ");
        if (this.credito >= 2){
            this.ligacao = true;
        }else{
            this.ligacao = false;
        }
        if (this.ligacao == true){
            System.out.println("Sim");
        }else{
            System.out.println("Nao");
        }
        System.out.printf("\n\nOBS:Para fazer ligaçao e necessário ter R$%.2f em Crédito\n\n",this.custoL);
        menu();
    }
    
    // Realiza um ligaç?o
    @Override
    public void ligacao() {
        if (this.bloqueado == false){
            if (this.credito >= this.custoL){
                this.credito -= this.custoL;
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.printf("\nLigaçao bem sucedida\nCrédito atual R$%.2f\n\n",this.credito);
                System.out.println("-----------------------------------------------------------\n");
                menu();
            }else{
                System.out.println("\n\n-----------------------------------------------------------");
                System.out.println("\nImpossível fazer ligaçao!\nCrédito insuficiente!\n");
                System.out.println("-----------------------------------------------------------\n");
                menu();
            }
        }else{
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.println("\nImpossível fazer ligaçao!\n(Celular bloqueado)\n");
            System.out.println("-----------------------------------------------------------\n");
            menu();
        }
    }
    
    // Exibe o menu de opç?es
    @Override
    public void menu() {
        System.out.println("[1]Desbloquear          [2]Desligar");
        System.out.println("[3]Adicionar crédito    [4]Ligaçao");
        System.out.println("[5]Aumentar Volume      [6]Diminuir Volume");
        System.out.println("[7]Mostrar Dados        [8]Sair");
        System.out.printf("\n\nAtençao: para fazer uma ligaçao e necessário ter R$%.2f em créditos\n",this.custoL);
        System.out.print("\nDigite a opçao que deseja: ");
        int opcao = tec.nextInt();
        switch (opcao) {
            case 1:
                ligar();
                break;
            case 2:
                desligar();
                break;
            case 3:
                depcredito();
                break;
            case 4:
                ligacao();
                break;
            case 5:
                maisvolume();
                menu();
                break;
            case 6:
                menosvolume();
                menu();
                break;
            case 7:
                status();
                break;
            case 8:
                System.out.println("\n\nPrograma encerrado!\n");
                break;
            default:
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.println("\nOpçao inválida!\nTente novamente\n");
                System.out.println("-----------------------------------------------------------\n");
                menu();
                break;
        }
    }
    
    //Cria um cadastro do usuario.
    public void cadastro() {
        System.out.println("===Bem-vindo!===\nCrie sua conta!\n");
        System.out.print("Digite seu nome: ");
        this.dono = tec.next();
        System.out.print("Crie uma senha: ");
        this.senha = tec.next();
        System.out.println("\n\n\n\n-----------------------------------------------------------");
        System.out.println("\nCadastro concluído!\n");
        System.out.println("-----------------------------------------------------------\n");
        menu();
    }
    
    // Solicita a senha para desbloquear
    public void senha() {
        System.out.print("Digite sua senha para desbloquear: ");
        if(tec.next().equals(this.senha)){
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.println("\nAparelho desbloqueado!\nBem-vindo de volta "+this.dono+"\n");
            System.out.println("-----------------------------------------------------------\n");
            this.bloqueado = false;
            menu();
        }else{
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.println("\nSenha incorreta!\nTente novamente!\n");
            System.out.println("-----------------------------------------------------------\n");
            senha();
        }
    }
    
    //Aumenta o volume do celular
    public void maisvolume() {
        System.out.println("\n\n\n-----------------------------------------------------------");
        System.out.print("\nVolume: ");
        if(this.volume >= 10){
            System.out.print("Maximo!");
        }else{
            this.volume ++;
            for (int c = 1;c <= this.volume; c++){
            System.out.print("/");
        }
        }
        System.out.println("\n\n-----------------------------------------------------------\n");
    }
    
    //Diminui o volume do celular
    public void menosvolume() {
        System.out.println("\n\n\n-----------------------------------------------------------");
        System.out.print("\nVolume: ");
        if(this.volume <= 0){
            System.out.print("Mudo!");
        }else{
            this.volume --;
            for (int c = 1;c <=this.volume; c++){
            System.out.print("/");
        }
        }
        System.out.println("\n\n-----------------------------------------------------------\n");
    }
    
    //Costrutor
    public Celulares() {
        this.credito = 0;
        this.bloqueado = true;
        this.volume = 6;
        
    }
    
    
    //Metodos Gatters e Setters
    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean ligado) {
        this.bloqueado = bloqueado;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean getLigacao() {
        return ligacao;
    }

    public void setLigacao(boolean ligacao) {
        this.ligacao = ligacao;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
