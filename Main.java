import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------Menu Principal---------");
            System.out.println("1. Articulos disponibles");
            System.out.println("2. Ver lista de articulos elegidos");
            System.out.println("3. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    menu.mostrarYSeleccionarArticulos();
                    break;
                case 2:
                    menu.mostrarListaDeseos();
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}