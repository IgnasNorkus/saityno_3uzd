/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.ignasNorkus.phonelibraryrest.models;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * A POJO object
 *
 * @author Ignas Norkus
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {

    private long id;
    private String model_name;
    private Integer year_released;
    private String display_resolution;
    private String chipset;
    private Boolean still_updated;
    private Memory memory;
    private Manufacture manufacture;

    /**
     * Gets id property
     *
     * @return id - a long property
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id String property
     *
     * @param id - a long property
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets model_name property
     *
     * @return model_name - a String property
     */
    public String getModel_name() {
        return model_name;
    }

    /**
     * Sets model_name String property
     *
     * @param model_name - a String property
     */
    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    /**
     * Gets year_released property
     *
     * @return year_released - an Integer property
     */
    public Integer getYear_released() {
        return year_released;
    }

    /**
     * Sets year_released Integer property
     *
     * @param year_released - an Integer property
     */
    public void setYear_released(Integer year_released) {
        this.year_released = year_released;
    }

    /**
     * Gets display_resolution property
     *
     * @return display_resolution - a String property
     */
    public String getDisplay_resolution() {
        return display_resolution;
    }

    /**
     * Sets display_resolution String property
     *
     * @param display_resolution - String property
     */
    public void setDisplay_resolution(String display_resolution) {
        this.display_resolution = display_resolution;
    }

    /**
     * Gets chipset property
     *
     * @return chipset - a String property
     */
    public String getChipset() {
        return chipset;
    }

    /**
     * Sets chipset String property
     *
     * @param chipset - a String property
     */
    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    /**
     * Gets still_updated property
     *
     * @return still_updated - a Boolean property
     */
    public Boolean getStill_updated() {
        return still_updated;
    }

    /**
     * Sets still_updated Boolean property
     *
     * @param still_updated - a Boolean property
     */
    public void setStill_updated(Boolean still_updated) {
        this.still_updated = still_updated;
    }

    /**
     * Gets manufacture property
     *
     * @return manufacture - a Manufacture property
     */
    public Manufacture getManufacture() {
        return manufacture;
    }

    /**
     * Sets manufacture Manufacture property
     *
     * @param manufacture - a Manufacture property
     */
    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * Gets memory property
     *
     * @return memory - a Memory property
     */
    public Memory getMemory() {
        return memory;
    }

    /**
     * Sets memory Memory property
     *
     * @param memory - a Memory property
     */
    public void setMemory(Memory memory) {
        this.memory = memory;
    }


    /**
     * Converts all properties to a single string object
     *
     * @return a formatted string of all the properties
     */
    @Override
    public String toString() {
        return String.format("\t\tManufacture: %s\n"
                + "\t\tModel_name: %s\n"
                + "\t\tYear_released: %s\n"
                + "\t\tDisplay_resolution: %s\n"
                + "\t\tChipset: %s\n"
                + "\t\tMemory: %s\n"
                + "\t\tStill_updated: %s\n",
                manufacture, model_name, year_released, display_resolution, chipset, memory, still_updated);
    }
}
