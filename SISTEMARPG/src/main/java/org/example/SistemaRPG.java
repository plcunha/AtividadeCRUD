package org.example;

public class SistemaRPG {
    public static void main(String[] args) {
        Ladino ladino = new Ladino("Zeca", 10, 100, 20, 10, 5, 2);
        Mago mago = new Mago("Sérgio", 10, 80, 15, 5, 50, 25);
        Arqueiro arqueiro = new Arqueiro("Claudio", 10, 90, 18, 8, 10, 15);

        ladino.exibirStatus();
        mago.exibirStatus();
        arqueiro.exibirStatus();

        System.out.println("\n--- Batalha ---\n");

        ladino.atacar(mago);
        mago.lancarMagia(ladino);
        arqueiro.atirarFlecha(ladino);

        System.out.println("\n--- Status após a primeira rodada ---\n");

        ladino.exibirStatus();
        mago.exibirStatus();
        arqueiro.exibirStatus();
    }
}
