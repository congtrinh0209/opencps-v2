//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.22 at 03:30:55 PM ICT 
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
 *         &lt;element name="MenuConfig" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="menuGroup">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="menuName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="menuType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="queryParams">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tableConfig">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="buttonConfig">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="icon">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="roles">
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
    "menuConfig"
})
@XmlRootElement(name = "MenuConfigList")
public class MenuConfigList {

    @XmlElement(name = "MenuConfig", required = true)
    protected List<MenuConfigList.MenuConfig> menuConfig;

    /**
     * Gets the value of the menuConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the menuConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMenuConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuConfigList.MenuConfig }
     * 
     * 
     */
    public List<MenuConfigList.MenuConfig> getMenuConfig() {
        if (menuConfig == null) {
            menuConfig = new ArrayList<MenuConfigList.MenuConfig>();
        }
        return this.menuConfig;
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
     *         &lt;element name="menuGroup">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="menuName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="menuType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="queryParams">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="tableConfig">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="buttonConfig">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="icon">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="roles">
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
        "menuGroup",
        "menuName",
        "order",
        "menuType",
        "queryParams",
        "tableConfig",
        "buttonConfig",
        "icon",
        "roles"
    })
    public static class MenuConfig {

        @XmlElement(required = true)
        protected String menuGroup;
        @XmlElement(required = true)
        protected String menuName;
        protected Integer order;
        protected Integer menuType;
        @XmlElement(required = true)
        protected String queryParams;
        @XmlElement(required = true)
        protected String tableConfig;
        @XmlElement(required = true)
        protected String buttonConfig;
        @XmlElement(required = true)
        protected String icon;
        @XmlElement(required = true)
        protected String roles;

        /**
         * Gets the value of the menuGroup property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMenuGroup() {
            return menuGroup;
        }

        /**
         * Sets the value of the menuGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMenuGroup(String value) {
            this.menuGroup = value;
        }

        /**
         * Gets the value of the menuName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMenuName() {
            return menuName;
        }

        /**
         * Sets the value of the menuName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMenuName(String value) {
            this.menuName = value;
        }

        /**
         * Gets the value of the order property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getOrder() {
            return order;
        }

        /**
         * Sets the value of the order property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setOrder(Integer value) {
            this.order = value;
        }

        /**
         * Gets the value of the menuType property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMenuType() {
            return menuType;
        }

        /**
         * Sets the value of the menuType property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMenuType(Integer value) {
            this.menuType = value;
        }

        /**
         * Gets the value of the queryParams property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueryParams() {
            return queryParams;
        }

        /**
         * Sets the value of the queryParams property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueryParams(String value) {
            this.queryParams = value;
        }

        /**
         * Gets the value of the tableConfig property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTableConfig() {
            return tableConfig;
        }

        /**
         * Sets the value of the tableConfig property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTableConfig(String value) {
            this.tableConfig = value;
        }

        /**
         * Gets the value of the buttonConfig property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getButtonConfig() {
            return buttonConfig;
        }

        /**
         * Sets the value of the buttonConfig property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setButtonConfig(String value) {
            this.buttonConfig = value;
        }

        /**
         * Gets the value of the icon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIcon() {
            return icon;
        }

        /**
         * Sets the value of the icon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIcon(String value) {
            this.icon = value;
        }

        /**
         * Gets the value of the roles property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRoles() {
            return roles;
        }

        /**
         * Sets the value of the roles property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRoles(String value) {
            this.roles = value;
        }

    }

}
