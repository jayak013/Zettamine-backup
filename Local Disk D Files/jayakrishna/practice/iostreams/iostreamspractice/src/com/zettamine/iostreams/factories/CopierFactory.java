package com.zettamine.iostreams.factories;

import com.zettamine.iostreams.copiers.FolderCopier;

public interface CopierFactory {
	
	FolderCopier createFileCopier();
	
}
