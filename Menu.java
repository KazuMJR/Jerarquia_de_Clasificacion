import java.util.*;

class Menu {
    private List<DispositivoElectronico> listaDeseos;
    private Map<String, List<DispositivoElectronico>> articulosPredefinidos;

    public Menu() {
        listaDeseos = new ArrayList<>();
        articulosPredefinidos = new HashMap<>();
        inicializarArticulosPredefinidos();
    }

    private void inicializarArticulosPredefinidos() {
        List<DispositivoElectronico> moviles = new ArrayList<>();
        articulosPredefinidos.put("Dispositivos Moviles", moviles);
        //List of Smartphones
        moviles.add(new DispositivoMovil.Smartphone("Apple", "Iphone 14 Pro"));
        moviles.add(new DispositivoMovil.Smartphone("Samsung", "Galaxy S24 Ultra"));
        moviles.add(new DispositivoMovil.Smartphone("Huawei", "Mate 60 Pro"));
        moviles.add(new DispositivoMovil.Smartphone("Xiaomi", "Redmi K50 Gaming"));
        //List of Tablets
        moviles.add(new DispositivoMovil.Tablet("Apple", "iPad Pro"));
        moviles.add(new DispositivoMovil.Tablet("Xiaomi", "Redmi Pad SE"));
        moviles.add(new DispositivoMovil.Tablet("Samsung", "Galaxy Tap"));
        moviles.add(new DispositivoMovil.Tablet("Huawei", "Mate Pad"));

        List<DispositivoElectronico> electrodomesticos = new ArrayList<>();
        //list of appliances
        articulosPredefinidos.put("Electrodomesticos", electrodomesticos);
        electrodomesticos.add(new Electrodomestico("Mabe", "RPM410FZPC"));
        electrodomesticos.add(new Electrodomestico.Refrigerador("LG", "Side By Side LS66SXT No Frost 617L"));
        electrodomesticos.add(new Electrodomestico.Refrigerador("Frigidaire", "FPRU19F8WF 535L"));
        electrodomesticos.add(new Electrodomestico.Refrigerador("Samsung", "RS60T5200B1"));

        List<DispositivoElectronico> computadoras = new ArrayList<>();
        articulosPredefinidos.put("Computadoras", computadoras);
        //Laptop List
        computadoras.add(new Computadora.Laptop("HP", "Pavilion"));
        computadoras.add(new Computadora.Laptop("Apple", "MacBook Pro"));
        computadoras.add(new Computadora.Laptop("Lenovo", "IdeaPad"));
        computadoras.add(new Computadora.Laptop("Asus", "ROG"));
        //Desktop Computer List
        computadoras.add(new Computadora.Desktop("HP Envy 34 All-in-One", "HP"));
        computadoras.add(new Computadora.Desktop("Apple iMac M1", "Apple"));
        computadoras.add(new Computadora.Desktop("Lenovo Legion Tower", "Lenovo"));
        computadoras.add(new Computadora.Desktop("HP Chromebase 22", "HP"));
    }

    //Seleccion del tipo de articulo
    public void mostrarYSeleccionarArticulos() {
        Scanner scanner = new Scanner(System.in);
        int tipoIndex = 1;
        Map<Integer, String> tipoMap = new HashMap<>();

        System.out.println("Seleccione un tipo de artículo:");
        for (String tipo : articulosPredefinidos.keySet()) {
            System.out.println(tipoIndex + ". " + tipo);
            tipoMap.put(tipoIndex, tipo);
            tipoIndex++;
        }

        int tipoSeleccionado = scanner.nextInt();
        scanner.nextLine();
        String tipo = tipoMap.get(tipoSeleccionado);

        if (tipo != null) {
            switch (tipo) {
                case "Dispositivos Moviles":
                    mostrarSubcategoriasMoviles(scanner);
                    break;
                case "Computadoras":
                    mostrarSubcategoriasComputadoras(scanner);
                    break;
                case "Electrodomesticos":
                    mostrarSubcategoriasElectrodomesticos(scanner);
                    break;
                default:
                    mostrarArticulos(tipo, scanner);
                    break;
            }
        } else {
            System.out.println("Selección no válida.");
        }
    }

