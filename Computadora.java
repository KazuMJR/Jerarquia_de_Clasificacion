public class Computadora extends DispositivoElectronico {
    public Computadora(String nombre, String modelo) {
        super(nombre, modelo);
    }

    public static class Laptop extends Computadora {
        public Laptop(String nombre, String modelo) {
            super(nombre, modelo);
        }
    }

    public static class Desktop extends Computadora {
        public Desktop(String nombre, String modelo) {
            super(nombre, modelo);
        }
    }
}