package com.zettamine.iostreams.factories;

import com.zettamine.iostreams.copiers.ByteStreamFolderCopier;
import com.zettamine.iostreams.copiers.FolderCopier;

public class ByteStreamFolderCopierFactory implements CopierFactory {

	@Override
	public FolderCopier createFileCopier() {
		return new ByteStreamFolderCopier();
	}

}
