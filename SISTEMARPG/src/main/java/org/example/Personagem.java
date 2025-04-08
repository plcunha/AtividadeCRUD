package org.example;

public class Personagem {
    protected String nome;
    protected String nomeAventureiro;
    protected int nivel;
    protected int hp;
    protected int atk;
    protected int def;

    public Personagem(String nome, String nomeAventureiro, int nivel, int hp, int atk, int def) {
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.nivel = nivel;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public void atacar(Personagem inimigo) {
        int dano = this.atk - inimigo.def;
        if (dano > 0) {
            inimigo.receberDano(dano);
        } else {
            System.out.println(this.nome + " não conseguiu causar dano em " + inimigo.nome + ".");
        }
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.nome + " foi derrotado!");
        }
    }

    public void exibirStatus() {
        System.out.println("Nome: " + this.nome + ", Nível: " + this.nivel + ", HP: " + this.hp + ", ATK: " + this.atk + ", DEF: " + this.def);
    }
}
