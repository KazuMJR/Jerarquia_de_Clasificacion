public class Electrodomestico extends DispositivoElectronico {
    public Electrodomestico(String nombre, String modelo) {
        super(nombre, modelo);
    }


    public static class Refrigerador extends Electrodomestico {
        public Refrigerador(String nombre, String modelo) {
            super(nombre, modelo);
        }
    }
}