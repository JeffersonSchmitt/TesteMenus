package testemenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CadastroMenu {
    private List<Menu> menus = new ArrayList<>();

    void opcoes() {
        Scanner ler = new Scanner(System.in);
        int opcao;

        System.out.println("Digite a opção desejada");
        System.out.println("1-cadastro de Menu");
        System.out.println("2-Cadastro de Sub Menu");
        System.out.println("3-listar as estruturas");
        System.out.println("4-listar as estruturas comando admin");
        System.out.println("5-sair");

        opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                cadastrar();
                opcoes();
                break;
            case 2:
                cadastrarSubMenu();
                opcoes();
                break;
            case 3:
                listar();
                opcoes();
                break;
            case 4:
                listarAdmin();
                opcoes();
                break;
            case 5:
                break;
        }
    }

    private void cadastrar() {
        Scanner ler = new Scanner(System.in);
        String tituloMenu;
        String visualizacao;
        String nomePai = "";
        Menu menu = new Menu();

        System.out.println("insira o nome UNICO do seu menu");
        tituloMenu = ler.next();

        menu.setDescricao(tituloMenu);

        System.out.println("Este menu devera ser visualizado por esse usuario?");
        System.out.println("responda apenas sim ou nao");
        visualizacao = ler.next();
        menu.setNomePai(nomePai);
        if (visualizacao.equals("sim")) {
            menu.setVisualizar(true);
        } else {
            menu.setVisualizar(false);
        }
        menus.add(menu);
    }

    private void cadastrarSubMenu() {
        Scanner ler = new Scanner(System.in);
        String tituloSubMenu;
        String tituloPaiMenu;
        String visualizacao;
        Menu menu = new Menu();

        System.out.println("insira o nome UNICO do seu sub menu");
        tituloSubMenu = ler.next();
        menu.setDescricao(tituloSubMenu);

        System.out.println("Em qual menu deve aparecer?");
        tituloPaiMenu = ler.next();
        menu.setNomePai(tituloPaiMenu);

        System.out.println("Este menu devera ser visualizado por esse usuario?");
        System.out.println("responda apenas sim ou nao");
        visualizacao = ler.next();

        if (visualizacao.equals("sim")) {
            menu.setVisualizar(true);
        } else {
            menu.setVisualizar(false);
        }
        menus.add(menu);
    }

    private void listar() {
        for (Menu value : menus) {
            if (value.isVisualizar()) {
                if (value.getNomePai().isEmpty()) {
                    System.out.println(value.getDescricao());
                } else {
                    verificaSubMenus(value.getNomePai());
                }
            }
        }
        System.out.println("\n");
    }

    private void listarAdmin() {
        for (Menu value : menus) {
            if (value.getNomePai().isEmpty()) {
                System.out.println(value.getDescricao());
            } else {
                verificaSubMenusADM(value.getNomePai());
            }
        }
        System.out.println("\n");
    }

    private void verificaSubMenus(String nomePai) {
        for (Menu menu : menus) {
            if (menu.isVisualizar()) {
                if (menu.getNomePai().equals(nomePai)) {
                    System.out.println(menu.getDescricao());
                }
            }
        }
    }

    private void verificaSubMenusADM(String nomePai) {
        for (Menu menu : menus) {
            if (menu.getNomePai().equals(nomePai)) {
                System.out.println(menu.getDescricao());
            }
        }
    }
}
