package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import javax.swing.*;

import View.Menu;

//dfghjk
// askdjsad

public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	public static final String APP_TITLE = "Web Shop";
	private Menu menu;

	private MainFrame()	{
		Locale.setDefault(new Locale("sr","RS"));
	} 
	
	public static MainFrame getInstance() {
		if (instance == null){
			instance = new MainFrame();
			instance.initGUI();
		}
		
		return instance;
	}
	
	public void initGUI() {
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth *3/ 4, screenHeight *3/ 4);
        menu = new Menu();
		setJMenuBar(menu);
       
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(APP_TITLE);
		setLocationRelativeTo(null);
	}

}
