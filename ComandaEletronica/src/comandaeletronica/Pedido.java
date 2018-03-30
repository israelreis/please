
package comandaeletronica;

public class Pedido {
    private int Mesa;
    private String situacao;

    public Pedido(int Mesa, String situacao) {
        this.Mesa = Mesa;
        this.situacao = situacao;
    }

    public int getMesa() {
        return Mesa;
    }

    public void setMesa(int Mesa) {
        this.Mesa = Mesa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
}
