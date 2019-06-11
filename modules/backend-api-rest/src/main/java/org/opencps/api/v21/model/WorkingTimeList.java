//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.11 at 10:03:09 AM ICT 
//


package org.opencps.api.v21.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkingTime" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="workTimeDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="workTimeHours">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "workingTime"
})
@XmlRootElement(name = "WorkingTimeList")
public class WorkingTimeList {

    @XmlElement(name = "WorkingTime", required = true)
    protected List<WorkingTimeList.WorkingTime> workingTime;

    /**
     * Gets the value of the workingTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workingTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkingTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkingTimeList.WorkingTime }
     * 
     * 
     */
    public List<WorkingTimeList.WorkingTime> getWorkingTime() {
        if (workingTime == null) {
            workingTime = new ArrayList<WorkingTimeList.WorkingTime>();
        }
        return this.workingTime;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="workTimeDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="workTimeHours">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "workTimeDay",
        "workTimeHours"
    })
    public static class WorkingTime {

        protected int workTimeDay;
        @XmlElement(required = true)
        protected String workTimeHours;

        /**
         * Gets the value of the workTimeDay property.
         * 
         */
        public int getWorkTimeDay() {
            return workTimeDay;
        }

        /**
         * Sets the value of the workTimeDay property.
         * 
         */
        public void setWorkTimeDay(int value) {
            this.workTimeDay = value;
        }

        /**
         * Gets the value of the workTimeHours property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkTimeHours() {
            return workTimeHours;
        }

        /**
         * Sets the value of the workTimeHours property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkTimeHours(String value) {
            this.workTimeHours = value;
        }

    }

}
