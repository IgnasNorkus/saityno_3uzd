/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.ignasNorkus.phonelibraryrest.models;

import javax.xml.bind.annotation.XmlElement;

/**
 * A POJO object
 * 
 * @author Ignas Norkus
 */
public class Manufacture {
    
    private String name;
    private String url_address;

    /**
     * Gets name property
     *
     * @return name - a String property
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name String property
     *
     * @param name - a String property
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets url_address property
     *
     * @return url_address - a String property
     */
    public String getUrl_address() {
        return url_address;
    }

    /**
     * Sets url_address String property
     *
     * @param url_address - a String property
     */
    public void setUrl_address(String url_address) {
        this.url_address = url_address;
    }
    
    /**
     * Converts all properties to a single string object
     *
     * @return a formatted string of all the properties
     */
    @Override
    public String toString() {
        return String.format("\n\t\t\tName: %s\n"
                + "\t\t\tUrl_address: %s\n",
                name, url_address);
    }
    
}
