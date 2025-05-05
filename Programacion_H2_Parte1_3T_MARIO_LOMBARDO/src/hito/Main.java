package hito;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Mostramos el menú
        do {
            System.out.println("------ MENÚ ------");
            System.out.println("1 – Ver películas");
            System.out.println("2 – Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = 0;
            try {
            	// Leemos la opción del usuario
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Mostramos un error si el usuario ingresa un valor inválido
                System.out.println("Error: Debes ingresar un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    // Ver películas
                    Cine.mostrarPeliculas();
                    break;
                case 2:
                    // Salir
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Mostramos un mensaje si la opción no es válida
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (continuar);
        
        // Cerramos el scanner
        scanner.close();
    }
}