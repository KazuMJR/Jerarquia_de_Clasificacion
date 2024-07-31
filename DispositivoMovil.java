public class DispositivoMovil extends DispositivoElectronico {
    public DispositivoMovil(String nombre, String modelo) {
        super(nombre, modelo);
    }

    public static class Smartphone extends DispositivoMovil {
        public Smartphone(String nombre, String modelo) {
            super(nombre, modelo);
        }
    }

    public static class Tablet extends DispositivoMovil {
        public Tablet(String nombre, String modelo) {
            super(nombre, modelo);
        }
    }
}