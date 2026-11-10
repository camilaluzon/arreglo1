package tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    public Juego[] getJuegos() {
        return juegos;
    }
    /*
    no es necesario el set porque el ingreso deberia ser por cada elemento.

    public void setJuegos(Juego juegos[]) {
        this.juegos = juegos;
    }
     */

    public boolean agregarJuego(Juego j){
        if (j != null && indice < MAX-1){
            juegos[++indice]=j;
            return true;
        }
        return false;
    }

    public Juego buscarJuego(String nombre){
        if(nombre!=null && !nombre.trim().isEmpty()){
            for(int i = 0; i < indice; i++){
                if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                    return juegos[1];
                }
            }
            return null;
        }
        return null;
    }

    public boolean comprar(String nombre, int cantidad){
        if(nombre != null && !nombre.trim().isEmpty() && cantidad > 0){
            Juego j = buscarJuego(nombre);
            if(j != null ){
                return j.comprar(cantidad);
            }
        }
        return false;
    }
}
