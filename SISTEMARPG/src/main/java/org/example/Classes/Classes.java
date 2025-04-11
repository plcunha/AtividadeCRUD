package org.example.Classes;
public enum Classes {
    GUERREIRO("Guerreiro"),
    MAGO("Mago"),
    ARQUEIRO("Arqueiro"),
    LADINO("Ladino"),
    BARDO("Bardo");

    private final String nome;

    Classes(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Classes fromString(String valor) {
        for (Classes classe : Classes.values()) {
            if (classe.nome.equalsIgnoreCase(valor)) {
                return classe;
            }
        }
        return null;
    }

    public static boolean ClasseValida(String valor) {
        return fromString(valor) != null;
    }
}