    //Categorias de los dispositivos moviles
    private void mostrarSubcategoriasMoviles(Scanner scanner) {
        System.out.println("Seleccione una subcategoría de Dispositivos Móviles:");
        System.out.println("1. Smartphones");
        System.out.println("2. Tablets");
        int categoria = scanner.nextInt();
        scanner.nextLine();

        if (categoria == 1) {
            mostrarArticulos("Smartphones", scanner);
        } else if (categoria == 2) {
            mostrarArticulos("Tablets", scanner);
        } else {
            System.out.println("Selección no válida.");
        }
    }
//Categoria de las computadoras
    private void mostrarSubcategoriasComputadoras(Scanner scanner) {
        System.out.println("Seleccione una subcategoría de Computadoras:");
        System.out.println("1. Laptops");
        System.out.println("2. Desktops");
        int categoria = scanner.nextInt();
        scanner.nextLine();

        if (categoria == 1) {
            mostrarArticulos("Laptops", scanner);
        } else if (categoria == 2) {
            mostrarArticulos("Desktops", scanner);
        } else {
            System.out.println("Selección no válida.");
        }
    }
//Lista de electrodomesticos
    private void mostrarSubcategoriasElectrodomesticos(Scanner scanner) {
        System.out.println("Seleccione una subcategoría de Electrodomésticos:");
        System.out.println("1. Refrigeradores");
        int subIndex = scanner.nextInt();
        scanner.nextLine();

        if (subIndex == 1) {
            mostrarArticulos("Refrigeradores", scanner);
        } else {
            System.out.println("Selección no válida.");
        }
    }

    //Mostrar los articulos usando listas y validando que estos existan el la categoria
    private void mostrarArticulos(String categoria, Scanner scanner) {
        List<DispositivoElectronico> articulos = new ArrayList<>();
        for (List<DispositivoElectronico> lista : articulosPredefinidos.values()) {
            for (DispositivoElectronico articulo : lista) {
                if (categoria.equals("Smartphones") && articulo instanceof DispositivoMovil.Smartphone) {
                    articulos.add(articulo);
                } else if (categoria.equals("Tablets") && articulo instanceof DispositivoMovil.Tablet) {
                    articulos.add(articulo);
                } else if (categoria.equals("Laptops") && articulo instanceof Computadora.Laptop) {
                    articulos.add(articulo);
                } else if (categoria.equals("Desktops") && articulo instanceof Computadora.Desktop) {
                    articulos.add(articulo);
                } else if (categoria.equals("Refrigeradores") && articulo instanceof Electrodomestico.Refrigerador) {
                    articulos.add(articulo);
                }
            }
        }

        int agregarArticulo = 1;
        Map<Integer, DispositivoElectronico> articuloMap = new HashMap<>();

        System.out.println("Seleccione un artículo para agregar a la lista de deseos:");
        for (DispositivoElectronico articulo : articulos) {
            System.out.println(agregarArticulo + ". " + articulo.getNombre() + " - " + articulo.getModelo());
            articuloMap.put(agregarArticulo, articulo);
            agregarArticulo++;
        }

        int articuloSeleccionado = scanner.nextInt();
        scanner.nextLine();
        DispositivoElectronico articulo = articuloMap.get(articuloSeleccionado);

        if (articulo != null) {
            listaDeseos.add(articulo);
            System.out.println("Artículo agregado a la lista de deseos.");
        } else {
            System.out.println("Selección no válida.");
        }
    }

    public void mostrarListaDeseos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lista de deseos:");
        int listaDeArticulos = 1;
        for (DispositivoElectronico articulo : listaDeseos) {
            System.out.println(listaDeArticulos + ". " + articulo.getNombre() + " - " + articulo.getModelo());
            listaDeArticulos++;
        }

        System.out.println("¿Desea eliminar algún artículo de la lista? (Y/N o y/n)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Y") || respuesta.equalsIgnoreCase("y")) {
            System.out.println("Ingrese el numero del artículo a eliminar:");
            int eliminar = scanner.nextInt();
            scanner.nextLine();
            eliminarArticuloDeseos(eliminar);
        }
    }

    public void eliminarArticuloDeseos(int remover) {
        if (remover > 0 && remover <= listaDeseos.size()) {
            DispositivoElectronico eliminado = listaDeseos.remove(remover - 1);
            System.out.println("Artículo eliminado de la lista de deseos: " + eliminado.getNombre());
        } else {
            System.out.println("numero no válido.");
        }
    }
}