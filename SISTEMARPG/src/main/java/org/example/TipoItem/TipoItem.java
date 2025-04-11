package org.example.TipoItem;

public enum TipoItem {
    ARMA("Arma"),
    ARMADURA("Armadura"),
    AMULETO("Amuleto");

    private final String nome;

    TipoItem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static TipoItem fromString(String valor) {
        for (TipoItem tipo : TipoItem.values()) {
            if (tipo.nome.equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        return null;
    }

    public static boolean TipoValido(String valor) {
        return fromString(valor) != null;
    }
}