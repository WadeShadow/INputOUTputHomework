import java.io.*;

public class IOMain {
    public static void main(String[] args) {
        Copier copier = new Copier("SourceDir", "DestinationDir");
        copier.copy("doc");


        /*File destFile = new File("C:\\Java\\Java-Course\\Homework\\INputOUTputHomework\\DestinationDir\\2.doc");
        try(FileReader fileReader = new FileReader(destFile)){
            int i;
            do{
                i = fileReader.read();
                if(i!=-1) System.out.print((char) i);
            }while(i!=-1);
        }catch(IOException ex){
            System.out.println("I/O Exception " +ex);
        }   */      //Outputs an expected string for 1.doc, but a lot of pointless chars in 2.doc

        FileMerger fileMerger = new FileMerger("SourceDir/other.txt", "SourceDir/other1.txt", "DestinationDir");
        fileMerger.Merge();
    }
}
