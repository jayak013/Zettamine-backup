package com.zettamine.iostreams.copiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamFolderCopier implements FolderCopier {

	@Override
	public void replicate(String sourceFolder, String destinationFolder) {
		
		File sourceDirectory = new File(sourceFolder);
		File destinationDirectory = new File(destinationFolder);
		
		if (sourceDirectory.exists() && sourceDirectory.isDirectory()) {
            if (!destinationDirectory.exists()) {
                destinationDirectory.mkdirs();
            }

            File[] files = sourceDirectory.listFiles();

            for (File file : files) {
                File destination = new File(destinationDirectory, file.getName());

                if (file.isDirectory()) {
                    replicate(file.getAbsolutePath(), destination.getAbsolutePath());
                } else {
                    try (InputStream in = new FileInputStream(file);
                         OutputStream out = new FileOutputStream(destination)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = in.read(buffer)) > 0) {
                            out.write(buffer, 0, length);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Source directory does not exist or is not a directory.");
        }
    }
}


