/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.ignasNorkus.phonelibraryrest.models;

import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author Ignas Norkus
 */
public class Memory {
    private Integer storage_memory;
    private String storage_unit;
    private Integer ram;
    private String ram_unit;

    /**
     * Gets storage_memory property
     *
     * @return storage_memory - an Integer property
     */
    public Integer getStorage_memory() {
        return storage_memory;
    }

    /**
     * Sets storage_memory String property
     *
     * @param storage_memory - an Integer property
     */
    public void setStorage_memory(Integer storage_memory) {
        this.storage_memory = storage_memory;
    }

    /**
     * Gets storage_unit property
     *
     * @return storage_unit - a String property
     */
    public String getStorage_unit() {
        return storage_unit;
    }

    /**
     * Sets storage_unit String property
     *
     * @param storage_unit - a String property
     */
    public void setStorage_unit(String storage_unit) {
        this.storage_unit = storage_unit;
    }

    /**
     * Gets ram property
     *
     * @return ram - an Integer property
     */
    public Integer getRam() {
        return ram;
    }

    /**
     * Sets ram String property
     *
     * @param ram - an Integer property
     */
    public void setRam(Integer ram) {
        this.ram = ram;
    }

    /**
     * Gets ram_unit property
     *
     * @return ram_unit - a String property
     */
    public String getRam_unit() {
        return ram_unit;
    }

    /**
     * Sets ram_unit String property
     *
     * @param ram_unit - a String property
     */
    public void setRam_unit(String ram_unit) {
        this.ram_unit = ram_unit;
    }
    
    @Override
    public String toString() {
        return String.format("\n\t\t\tStorage_memory: %s\n"
                + "\t\t\tStorage_unit: %s\n"
                + "\t\t\tRam: %s\n"
                + "\t\t\tRam_unit: %s\n",
                storage_memory, storage_unit, ram, ram_unit);
    }
}
