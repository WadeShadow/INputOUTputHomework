import java.io.*;

public class Copier {
    private String resourseDirectoryPath;
    private String destinationDirectoryPath;

    public Copier(String resourseDirectoryPath, String destinationDirectoryPath) {
        if (resourseDirectoryPath == null)
            resourseDirectoryPath = "SourceDir";
        if (destinationDirectoryPath == null)
            destinationDirectoryPath = "DestinationDir";
        this.resourseDirectoryPath = resourseDirectoryPath;
        this.destinationDirectoryPath = destinationDirectoryPath;
    }


    public void copy(String format) {

        File sourceDirectory = new File(resourseDirectoryPath);
        File destinationDirectory = new File(destinationDirectoryPath);
        FilenameFilter filter = new ExtensionFilter(format);
        if (sourceDirectory.isDirectory() && destinationDirectory.isDirectory()) {
            File[] sourceFiles = sourceDirectory.listFiles(filter);
            for (File file : sourceFiles) {
                File destFile = new File(destinationDirectoryPath, file.getName());
                if (destFile.exists()) continue;                                                                                    // In case such a file already exists we shouldn't delete it
                try (BufferedReader fileReader =new BufferedReader(new FileReader(file)) ;
                     BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
                    String str ;
                   while ((str = fileReader.readLine())!=null){
                       fileWriter.write(str);
                    }


                } catch (FileNotFoundException ex) {
                    System.out.println("There are no such file in directory " + ex);
                } catch (IOException ex) {
                    System.out.println("I/O Exception " + ex);
                }
            }
        }

    }


    public void setResourseDirectoryPath(String resourseDirectoryPath) {
        this.resourseDirectoryPath = resourseDirectoryPath;
    }

    public void setDestinationDirectoryPath(String destinationDirectoryPath) {
        this.destinationDirectoryPath = destinationDirectoryPath;
    }

    public String getResourseDirectoryPath() {
        return resourseDirectoryPath;
    }

    public String getDestinationDirectoryPath() {
        return destinationDirectoryPath;
    }

}

