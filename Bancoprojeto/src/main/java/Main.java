import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      // Cria o objeto sistema
        Sistema sistema = new Sistema();

        Scanner input = new Scanner(System.in);
        int opcao = 1;
        while (opcao != 0){
            System.out.println("#---------------------------#");
            System.out.println("# 1 - Cadastrar banco       #");
            System.out.println("# 2 - Listar banco          #");
            System.out.println("# 3 - Cadastrar conta       #");
            System.out.println("# 4 - Depositar             #");
            System.out.println("# 5 - Sacar                 #");
            System.out.println("# 6 - Transferir            #");
            System.out.println("# 7 - Exibir saldo          #");
            System.out.println("# 8 - Exibir extrato        #");
            System.out.println("# 9 - Ver rendimento        #");
            System.out.println("# 10 - Desativar conta      #");
            System.out.println("# 11 - Rativar conta        #");
            System.out.println("# 0 - Fechar sistema        #");
            System.out.println("#---------------------------#");
            opcao = Integer.parseInt(input.nextLine());
            if(opcao == 1){
                System.out.println("############ Cadastrar banco ##############");
                String nomeBanco = input.nextLine();
                sistema.cadastrarBanco(new Banco(nomeBanco));
            }else if(opcao == 2){
                System.out.println("############ Listar bancos ##############");
                sistema.listarBancos();
            }else if(opcao == 3){
                System.out.println("############ Cadastrar conta ##############");
                System.out.println("Informe o nome do cliente:");
                String cliente = input.nextLine();
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o saldo Inicial:");
                String saldo = input.nextLine();
                System.out.println("Informe o tipo da conta (1 - Corrente, 2 - Poupança, 3 - Especial)");
                String tipo = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                ContaGeral conta = null;

                if(tipo.equals("1")){
                    conta = new ContaPoupanca(cliente, numero, agencia,  Double.parseDouble(saldo), 0.0);
                }else  if(tipo.equals("2")) {
                    conta = new ContaCorrente(cliente, numero, agencia,  Double.parseDouble(saldo), 0.0);
                }else  if(tipo.equals("3")) {
                    System.out.println("Informe o limit da conta especial: ");
                    String limit = input.nextLine();
                    conta = new ContaEspecial(cliente, numero, agencia,  Double.parseDouble(saldo), Double.parseDouble(limit));
                }
                sistema.cadastrarConta(conta, Integer.parseInt(banco));
            }
            else if(opcao == 4){
                System.out.println("############ Depositar ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                System.out.println("Informe o valor a ser depositado:");
                String valor = input.nextLine();
                sistema.depositar(Integer.parseInt(banco), numero, agencia, Double.parseDouble(valor));
            }
            else if(opcao == 5){
                System.out.println("############ Sacar ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                System.out.println("Informe o valor a ser sacado:");
                String valor = input.nextLine();
                sistema.sacar(Integer.parseInt(banco), numero, agencia, Double.parseDouble(valor));
            }else if(opcao == 6){
                System.out.println("############ Transferir ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();


                System.out.println("Informe o número da conta Destino:");
                String numeroDestino = input.nextLine();
                System.out.println("Informe a agência da conta Destino:");
                String agenciaDestino = input.nextLine();
                System.out.println("Informe o código do banco da conta Destino (veja as opções a seguir):");
                sistema.listarBancos();
                String bancoDestino = input.nextLine();

                System.out.println("Informe o valor a ser transferido:");
                String valor = input.nextLine();

                sistema.transferir(Integer.parseInt(banco), numero, agencia, Integer.parseInt(bancoDestino), numeroDestino, agenciaDestino, Double.parseDouble(valor));
            }else if(opcao == 7){
                System.out.println("############ Exibir saldo ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                sistema.exibirSaldo(Integer.parseInt(banco), numero, agencia);
            }else if(opcao == 8){
                System.out.println("############ Exibir extrato ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                sistema.exibirExtrato(Integer.parseInt(banco), numero, agencia);
            }else if(opcao == 9){
                System.out.println("############ ver rendimento ##############");
            }else if(opcao == 10){
                System.out.println("############ Desativar conta ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                sistema.encerrarConta(Integer.parseInt(banco), numero, agencia);
            }else if(opcao == 11){
                System.out.println("############ Reativar conta ##############");
                System.out.println("Informe o número da conta:");
                String numero = input.nextLine();
                System.out.println("Informe a agência:");
                String agencia = input.nextLine();
                System.out.println("Informe o código do banco (veja as opções a seguir):");
                sistema.listarBancos();
                String banco = input.nextLine();
                sistema.reativarConta(Integer.parseInt(banco), numero, agencia);
            }else if(opcao == 0){
                System.out.println("############ Finalizando sistema ##############");
                break;
            }
        }

/*
        System.out.println("############ Cadastrar banco ##############");
        sistema.cadastrarBanco(new Banco("Santander"));
        sistema.cadastrarBanco(new Banco("Brasil"));
        sistema.cadastrarBanco(new Banco("Bradesco"));


        System.out.println("############ Cadastrar conta ##############");

        ContaGeral contaCorrente = new ContaCorrente("Bendo Gonçalves", "123451-x", "1234", 50.0, 0.0);
        ContaGeral contaEspecial = new ContaEspecial("Bendo Gonçalves", "123452-x", "1234",  50.0,  1000.0);
        ContaGeral contaPoupanca = new ContaPoupanca("Bendo Gonçalves", "123453-x", "1235",  50.0, 0.0);
        sistema.cadastrarConta(contaCorrente, 1);
        sistema.cadastrarConta(contaEspecial, 2);
        sistema.cadastrarConta(contaPoupanca, 1);


        System.out.println("############ Depositar conta ##############");
        sistema.depositar(1, "123451-x", "1234", 1000.0);
        sistema.depositar(2, "123452-x", "1234", 150.0);
        sistema.depositar(1, "123453-x", "1235", 100.0);

        System.out.println("############ Exibir saldo ##############");
        sistema.exibirSaldo(1, "123451-x", "1234");
        sistema.exibirSaldo(2, "123452-x", "1234");
        sistema.exibirSaldo(1, "123453-x", "1235");

        System.out.println("############ Sacar conta ##############");
        sistema.sacar(1, "123451-x", "1234", 100.0);
        sistema.sacar(2, "123452-x", "1234", 10.0);
        sistema.sacar(1, "123453-x", "1235", 10.0);


        System.out.println("############ Transferir ##############");
        sistema.transferir(1, "123451-x", "1234", 1, "123453-x", "1235", 10.0);
        sistema.transferir(2, "123452-x", "1234", 1, "123453-x", "1235", 10.0);



        System.out.println("############ Encerrar conta ##############");
        sistema.encerrarConta(1, "123451-x", "1234");
        sistema.sacar(1, "123451-x", "1234", 940.0);
        sistema.encerrarConta(1, "123451-x", "1234");


        System.out.println("############ Reativar conta ##############");
        sistema.reativarConta(1, "123451-x", "1234");

        System.out.println("############ Exibir extrato ##############");
        sistema.exibirExtrato(1, "123451-x", "1234");*/

    }
}