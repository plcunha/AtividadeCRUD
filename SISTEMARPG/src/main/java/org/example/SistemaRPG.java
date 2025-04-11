package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaRPG {
    private Map<String, Personagem> personagens;
    private Map<String, ItemMagico> itens;
    private Scanner scanner;

    public static void main(String[] args) {
        new SistemaRPG().iniciar();
    }

    public SistemaRPG() {
        personagens = new HashMap<>();
        itens = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n--- Sistema RPG ---");
            System.out.println("1. Criar Personagem");
            System.out.println("2. Criar Item Mágico");
            System.out.println("3. Listar Personagens");
            System.out.println("4. Listar Itens Mágicos");
            System.out.println("5. Buscar Personagem por ID");
            System.out.println("6. Adicionar Item a Personagem");
            System.out.println("7. Atualizar Nome de Personagem");
            System.out.println("8. Remover Personagem");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1: criarPersonagem(); break;
                case 2: criarItem(); break;
                case 3: listarPersonagens(); break;
                case 4: listarItens(); break;
                case 5: buscarPersonagemPorId(); break;
                case 6: adicionarItemAPersonagem(); break;
                case 7: atualizarNomePersonagem(); break;
                case 8: removerPersonagem(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        scanner.close();
    }

    private void criarPersonagem() {
        try {
            System.out.println("\nNovo Personagem:");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Nome do Aventureiro: ");
            String nomeAventureiro = scanner.nextLine();

            System.out.print("Classe (Guerreiro/Mago/Arqueiro/Ladino/Bardo): ");
            String classe = scanner.nextLine();

            System.out.print("Nível: ");
            int nivel = scanner.nextInt();

            System.out.println("Distribua 10 pontos entre Força e Defesa:");
            System.out.print("Força: ");
            int forca = scanner.nextInt();

            System.out.print("Defesa: ");
            int defesa = scanner.nextInt();
            scanner.nextLine();

            Personagem p = new Personagem(nome, nomeAventureiro, classe, nivel, forca, defesa);
            personagens.put(p.getId(), p);
            System.out.println("Personagem criado! ID: " + p.getId());
        } catch (Exception e) {
            System.out.println("Erro ao criar personagem: " + e.getMessage());
        }
    }

    private void criarItem() {
        try {
            System.out.println("\nNovo Item Mágico:");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Tipo (Arma/Armadura/Amuleto): ");
            String tipo = scanner.nextLine();

            System.out.print("Força (0-10): ");
            int forca = scanner.nextInt();

            System.out.print("Defesa (0-10): ");
            int defesa = scanner.nextInt();
            scanner.nextLine();

            ItemMagico item = new ItemMagico(nome, tipo, forca, defesa);
            itens.put(item.getId(), item);
            System.out.println("Item criado! ID: " + item.getId());
        } catch (Exception e) {
            System.out.println("Erro ao criar item: " + e.getMessage());
        }
    }

    private void listarPersonagens() {
        System.out.println("\nPersonagens:");
        if (personagens.isEmpty()) {
            System.out.println("Nenhum personagem cadastrado.");
            return;
        }

        for(Personagem p : personagens.values()) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Nome Aventureiro: " + p.getNomeAventureiro());
            System.out.println("Classe: " + p.getClasse());
            System.out.println("Nível: " + p.getNivel());
            System.out.println("Força Base: " + (p.getForcaTotal() - p.getItens().stream().mapToInt(ItemMagico::getForca).sum()));
            System.out.println("Defesa Base: " + (p.getDefesaTotal() - p.getItens().stream().mapToInt(ItemMagico::getDefesa).sum()));
            System.out.println("Força Total: " + p.getForcaTotal());
            System.out.println("Defesa Total: " + p.getDefesaTotal());
            System.out.println("Itens: " + p.getItens().size());
            System.out.println("-------------------");
        }
    }

    private void listarItens() {
        System.out.println("\nItens Mágicos:");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }

        for(ItemMagico item : itens.values()) {
            System.out.println("ID: " + item.getId());
            System.out.println("Nome: " + item.getNome());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Força: " + item.getForca());
            System.out.println("Defesa: " + item.getDefesa());
            System.out.println("-------------------");
        }
    }

    private void buscarPersonagemPorId() {
        System.out.print("\nDigite o ID do Personagem: ");
        String id = scanner.nextLine();

        Personagem p = personagens.get(id);
        if (p != null) {
            System.out.println("\nDetalhes do Personagem:");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Nome Aventureiro: " + p.getNomeAventureiro());
            System.out.println("Classe: " + p.getClasse());
            System.out.println("Nível: " + p.getNivel());
            System.out.println("Força Base: " + (p.getForcaTotal() - p.getItens().stream().mapToInt(ItemMagico::getForca).sum()));
            System.out.println("Defesa Base: " + (p.getDefesaTotal() - p.getItens().stream().mapToInt(ItemMagico::getDefesa).sum()));
            System.out.println("Força Total: " + p.getForcaTotal());
            System.out.println("Defesa Total: " + p.getDefesaTotal());

            System.out.println("\nItens do Personagem:");
            if (p.getItens().isEmpty()) {
                System.out.println("Nenhum item equipado.");
            } else {
                for (ItemMagico item : p.getItens()) {
                    System.out.println("- " + item.getNome() + " (" + item.getTipo() + ")");
                    System.out.println("  Força: +" + item.getForca());
                    System.out.println("  Defesa: +" + item.getDefesa());
                }
            }
        } else {
            System.out.println("Personagem não encontrado.");
        }
    }

    private void adicionarItemAPersonagem() {
        try {
            System.out.print("\nID do Personagem: ");
            String idPersonagem = scanner.nextLine();

            System.out.print("ID do Item: ");
            String idItem = scanner.nextLine();

            Personagem p = personagens.get(idPersonagem);
            ItemMagico item = itens.get(idItem);

            if (p != null && item != null) {
                p.adicionarItem(item);
                System.out.println("Item adicionado com sucesso ao personagem!");
            } else {
                System.out.println("Personagem ou Item não encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    private void atualizarNomePersonagem() {
        System.out.print("\nID do Personagem: ");
        String id = scanner.nextLine();

        Personagem p = personagens.get(id);
        if (p != null) {
            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();

            System.out.print("Novo Nome do Aventureiro: ");
            String novoNomeAventureiro = scanner.nextLine();

            p.setNome(novoNome);
            p.setNomeAventureiro(novoNomeAventureiro);
            System.out.println("Nome atualizado com sucesso!");
        } else {
            System.out.println("Personagem não encontrado.");
        }
    }

    private void removerPersonagem() {
        System.out.print("\nID do Personagem a ser removido: ");
        String id = scanner.nextLine();

        if (personagens.containsKey(id)) {
            personagens.remove(id);
            System.out.println("Personagem removido com sucesso!");
        } else {
            System.out.println("Personagem não encontrado.");
        }
    }
}