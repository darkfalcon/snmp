
package hu.unideb.inf.snmp_manager.classes;

import hu.unideb.inf.snmp_manager.forms.LanguageWindow;
import hu.unideb.inf.snmp_manager.forms.MainWindow;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author darkfalcon
 */
public class Main {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("Config");
        if(bundle.getString("save").equals("0")) {
            LanguageWindow lw = new LanguageWindow();
            lw.lookAndFeel();
        } else {
            String language = bundle.getString("language");
            Locale locale = null;
            if (language.equals("EN"))
                locale = new Locale("en", "EN");
            if (language.equals("HU"))
                locale = new Locale("hu", "HU");
            MainWindow mw = new MainWindow(locale);
            mw.lookAndFeel();
        }
        
        
    }
}
