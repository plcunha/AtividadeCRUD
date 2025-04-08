package org.example;

public class Mago extends Personagem {
    private int mana;
    private int poderMagico;

    public Mago(String nome, int nivel, int hp, int atk, int def, int mana, int poderMagico) {
        super(nome, nivel, hp, atk, def);
        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    public void lancarMagia(Personagem inimigo) {
        if (this.mana > 0) {
            int dano = this.poderMagico - inimigo.def;
            this.mana -= 10; // Consome mana
            if (dano > 0) {
                inimigo.receberDano(dano);
            } else {
                System.out.println(this.nome + " não conseguiu causar dano em " + inimigo.nome + ".");
            }
        } else {
            System.out.println(this.nome + " está sem mana!");
        }
    }
}
