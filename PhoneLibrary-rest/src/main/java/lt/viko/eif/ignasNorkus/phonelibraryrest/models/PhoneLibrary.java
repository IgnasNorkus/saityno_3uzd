/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.ignasNorkus.phonelibraryrest.models;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A base .xml element and a POJO object
 *
 * @author Acer
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneLibrary {

    @XmlElementWrapper(name = "phones")
    @XmlElement(name = "phone")
    private List<Phone> phones;

    /**
     * Returns a phone from the phones list, based on its id property
     *
     * @param id value by which the search is conducted
     * @return a phone that matches the id
     */
    public Phone getPhone(long id) {
        int index = getPhoneIndex(id);
        if (index != -1){
            return phones.get(index);
        }
        return null;
    }

    /**
     * Returns an index of phone from phones list based on its id property
     * @param id value by which the search is conducted
     * @return index of a phone that matches the id
     */
    public int getPhoneIndex(long id) {
        for (int i = 0; i < phones.size(); i++){
            if (phones.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * finds a phone from phones list based on its id and replaces it
     * @param phone phone with which the original is going to be replaced
     */
    public void replacePhone(Phone phone){
        int index = getPhoneIndex(phone.getId());
        if (index != -1){
            phones.set(index, phone);
        }
    }

    /**
     * removes a phone from phones list based on its id property
     * @param id value by which the object is selected
     */
    public void removePhone(int id){
        Phone phone = getPhone(id);
        if (phone != null){
            phones.remove(phone);
        }
    }

    /**
     * Gets the property List Phone of phones associated with this account
     *
     * @return List Phone phone
     */

    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * Sets the property List Phone of phones associated with this account
     *
     * @param phones a List Phone property
     */
    public void setPhone(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * Adds a phone to the list Phone phones
     *
     * @param phone an object to be added
     */
    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    /**
     * Removes a phone from the List Phone phones if iteratedValue.getTitle()
     * equals title received
     *
     * @param model_name value by which phone is removed
     */
    public void removePhone(String model_name) {
        phones.removeIf(x -> x.getModel_name().equals(model_name));
    }

    /**
     * Changes an object from the List Phone phones based on iteratedValue.getModel_name()
     * equals getModel_name received
     *
     * @param model_name value by which a phone is to be replaced
     * @param phone  object which is going to replace the current one
     */
    public void updatePhone(String model_name, Phone phone) {
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getModel_name().equals(model_name)) {
                phones.set(i, phone);
                break;
            }
        }
    }

    /**
     * Converts all properties to a single string object
     *
     * @return a formatted string of all the properties
     */
    @Override
    public String toString() {
        return String.format("Phone library:\n"
                + "\tPhones:\n"
                + "%s",phones);
    }
}
