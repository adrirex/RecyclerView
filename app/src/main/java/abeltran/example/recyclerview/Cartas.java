package abeltran.example.recyclerview;

public class Cartas {

    enum Estat{
        FIXED, BACK, FRONT
    }

    private int imagen;
    private int imagenTrasera;
    private Estat estado;

    public Cartas(int imagen, int imagenTrasera) {
        this.imagen = imagen;
        this.imagenTrasera = imagenTrasera;
        this.estado = Estat.BACK;
    }

    public int getImagen() {
        if(estado == Estat.BACK) {
            return imagenTrasera;
        }else {
            return imagen;
        }
    }

    public Estat getEstado(){
        return this.estado;
    }

    public void girar(){
        if(estado == Estat.BACK){
            estado = Estat.FRONT;
        }else if(estado == Estat.FRONT){
            estado = Estat.BACK;
        }
    }
}
