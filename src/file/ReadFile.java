package file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {

    /**
     *
     * @param file le chemin du fichier
     * @return ce que le programme a lu dans le fichier binaire
     * @throws IOException si la connection est subitement coupé (clé usb débrancher)
     */
    public static byte[] readBinaryFile(Path file) throws IOException {
        if(!Files.exists(file)) { //vérifie si le fichier n'existe pas
            return new byte[0]; //si oui, on retourne un tableau d'octet vide
        }
        InputStream is = Files.newInputStream(file); //on ouvre un flux pour lire
        BufferedInputStream bis = new BufferedInputStream(is); //met dans une mémoire tampon les données
        DataInputStream dis = new DataInputStream(bis); //Pour mettre les données dans un format donné
        byte[] content = bis.readAllBytes(); //Lis tous les octets du fichier
        bis.close(); //ferme le flux et sauvegarde les modifications
        return content; //retourne les données lues
    }


    /**
     *
     * @param file le chemin du fichier
     * @return ce que le programme a lu dans le fichier binaire
     * @throws IOException si la connection est subitement coupé (clé usb débrancher)
     */
    public static String readTextFile(Path file) throws IOException {
        if(!Files.exists(file)) { //vérifie si le fichier n'existe pas
            return ""; //si oui, on retourne une chaine de caractère vide
        }
        InputStream is = Files.newInputStream(file); //on ouvre un flux pour lire
        InputStreamReader isr = new InputStreamReader(is); //on ouvre un flux qui va lire le texte dans le fichier
        BufferedReader br = new BufferedReader(isr); //on met les données dans une mémoire tampon
        StringBuilder read = new StringBuilder(); //StringBuilder permet de créer des chaines de caractères et de les modifier
        Stream<String> lines = br.lines(); //on lit toutes les lignes
        for (String str: lines.toList()) { //on parcourt chaque ligne du fichier
            read.append(str); //on ajoute la ligne lue dans le StringBuilder
        }
        br.close();
        return read.toString(); // on transform le StringBuilder en String et on retourne ce String
    }
}
