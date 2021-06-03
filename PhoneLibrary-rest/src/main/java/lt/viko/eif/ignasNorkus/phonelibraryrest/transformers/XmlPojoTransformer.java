/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.ignasNorkus.phonelibraryrest.transformers;

import lt.viko.eif.ignasNorkus.phonelibraryrest.models.PhoneLibrary;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 * Transforms .xml data to a POJO and a POJO to .xml data
 *
 * @author Ignas
 */
public class XmlPojoTransformer {

    private JAXBContext context;

    /**
     * Initiates JAXBContext context
     */
    public XmlPojoTransformer() {
        try {
            context = JAXBContext.newInstance(PhoneLibrary.class);
        } catch (JAXBException ex) {
            Logger.getLogger(XmlPojoTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.setProperty("javax.xml.accessExternalDTD", "all");
    }

    /**
     * Unmarshals .xml data to a GameLibrary POJO
     *
     * @param xmlContent data that is to be unmarshalled
     * @return a POJO that was made using xmlContent
     */
    public PhoneLibrary transformToPOJO(String xmlContent) {
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlContent);

            return (PhoneLibrary) unmarshaller.unmarshal(reader);
        } catch (JAXBException ex) {
            Logger.getLogger(XmlPojoTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Marshals a GameLibrary POJO to .xml data
     *
     * @param phoneLibrary a POJO that will be marshalled to .xml data
     * @return .xml data that was marshalled from the received POJO
     */
    public String transformToXML(PhoneLibrary phoneLibrary) {
        String transformed = null;
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(phoneLibrary, sw);
            transformed = sw.toString();
        } catch (PropertyException ex) {
            Logger.getLogger(XmlPojoTransformer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(XmlPojoTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transformed;
    }
}
