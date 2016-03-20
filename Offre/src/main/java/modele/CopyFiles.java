package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class CopyFiles {
    private File targetFolder;
    private int noOfFiles;
    public void copyDirectory(File sourceLocation, String destLocation)
            throws IOException {
        targetFolder = new File(destLocation);
        if (sourceLocation.isDirectory()) {
            if (!targetFolder.exists()) {
                targetFolder.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        destLocation);

            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetFolder + "/"+ sourceLocation.getName(), true);
            System.out.println("Destination Path ::"+targetFolder + "/"+ sourceLocation.getName());            
            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            noOfFiles++;
        }
    }

   
}