public class ItemMagico {

    protected String id;
    protected String nome;
    protected String tipo;
    protected int atk;
    protected int def;
}
    public ItemMagico(String nome, String id, String tipo, int atk, int def) {
        this.nome = nome;
        this.id = id;
        this.tipo = tipo;
        this.atk = atk;
        this.def = def;
    }