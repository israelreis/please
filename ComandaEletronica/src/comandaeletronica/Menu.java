package comandaeletronica;

import javafx.scene.image.Image;

class Menu {
    private String label;
    private Image imagem;

    public Menu(String label, Image imagem) {
        this.label = label;
        this.imagem = imagem;
    }

    public String getLabel() {
        return label;
    }

    public Image getImagem() {
        return imagem;
    }
    
}
