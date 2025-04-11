package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Personagem {
    private String id;
    private String nome;
    private String nomeAventureiro;
    private String classe;
    private int nivel;
    private List<ItemMagico> itens;
    private int forca;
    private int defesa;

    public Personagem(String nome, String nomeAventureiro, String classe, int nivel, int forca, int defesa) {
        if (forca + defesa != 10) {
            throw new IllegalArgumentException("A soma de força e defesa deve ser 10");
        }

        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;


        String[] classesValidas = {"Guerreiro", "Mago", "Arqueiro", "Ladino", "Bardo"};
        boolean classeValida = false;
        for (String c : classesValidas) {
            if (c.equalsIgnoreCase(classe)) {
                classeValida = true;
                break;
            }
        }
        if (!classeValida) {
            throw new IllegalArgumentException("Classe inválida");
        }

        this.classe = classe;
        this.nivel = nivel;
        this.forca = forca;
        this.defesa = defesa;
        this.itens = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getNomeAventureiro() { return nomeAventureiro; }
    public String getClasse() { return classe; }
    public int getNivel() { return nivel; }
    public List<ItemMagico> getItens() { return itens; }

    public int getForcaTotal() {
        int total = forca;
        for (ItemMagico item : itens) {
            total += item.getForca();
        }
        return total;
    }

    public int getDefesaTotal() {
        int total = defesa;
        for (ItemMagico item : itens) {
            total += item.getDefesa();
        }
        return total;
    }

    public void adicionarItem(ItemMagico item) {

        if (item.getTipo().equalsIgnoreCase("Amuleto")) {
            for (ItemMagico i : itens) {
                if (i.getTipo().equalsIgnoreCase("Amuleto")) {
                    throw new IllegalStateException("O personagem já possui um amuleto");
                }
            }
        }
        itens.add(item);
    }

    public void removerItem(ItemMagico itemMagico) {
        itens.remove(itemMagico);
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setNomeAventureiro(String novoNomeAventureiro) {
        this.nomeAventureiro = novoNomeAventureiro;
    }
}