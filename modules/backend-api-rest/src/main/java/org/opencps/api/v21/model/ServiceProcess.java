//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.03 at 02:46:10 PM ICT 
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
 *         &lt;element name="processNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="processName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="description">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="durationCount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="durationUnit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="generatePassword" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="serverNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="serverName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dossierNoPattern">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dueDatePattern">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="roles">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProcessRole" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="roleCode">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="roleName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="moderator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="condition">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}steps"/>
 *         &lt;element ref="{}actions"/>
 *         &lt;element ref="{}sequences"/>
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
    "processNo",
    "processName",
    "description",
    "durationCount",
    "durationUnit",
    "generatePassword",
    "serverNo",
    "serverName",
    "dossierNoPattern",
    "dueDatePattern",
    "roles",
    "steps",
    "actions",
    "sequences"
})
@XmlRootElement(name = "ServiceProcess")
public class ServiceProcess {

    @XmlElement(required = true)
    protected String processNo;
    @XmlElement(required = true)
    protected String processName;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String durationCount;
    protected int durationUnit;
    protected boolean generatePassword;
    @XmlElement(required = true)
    protected String serverNo;
    @XmlElement(required = true)
    protected String serverName;
    @XmlElement(required = true)
    protected String dossierNoPattern;
    @XmlElement(required = true)
    protected String dueDatePattern;
    @XmlElement(required = true)
    protected ServiceProcess.Roles roles;
    @XmlElement(required = true)
    protected Steps steps;
    @XmlElement(required = true)
    protected Actions actions;
    @XmlElement(required = true)
    protected Sequences sequences;

    /**
     * Gets the value of the processNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessNo() {
        return processNo;
    }

    /**
     * Sets the value of the processNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessNo(String value) {
        this.processNo = value;
    }

    /**
     * Gets the value of the processName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessName(String value) {
        this.processName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the durationCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDurationCount() {
        return durationCount;
    }

    /**
     * Sets the value of the durationCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDurationCount(String value) {
        this.durationCount = value;
    }

    /**
     * Gets the value of the durationUnit property.
     * 
     */
    public int getDurationUnit() {
        return durationUnit;
    }

    /**
     * Sets the value of the durationUnit property.
     * 
     */
    public void setDurationUnit(int value) {
        this.durationUnit = value;
    }

    /**
     * Gets the value of the generatePassword property.
     * 
     */
    public boolean isGeneratePassword() {
        return generatePassword;
    }

    /**
     * Sets the value of the generatePassword property.
     * 
     */
    public void setGeneratePassword(boolean value) {
        this.generatePassword = value;
    }

    /**
     * Gets the value of the serverNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerNo() {
        return serverNo;
    }

    /**
     * Sets the value of the serverNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerNo(String value) {
        this.serverNo = value;
    }

    /**
     * Gets the value of the serverName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * Sets the value of the serverName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerName(String value) {
        this.serverName = value;
    }

    /**
     * Gets the value of the dossierNoPattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDossierNoPattern() {
        return dossierNoPattern;
    }

    /**
     * Sets the value of the dossierNoPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDossierNoPattern(String value) {
        this.dossierNoPattern = value;
    }

    /**
     * Gets the value of the dueDatePattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDatePattern() {
        return dueDatePattern;
    }

    /**
     * Sets the value of the dueDatePattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDatePattern(String value) {
        this.dueDatePattern = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceProcess.Roles }
     *     
     */
    public ServiceProcess.Roles getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceProcess.Roles }
     *     
     */
    public void setRoles(ServiceProcess.Roles value) {
        this.roles = value;
    }

    /**
     * Gets the value of the steps property.
     * 
     * @return
     *     possible object is
     *     {@link Steps }
     *     
     */
    public Steps getSteps() {
        return steps;
    }

    /**
     * Sets the value of the steps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Steps }
     *     
     */
    public void setSteps(Steps value) {
        this.steps = value;
    }

    /**
     * Gets the value of the actions property.
     * 
     * @return
     *     possible object is
     *     {@link Actions }
     *     
     */
    public Actions getActions() {
        return actions;
    }

    /**
     * Sets the value of the actions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Actions }
     *     
     */
    public void setActions(Actions value) {
        this.actions = value;
    }

    /**
     * Gets the value of the sequences property.
     * 
     * @return
     *     possible object is
     *     {@link Sequences }
     *     
     */
    public Sequences getSequences() {
        return sequences;
    }

    /**
     * Sets the value of the sequences property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sequences }
     *     
     */
    public void setSequences(Sequences value) {
        this.sequences = value;
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
     *         &lt;element name="ProcessRole" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="roleCode">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="255"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="roleName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="255"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="moderator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="condition">
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
        "processRole"
    })
    public static class Roles {

        @XmlElement(name = "ProcessRole", required = true)
        protected List<ServiceProcess.Roles.ProcessRole> processRole;

        /**
         * Gets the value of the processRole property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the processRole property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProcessRole().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceProcess.Roles.ProcessRole }
         * 
         * 
         */
        public List<ServiceProcess.Roles.ProcessRole> getProcessRole() {
            if (processRole == null) {
                processRole = new ArrayList<ServiceProcess.Roles.ProcessRole>();
            }
            return this.processRole;
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
         *         &lt;element name="roleCode">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="255"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="roleName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="255"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="moderator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="condition">
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
            "roleCode",
            "roleName",
            "moderator",
            "condition"
        })
        public static class ProcessRole {

            @XmlElement(required = true)
            protected String roleCode;
            @XmlElement(required = true)
            protected String roleName;
            protected boolean moderator;
            @XmlElement(required = true)
            protected String condition;

            /**
             * Gets the value of the roleCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRoleCode() {
                return roleCode;
            }

            /**
             * Sets the value of the roleCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRoleCode(String value) {
                this.roleCode = value;
            }

            /**
             * Gets the value of the roleName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRoleName() {
                return roleName;
            }

            /**
             * Sets the value of the roleName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRoleName(String value) {
                this.roleName = value;
            }

            /**
             * Gets the value of the moderator property.
             * 
             */
            public boolean isModerator() {
                return moderator;
            }

            /**
             * Sets the value of the moderator property.
             * 
             */
            public void setModerator(boolean value) {
                this.moderator = value;
            }

            /**
             * Gets the value of the condition property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCondition() {
                return condition;
            }

            /**
             * Sets the value of the condition property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCondition(String value) {
                this.condition = value;
            }

        }

    }

}
