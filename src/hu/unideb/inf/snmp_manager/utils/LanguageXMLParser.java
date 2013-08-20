
package hu.unideb.inf.snmp_manager.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author darkfalcon
 */
public class LanguageXMLParser {
    
    private static boolean isName;
    private static boolean isLocale;
    private static boolean isCountry;
    
    public ArrayList<Language> parseLanguages() {
       
        ArrayList<Language> list = new ArrayList<>();
        Language language = null;
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader parser = factory.createXMLStreamReader(
                    new FileInputStream("language.xml"));
            int event = parser.getEventType();
            
            while(true) {
                switch(event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if(parser.getLocalName().equals("Language")) {
                            language = new Language();
                            language.setId(Integer.parseInt(
                                    parser.getAttributeValue(0)));
                        } else if (parser.getLocalName().equals("name")) {
                            isName = true;
                        } else if (parser.getLocalName().equals("locale")) {
                            isLocale = true;
                        } else if (parser.getLocalName().equals("country")) {
                            isCountry = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (isName) {
                            //System.out.println(parser.getText());
                            language.setName(parser.getText());
                            isName = false;
                        } else if (isLocale) {
                            //System.out.println(parser.getText());
                            language.setLocale(parser.getText());
                            isLocale = false;
                        } else if (isCountry) {
                            //System.out.println(parser.getText());
                            language.setCountry(parser.getText());
                            isCountry = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("Language")) {
                            list.add(language);
                        }
                        break;
                }
                if (! parser.hasNext()) {
                    break;
                }
                event = parser.next();
            }
            
        } catch(FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        
        return list;
    }
}