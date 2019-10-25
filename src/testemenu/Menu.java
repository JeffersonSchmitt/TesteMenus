package testemenu;

class Menu {

    private String descricao;
    private boolean visualizar;
    private String nomePai;


    String getDescricao() {
        return descricao;
    }

    void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    boolean isVisualizar() {
        return visualizar;
    }

    void setVisualizar(boolean visualizar) {
        this.visualizar = visualizar;
    }

    String getNomePai() {
        return nomePai;
    }

    void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
}
