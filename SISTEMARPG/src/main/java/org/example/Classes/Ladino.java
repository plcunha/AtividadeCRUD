package org.example;

public class Guerreiro extends Personagem {
    private int forcaExtra;
    private int armadura;

    public Guerreiro(String nome, int nivel, int hp, int atk, int def, int forcaExtra, int armadura) {
        super(nome, nivel, hp, atk, def);
        this.forcaExtra = forcaExtra;
        this.armadura = armadura;
    }

    @Override
    public void atacar(Personagem inimigo) {
        int dano = (this.atk + this.forcaExtra) - inimigo.def;
        if (dano > 0) {
            inimigo.receberDano(dano);
        } else {
            System.out.println(this.nome + " não conseguiu causar dano em " + inimigo.nome + ".");
        }
    }
}
