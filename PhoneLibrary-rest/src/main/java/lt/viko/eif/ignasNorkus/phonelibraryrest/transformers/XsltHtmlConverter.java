/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.ignasNorkus.phonelibraryrest.transformers;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Ignas
 */
public class XsltHtmlConverter {

    /**
     * Converts received xml data into a .html file to the provided path
     * @param xslPath - String path to the .xsl path
     * @param xmlData - String of the xml data
     * @param htmlOutputPath - String path of the location where the file should be created
     * @throws TransformerConfigurationException thrower
     * @throws TransformerException exception
     */
    public static void convertData(String xslPath, String xmlData, String htmlOutputPath) throws TransformerConfigurationException, TransformerException {
        Source xslt = new StreamSource(new File(xslPath));
        Source xml = new StreamSource(new StringReader(xmlData));
        Result out = new StreamResult(new File(htmlOutputPath));

        TransformerFactory factory = TransformerFactory.newInstance();
        //factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

        Transformer transformer = factory.newTransformer(xslt);
        transformer.transform(xml, out);
    }

    /**
     * Converts String xml data into html data
     * @param xslPath path to the xsl path
     * @param xmlData String xml data
     * @return String html data
     * @throws TransformerConfigurationException meta
     * @throws TransformerException meta
     */
    public static String convertData(String xslPath, String xmlData) throws TransformerConfigurationException, TransformerException {
        Source xslt = new StreamSource(new File(xslPath));
        Source xml = new StreamSource(new StringReader(xmlData));
        StringWriter outWriter = new StringWriter();
        StreamResult result = new StreamResult(outWriter);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xslt);
        transformer.transform( xml, result );
        StringBuffer sb = outWriter.getBuffer();
        return sb.toString();
    }

    /**
     * Converts xml file into html file using html
     * @param xslPath path to the xsl file
     * @param xmlPath path to the xml file
     * @param htmlOutputPath path to output the html file
     * @throws TransformerConfigurationException meta
     * @throws TransformerException meta
     */
    public static void convertFile(String xslPath, String xmlPath, String htmlOutputPath) throws TransformerConfigurationException, TransformerException {
        Source xslt = new StreamSource(new File(xslPath));
        Source xml = new StreamSource(new File(xmlPath));
        Result out = new StreamResult(new File(htmlOutputPath));

        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

        Transformer transformer = factory.newTransformer(xslt);
        transformer.transform(xml, out);
    }
}
