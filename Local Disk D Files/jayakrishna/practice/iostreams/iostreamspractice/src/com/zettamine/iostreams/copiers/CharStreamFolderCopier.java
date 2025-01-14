package com.zettamine.iostreams.copiers;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamFolderCopier implements FolderCopier {

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
                    try (Reader in = new FileReader(file);
                         Writer out = new FileWriter(destination)) {
                        char[] buffer = new char[1024];
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

