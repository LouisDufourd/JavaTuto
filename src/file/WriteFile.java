package file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFile {
    /**
     *
     * @param file le chemin du fichier
     * @param message les données à mettre dans le fichier
     * @throws IOException si la connection est subitement coupé (clé usb débrancher)
     */
    public static void writeBinaryFile(Path file, byte[] message) throws IOException {
        if(!Files.exists(file)) { //vérifie si le fichier n'existe pas
            Files.createFile(file); //si oui, on crée un fichier
        }
        OutputStream os = Files.newOutputStream(file); //ouvre un flux pour écrire
        BufferedOutputStream bos = new BufferedOutputStream(os); //met dans une mémoire tampon les données
        DataOutputStream dos = new DataOutputStream(bos); //Pour mettre les données dans un format donné
        dos.write(message); //on écrit dans le fichier
        dos.close(); //ferme le flux et sauvegarde les modifications
    }

    public static void writeTextFile(Path file, String text) throws IOException {
        if(!Files.exists(file)) { //vérifie si le fichier n'existe pas
            Files.createFile(file); //s'il n'existe pas, on crée un fichier
        }
        OutputStream os = Files.newOutputStream(file); //on ouvre un flux pour lire
        OutputStreamWriter osw = new OutputStreamWriter(os); //on ouvre un flux qui va lire le texte dans le fichier
        BufferedWriter bw = new BufferedWriter(osw); //on met les données dans une mémoire tampon
        bw.write(text); //on écrit le text dans le fichier
        bw.close();
    }
}
