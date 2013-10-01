
package hu.unideb.inf.snmp_manager.classes;

import hu.unideb.inf.snmp_manager.forms.LanguageWindow;
import hu.unideb.inf.snmp_manager.forms.MainWindow;
import hu.unideb.inf.snmp_manager.utils.IPUtil;
import java.awt.Frame;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;

/**
 *
 * @author darkfalcon
 */
public class Main {
    public static void main(String[] args) {
        IPUtil util = new IPUtil();
        System.out.println(util.getAssignableAddressesCount("192.168.129.0", "0"));
//        ResourceBundle bundle = ResourceBundle.getBundle("Config");
//        //if the language setting is not saved, start the language window
//        if(bundle.getString("save").equals("0")) {
//            LanguageWindow lw = new LanguageWindow();
//            lw.lookAndFeel();
//        }
//        //if it is saved, load the language found in the config file, then start
//        //the main window with it
//        else {
//            String language = bundle.getString("language");
//            Locale locale = null;
//            if (language.equals("EN"))
//                locale = new Locale("en", "EN");
//            if (language.equals("HU"))
//                locale = new Locale("hu", "HU");
//            MainWindow mw = new MainWindow(locale);
//            mw.lookAndFeel();
//            mw.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        }
    }
}
