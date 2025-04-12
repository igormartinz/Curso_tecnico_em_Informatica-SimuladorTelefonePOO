package ligacaocelular;

//Heran�a de Celulares
public class Fixo extends Celulares{
    //Atributo do Fixo
    private boolean mensal;
    
    //Costrutor
    public Fixo() {
        this.modelo = "Fixo";
        this.mensal = false;
    }
    
    //Sobreposi�?o do metodo ligar.
    @Override
    public void ligar() {
        this.bloqueado = false;
        System.out.println("\n\n\n-----------------------------------------------------------");
        System.out.println("\nO aparalho foi ligado.\n");
        System.out.println("-----------------------------------------------------------\n");
        menu();
    }
    
    //Sobreposi�?o do metodo que mostra dados.
    @Override
    public void status() {
        System.out.println("\n\n------SITUA�AO------\n");
        System.out.println("Modelo: "+this.modelo);
        System.out.print("Volume: ");
        if(this.volume == 0){
            System.out.print("Mudo!");
        }else{
            for(int c = 1; c <= this.volume; c++){
            System.out.print("/");
        }
        }
        System.out.println("");
        System.out.print("Mensalidade paga: ");
        if (this.mensal == true){
            System.out.println("Sim");
        }else{
            System.out.println("Nao");
        }
        System.out.print("Pode fazer liga�ao: ");
        if(this.bloqueado == true){
            System.out.println("Nao");
        }else{
            if (this.mensal == true){
                System.out.println("Sim");
            }else{
                System.out.println("Nao");
            }   
        }
        System.out.println("\nOBS:Para fazer liga�ao e necess�rio ter a mensalidade paga!\n");
        
        menu();
    }

    //Sobreposi�?o do metodo menu.
    @Override
    public void menu() {
        System.out.println("[1]Ligar aparelho       [2]Desligar");
        System.out.println("[3]Pagar mensalidade    [4]Liga�ao");
        System.out.println("[5]Aumentar Volume      [6]Diminuir Volume");
        System.out.println("[7]Mostrar dados        [8]Sair");
        System.out.println("\nAten�ao: para fazer uma liga�ao e necess�rio ter a mensalidade paga!");
        System.out.print("\nDigite a op�ao que deseja: ");
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
                System.out.println("\nOp�ao inv�lida!\nTente novamente\n");
                System.out.println("-----------------------------------------------------------\n");
                menu();
                break;
        }        
    }
    
    //Sobreposi�?o do metodo de liga�?o.
    @Override
    public void ligacao() {
        if (this.bloqueado == false){
            if (this.mensal == true){
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.printf("\nLiga�ao bem sucedida\n\n");
                System.out.println("-----------------------------------------------------------\n");
                menu();
            }else{
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.println("\nImposs�vel fazer liga�ao!\nMensalidade nao foi paga!\n");
                System.out.println("-----------------------------------------------------------\n");
                menu();
            }
        }else{
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.println("\nImposs�vel fazer liga�ao!\n(Aparelho desligado)\n");
            System.out.println("-----------------------------------------------------------\n");
            menu();
        }
    }
    
    //Sobreposi�?o do metodo adicionar credito, mas agora ele paga a mensalidade.
    @Override
    public void depcredito() {
         if (this.bloqueado == false){
             if (this.mensal == true){
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.println("\nSua mensalidade j� est� paga!\n\n");
                System.out.println("-----------------------------------------------------------\n");
                menu();
             }else{
                System.out.println("\n\n\n-----------------------------------------------------------");
                System.out.print("\nSua mensalidade foi paga com sucesso!\nObrigado pela preferencia\n\n");
                System.out.println("-----------------------------------------------------------\n");
                this.mensal = true;
                menu();
             }
        }else{
            System.out.println("\n\n\n-----------------------------------------------------------");
            System.out.println("\nImposs�vel pagar!\n(Aparelho desligado)\n");
            System.out.println("-----------------------------------------------------------\n");
            menu();
        }
    }
    
    //Metodos Getters e Setters.
    public boolean getMensal() {
        return mensal;
    }

    public void setMensal(boolean mensal) {
        this.mensal = mensal;
    }
}
