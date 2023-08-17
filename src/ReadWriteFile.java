import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteFile {
    public static byte[] readBinaryFile(String path) throws IOException {
        Path file = Paths.get(path); // convertie le chemin de la chaine de character en objet Path
        if(!Files.exists(file)) { //vérifie si le fichier n'existe pas
            return new byte[0]; //si oui, on retourne un tableau d'octet vide
        }
        InputStream is = Files.newInputStream(file); //on ouvre un flux pour lire
        BufferedInputStream bis = new BufferedInputStream(is); //met dans une mémoire tampon les données
        DataInputStream dis = new DataInputStream(bis); //Pour mettre les données dans un format donné
        byte[] content = dis.readAllBytes(); //Lis tous les octets du fichier
        dis.close(); //ferme le flux et sauvegarde les modifications
        return content; //retourne les données lues
    }

    public static void writeBinaryFile(String path, byte[] message) throws IOException {
        Path file = Paths.get(path); // convertie le chemin de la chaine de character en objet Path
        if(!Files.exists(file)) { //vérifie si le fichier n'existe pas
            Files.createFile(file); //si oui, on crée un fichier
        }
        OutputStream os = Files.newOutputStream(file); //ouvre un flux pour écrire
        BufferedOutputStream bos = new BufferedOutputStream(os); //met dans une mémoire tampon les données
        DataOutputStream dos = new DataOutputStream(bos); //Pour mettre les données dans un format donné
        dos.write(message); //on écrit dans le fichier
        dos.close(); //ferme le flux et sauvegarde les modifications
    }
}
