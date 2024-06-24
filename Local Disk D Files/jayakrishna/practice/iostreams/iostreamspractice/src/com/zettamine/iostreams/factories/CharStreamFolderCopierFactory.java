package com.zettamine.iostreams.factories;

import com.zettamine.iostreams.copiers.CharStreamFolderCopier;
import com.zettamine.iostreams.copiers.FolderCopier;

public class CharStreamFolderCopierFactory implements CopierFactory {

	@Override
	public FolderCopier createFileCopier() {
		return new CharStreamFolderCopier();
	}

}
