import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in); // Variable que obtiene le input
        boolean exit = false; // Variable de control para salir del menú

        while (!exit) {
            int option = 0;

            while (!exit) {
                System.out.println("Ingrese el número de la opción a realizarse. ¿Desde qué idioma desea traducir? \n 1. Inglés \n 2. Francés \n 3. Español");
                option = getNumber(keyboard);

                if (option >= 0 && option <= 3) {
                    exit = true;
                } else {
                    System.out.println("ERROR. La opción ingresada no se encuentra disponible.");
                }
            }

            BinarySearchTree<ComparableAssociation<String, Word>> data = getWords(option);

            while (exit) {
                System.out.println("Ingrese el número de la opción a realizarse. ¿A qué idioma desea traducir? \n 1. Inglés \n 2. Francés \n 3. Español");
                option = getNumber(keyboard);

                if (option >= 0 && option <= 3) {
                    exit = false;
                } else {
                    System.out.println("ERROR. La opción ingresada no se encuentra disponible.");
                }
            }

            String phrase = getFile();

            String[] words = phrase.split(" ");
            String traduction = "";

            for (int i = 0; i < words.length; i++) {
                String uword = words[i];;
                words[i] = words[i].replaceAll("\\p{Punct}", "");

                ComparableAssociation<String, Word> found = data.find(new ComparableAssociation<String, Word>(words[i]));

                if (found.getValue() != null) {
                    traduction = traduction + " " + uword.replace(words[i], found.getValue().getWord(option));
                } else {
                    traduction = traduction + " " + "*" + uword + "*";
                }
            }

            System.out.println(traduction);

            System.out.println("Ingrese el número de la opción a realizarse. ¿Desea realizar otra traducción? \n 1. Si \n 2. No");
            option = getNumber(keyboard);

            if (option == 2) {
                exit = true;
            }
        }
        System.exit(0);
    }

    public static Integer getNumber(Scanner keyboard) {
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

        return Integer.valueOf(number);
    }

    public static BinarySearchTree<ComparableAssociation<String, Word>> getWords (int option) {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado
        BinarySearchTree<ComparableAssociation<String, Word>> data = new BinarySearchTree<>();
        BufferedReader buffer = null; // Lee el archivo

        try {
            buffer = new BufferedReader(new FileReader(dir));
            String line = buffer.readLine();

            while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
                String[] info = line.split(",");
                Word word = new Word(info[0], info[1], info[2]);

                data.add(new ComparableAssociation<String, Word>(word.getWord(option), word));

                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static String getFile () {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado
        String data = "";
        BufferedReader buffer = null; // Lee el archivo

        try {
            buffer = new BufferedReader(new FileReader(dir));
            String line = buffer.readLine();

            while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
                data = data + line + " " ;

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
