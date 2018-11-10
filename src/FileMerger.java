import java.io.*;

public class FileMerger {
    private String firstFileLocation;
    private String secondFileLocation;
    private String destination;

    public FileMerger(String firstFileLocation, String secondFileLocation, String destination) {
        this.firstFileLocation = firstFileLocation;
        this.secondFileLocation = secondFileLocation;
        this.destination = destination;
    }

    public void Merge() {
        File file1 = new File(firstFileLocation);
        File file2 = new File(secondFileLocation);
        int file1FormatPosition = file1.getName().lastIndexOf(".");
        int file2FormatPosition = file2.getName().lastIndexOf(".");

        File file3 = new File(destination, file1.getName().substring(0, file1FormatPosition)+ "_"+file2.getName().substring(0,file2FormatPosition)+".txt");

        if (file3.exists()) {
                    System.out.println("Such a file exists");
                    return;
        }
        try (BufferedReader file1BufferedReader = new BufferedReader(new FileReader(file1));
             BufferedReader file2BufferedReader = new BufferedReader(new FileReader(file2));
             BufferedWriter file3BufferedWriter = new BufferedWriter(new FileWriter(file3))
        ) {
            String str;
            while ((str = file1BufferedReader.readLine()) != null) {
                file3BufferedWriter.write(str);
                file3BufferedWriter.write('\n');
            }
            while ((str = file2BufferedReader.readLine()) != null) {
                file3BufferedWriter.write(str);
                file3BufferedWriter.write('\n');
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find a file " + ex);
        } catch (IOException ex) {
            System.out.println("I/O Exception " + ex);
        }
    }
}
