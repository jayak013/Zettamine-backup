package com.zettamine.iostreams.factories;

import com.zettamine.iostreams.copiers.FolderCopier;

public class FolderCopierApplication {
	
	private CopierFactory copierFactory;
	private FolderCopier folderCopier;
	
	public FolderCopierApplication(CopierFactory copierFactory) {
		this.copierFactory = copierFactory;
	}
	
	public void createFolderCopier() {
		folderCopier = copierFactory.createFileCopier();
		System.out.println("Instantiated the Folder Copier = "+folderCopier.getClass().getSimpleName()+"...\n");
	}
	
	public void runFolderCopier(String sourceFolder,String destinationFolder) {
		System.out.println("Inside runFolderCopier(2args)\n");
		folderCopier.replicate(sourceFolder, destinationFolder);
		System.out.println("All Folder and files copied successfully\n");
		System.out.println("Outside runFolderCopier(2args)\n");
	}
	
}
