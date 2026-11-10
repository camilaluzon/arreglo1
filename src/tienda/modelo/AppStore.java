package tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    public void cargarDatos(){
        //invoca al metodo agregarJuego() como si fuera un void porque no voy a dar ningun mensaje al usuario
        agregarJuego(new Juego("FIFA 2026", "Deportes",15, 36,50));
        agregarJuego(new Juego("ROBLOX", "Accion",25, 90,20));
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public int getIndice() {
        return indice;
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
            for(int i = 0; i <= indice; i++){
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

    public double vender(String nombre, int cantidad){
        //no voy a validar los parametros para buscar pq el buscar ya lo valida y el vender
        // del producto tmb
        Juego j= buscarJuego(nombre);
        if(j != null){
            if(j.vender(cantidad)){
                return j.getPrecio() * cantidad;
            }else{
                return 0;
            }
        }
        return 0;
    }

    public String masVendido(){
        String nombre = "";
        int mayor;
        if(indice >= 0){
            nombre = juegos[0].getNombre();
            mayor = juegos[0].getLicenciasVendidas();
            for(Juego j : juegos){
                if(j!=null){
                    if(j.getLicenciasVendidas() > mayor){
                        nombre = j.getNombre();
                        mayor = j.getLicenciasVendidas();
                    }
                }else{
                    return nombre;
                }
            }
        }
        return nombre;
    }
}
