package org.example;

import java.util.UUID;

public class ItemMagico {
    private String id;
    private String nome;
    private String tipo;
    private int forca;
    private int defesa;

    public ItemMagico(String nome, String tipo, int forca, int defesa) {

        String[] tiposValidos = {"Arma", "Armadura", "Amuleto"};
        boolean tipoValido = false;
        for (String t : tiposValidos) {
            if (t.equalsIgnoreCase(tipo)) {
                tipoValido = true;
                break;
            }
        }
        if (!tipoValido) {
            throw new IllegalArgumentException("Tipo de item inválido");
        }

        if (tipo.equalsIgnoreCase("Arma") && defesa != 0) {
            throw new IllegalArgumentException("Armas devem ter defesa = 0");
        }

        if (tipo.equalsIgnoreCase("Armadura") && forca != 0) {
            throw new IllegalArgumentException("Armaduras devem ter força = 0");
        }

        if (forca < 0 || defesa < 0 || forca > 10 || defesa > 10) {
            throw new IllegalArgumentException("Força e defesa devem estar entre 0 e 10");
        }

        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("Item não pode ter força e defesa zerados");
        }

        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getForca() { return forca; }
    public int getDefesa() { return defesa; }

    public void setNome(String nome) { this.nome = nome; }
}