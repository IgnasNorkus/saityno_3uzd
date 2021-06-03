package lt.viko.eif.ignasNorkus.phonelibraryrest.repoes;

import lt.viko.eif.ignasNorkus.phonelibraryrest.models.Phone;
import lt.viko.eif.ignasNorkus.phonelibraryrest.models.PhoneLibrary;
import lt.viko.eif.ignasNorkus.phonelibraryrest.transformers.XmlPojoTransformer;
import lt.viko.eif.ignasNorkus.phonelibraryrest.utilities.FileReader;
import java.util.List;

/**
 *Repository that is responsible PhoneLibrary
 */
public class PhoneLibraryRepository {
    private static PhoneLibrary phoneLibrary;
    private static String xmlPath = "phoneLibrary.xml";
    private static String xsmlPath = "phoneLibraryToHTML.xsl";

    /**
     * Sets up phoneLibrary by reading data from xml file and unmarshalling it
     */
    static {
        String xmlData = FileReader.readFile(xmlPath);
        XmlPojoTransformer xmlPojoTransformer = new XmlPojoTransformer();
        phoneLibrary = xmlPojoTransformer.transformToPOJO(xmlData);
        if (phoneLibrary != null) {
            List<Phone> phones = phoneLibrary.getPhones();
            for (int i = 0; i < phones.size(); i++){
                Phone phone = phones.get(i);
                if(phone.getId() == 0){
                    phone.setId(i);
                }
            }
        }
    }

    /**
     * Gets PhoneLibrary phoneLibrary object
     * @return phoneLibrary
     */
    public PhoneLibrary getPhoneLibrary() {
        return phoneLibrary;
    }

    /**
     * Sets phoneLibrary
     * @param phoneLibrary object to replace the current one
     */
    public static void setPhoneLibrary(PhoneLibrary phoneLibrary) {
        PhoneLibraryRepository.phoneLibrary = phoneLibrary;
    }

    /**
     * Gets path to the xml file
     * @return String data
     */
    public String getXmlPath() {
        return xmlPath;
    }

    /**
     * Sets path to the xml File
     * @param xmlPath path to the xmlFile
     */
    public void setXmlPath(String xmlPath) {
        PhoneLibraryRepository.xmlPath = xmlPath;
    }

    /**
     * Gets path to the xsml file
     * @return xsml file path
     */
    public String getXsmlPath() {
        return xsmlPath;
    }

    /**
     * Sets path to the xsml File
     * @param xsmlPath path to the file
     */
    public void setXsmlPath(String xsmlPath) {
        PhoneLibraryRepository.xsmlPath = xsmlPath;
    }
}
