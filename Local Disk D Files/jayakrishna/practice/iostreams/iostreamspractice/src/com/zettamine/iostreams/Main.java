package com.zettamine.iostreams;

import com.zettamine.iostreams.factories.ByteStreamFolderCopierFactory;
import com.zettamine.iostreams.factories.CharStreamFolderCopierFactory;
import com.zettamine.iostreams.factories.FolderCopierApplication;

public class Main extends Thread{
	
	public static final String SOURCE_DIRECTORY = "C:\\Users\\S Jaya Krishna\\Desktop\\Test\\Folder 1";
	public static final String DESTINATION_DIRECTORY = "C:\\Users\\S Jaya Krishna\\Desktop\\Test\\Folder 2";
	
	public static void main(String[] args) {
		Thread t = new Main();
		t.start();
	}
	
	public void run() {
		FolderCopierApplication app1 = new FolderCopierApplication(new CharStreamFolderCopierFactory());
		app1.createFolderCopier();
		app1.runFolderCopier(SOURCE_DIRECTORY,DESTINATION_DIRECTORY );
		
//		FolderCopierApplication app = new FolderCopierApplication(new ByteStreamFolderCopierFactory());
//		app.createFolderCopier();
//		app.runFolderCopier(SOURCE_DIRECTORY,DESTINATION_DIRECTORY );
	}
}
















/*
 * //Usage public class Main { public static void main(String[] args) { //
 * Creating Windows Application Application windowsApp = new Application(new
 * WindowsFactory()); windowsApp.createUI(); windowsApp.renderUI();
 * 
 * // Creating MacOS Application Application macosApp = new Application(new
 * MacOSFactory()); macosApp.createUI(); macosApp.renderUI(); } }
 */
/*
 * //Abstract Product A interface Button { void render(); }
 * 
 * //Concrete Product A1 class WindowsButton implements Button { public void
 * render() { System.out.println("Rendering Windows Button"); } }
 * 
 * //Concrete Product A2 class MacOSButton implements Button { public void
 * render() { System.out.println("Rendering MacOS Button"); } }
 * 
 * //Abstract Factory interface GUIFactory { Button createButton(); }
 * 
 * //Concrete Factory 1 class WindowsFactory implements GUIFactory { public
 * Button createButton() { return new WindowsButton(); } }
 * 
 * //Concrete Factory 2 class MacOSFactory implements GUIFactory { public Button
 * createButton() { return new MacOSButton(); } }
 * 
 * //Client class Application { private GUIFactory factory; private Button
 * button;
 * 
 * public Application(GUIFactory factory) { this.factory = factory; }
 * 
 * public void createUI() { button = factory.createButton(); }
 * 
 * public void renderUI() { button.render(); } }
 */
