import com.sun.source.tree.BinaryTree;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in); // Variable que obtiene le input
        boolean exit = false; // Variable de control para salir del menú
    }

    public static String getNumber(Scanner keyboard) {
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }

    public static BinaryTree getWords (String option) {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado

        BufferedReader buffer = null; // Lee el archivo

        try {
            buffer = new BufferedReader(new FileReader(dir));
            String line = buffer.readLine();

            while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
                String[] info = line.split("\\|");

                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
