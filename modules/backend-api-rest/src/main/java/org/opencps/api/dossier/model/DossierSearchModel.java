//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.23 at 09:44:18 AM ICT 
//


package org.opencps.api.dossier.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="substatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="agency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="follow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="step" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submitting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="top" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="so_chung_chi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromReceiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toReceiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tu_ngay_ky_cc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="den_ngay_ky_cc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "keyword",
    "start",
    "end",
    "sort",
    "order",
    "status",
    "substatus",
    "agency",
    "service",
    "template",
    "year",
    "month",
    "owner",
    "follow",
    "step",
    "submitting",
    "top",
    "secetKey",
    "state",
    "dossierNo",
    "soChungChi",
    "fromReceiveDate",
    "toReceiveDate",
    "tuNgayKyCc",
    "denNgayKyCc",
    "dossierIdCTN",
    "fromSubmitDate",
    "toSubmitDate",
    "notState",
    "statusReg",
    "notStatusReg",
    "keywordSearchLike",
    "online",
    "specialKey",
    "assigned",
    "domain",
    "domainName",
    "applicantName",
    "applicantIdNo",
    "serviceName",
    "fromReleaseDate",
    "toReleaseDate",
    "originality",
    "fromFinishDate",
    "toFinishDate",
    "fromReceiveNotDoneDate",
    "toReceiveNotDoneDate",
    "fromStatisticDate",
    "toStatisticDate",
    "origin",
    "originDossierId",
    "time",
    "register",
    "day",
    "paymentStatus",
    "groupDossierId",
    "permission",
    "delegateType",
    "documentNo",
    "documentDate",
    "systemId",
    "viapostal",
    "undueTime",
    "toBacklogDate",
    "backlog",
    "assignedUserIdSearch"
})
@XmlRootElement(name = "DossierSearchModel")
public class DossierSearchModel {

	@QueryParam(value = "keyword")
    protected String keyword;
	@QueryParam(value = "start")
    protected int start;
	@QueryParam(value = "end")
    protected int end;
	@QueryParam(value = "sort")
    protected String sort;
	@QueryParam(value = "order")
    protected String order;
	@QueryParam(value = "status")
    protected String status;
	@QueryParam(value = "substatus")
    protected String substatus;
	@QueryParam(value = "agency")
    protected String agency;
	@QueryParam(value = "service")
    protected String service;
	@QueryParam(value = "template")
    protected String template;
	@QueryParam(value = "year")
    protected int year;
	@QueryParam(value = "month")
    protected int month;
	@QueryParam(value = "owner")
    protected String owner;
	@QueryParam(value = "follow")
    protected String follow;
	@QueryParam(value = "step")
    protected String step;
	@QueryParam(value = "submitting")
    protected String submitting;
	@QueryParam(value = "top")
    protected String top;
	@QueryParam(value = "secetKey")
	@DefaultValue(value = "")
    protected String secetKey;
	@QueryParam(value = "state")
    protected String state;
	@QueryParam(value = "dossierNo")
    protected String dossierNo;
    @QueryParam(value = "so_chung_chi")
    protected String soChungChi;
    @QueryParam(value = "fromReceiveDate")
    protected String fromReceiveDate;
    @QueryParam(value = "toReceiveDate")
    protected String toReceiveDate;
    @QueryParam(value = "tu_ngay_ky_cc")
    protected String tuNgayKyCc;
    @QueryParam(value = "den_ngay_ky_cc")
    protected String denNgayKyCc;
    @QueryParam(value = "dossierIdCTN")
    protected String dossierIdCTN;
    @QueryParam(value = "fromSubmitDate")
    protected String fromSubmitDate;
    @QueryParam(value = "toSubmitDate")
    protected String toSubmitDate;
    @QueryParam(value = "pendding")
    protected String pendding;
    @QueryParam(value = "applicantIdNo")
    protected String applicantIdNo;
    @QueryParam(value = "dossierArr")
    protected String dossierArr;
    @QueryParam(value = "notState")
    protected String notState;
    @QueryParam(value = "statusReg")
    protected String statusReg;
    @QueryParam(value = "notStatusReg")
    protected String notStatusReg;
    @QueryParam(value = "keywordSearchLike")
    protected String keywordSearchLike;
    @QueryParam(value = "specialKey")
    protected String specialKey;
    @QueryParam(value = "online")
    protected String online;
    @QueryParam(value = "assigned")
    protected Integer assigned;
    @QueryParam(value = "domain")
    protected String domain;
    @QueryParam(value = "domainName")
    protected String domainName;
    @QueryParam(value = "applicantName")
    protected String applicantName;
    @QueryParam(value = "serviceName")
    protected String serviceName;
    @QueryParam(value = "fromReleaseDate")
    protected String fromReleaseDate;
    @QueryParam(value = "toReleaseDate")
    protected String toReleaseDate;
    @QueryParam(value = "originality")
    protected String originality;
    @QueryParam(value = "fromFinishDate")
    protected String fromFinishDate;
    @QueryParam(value = "toFinishDate")
    protected String toFinishDate;
    @QueryParam(value = "fromReceiveNotDoneDate")
    protected String fromReceiveNotDoneDate;
    @QueryParam(value = "toReceiveNotDoneDate")
    protected String toReceiveNotDoneDate;
    @QueryParam(value = "paymentStatus")
    protected String paymentStatus;
    @QueryParam(value = "fromStatisticDate")
    protected String fromStatisticDate;
    @QueryParam(value = "toStatisticDate")
    protected String toStatisticDate;
    @QueryParam(value = "origin")
    protected String origin;
    @QueryParam(value = "originDossierId")
    protected Integer originDossierId;
    @QueryParam(value = "time")
    protected String time;
    @QueryParam(value = "register")
    protected String register;
	@QueryParam(value = "day")
    protected int day;
	@QueryParam(value = "groupDossierId")
    protected Long groupDossierId;
    @QueryParam(value = "permission")
    protected String permission;
    @QueryParam(value = "delegateType")
    protected String delegateType;
    @QueryParam(value = "documentNo")
    protected String documentNo;
    @QueryParam(value = "systemId")
    protected String systemId;
    @QueryParam(value = "viapostal")
    protected Integer viapostal;
    @QueryParam(value = "undueTime")
    protected String undueTime;
    @QueryParam(value = "fromDueDate")
    protected String fromDueDate;
    @QueryParam(value = "toDueDate")
    protected String toDueDate;
    
	public String getFromDueDate() {
		return fromDueDate;
	}

	public void setFromDueDate(String fromDueDate) {
		this.fromDueDate = fromDueDate;
	}

	public String getToDueDate() {
		return toDueDate;
	}

	public void setToDueDate(String toDueDate) {
		this.toDueDate = toDueDate;
	}

	public String getUndueTime() {
		return undueTime;
	}

	public void setUndueTime(String undueTime) {
		this.undueTime = undueTime;
	}
    @QueryParam(value = "toBacklogDate")
    protected String toBacklogDate;
    @QueryParam(value = "backlog")
    protected int backlog;
    @QueryParam(value = "assignedUserId")
    protected String assignedUserIdSearch;

	public Integer getViapostal() {
		return viapostal;
	}

	public void setViapostal(Integer viapostal) {
		this.viapostal = viapostal;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getDelegateType() {
		return delegateType;
	}

	public void setDelegateType(String delegateType) {
		this.delegateType = delegateType;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	@QueryParam(value = "documentDate")
    protected String documentDate;

    public Integer getAssigned() {
		return assigned;
	}

	public void setAssigned(Integer assigned) {
		this.assigned = assigned;
	}

	public String getSpecialKey() {
		return specialKey;
	}

	public void setSpecialKey(String specialKey) {
		this.specialKey = specialKey;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

    public String getKeywordSearchLike() {
		return keywordSearchLike;
	}

	public void setKeywordSearchLike(String keywordSearchLike) {
		this.keywordSearchLike = keywordSearchLike;
	}

	public String getNotStatusReg() {
		return notStatusReg;
	}

	public void setNotStatusReg(String notStatusReg) {
		this.notStatusReg = notStatusReg;
	}

	public String getStatusReg() {
		return statusReg;
	}

	public void setStatusReg(String statusReg) {
		this.statusReg = statusReg;
	}

	public String getNotState() {
		return notState;
	}

	public void setNotState(String notState) {
		this.notState = notState;
	}

	public String getDossierArr() {
		return dossierArr;
	}

	public void setDossierArr(String dossierArr) {
		this.dossierArr = dossierArr;
	}

	public String getApplicantIdNo() {
		return applicantIdNo;
	}

	public void setApplicantIdNo(String applicantIdNo) {
		this.applicantIdNo = applicantIdNo;
	}

	public String getSecetKey() {
		return secetKey;
	}

	public void setSecetKey(String secetKey) {
		this.secetKey = secetKey;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyword(String value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStart(Integer value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEnd(Integer value) {
        this.end = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSort(String value) {
        this.sort = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the substatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstatus() {
        return substatus;
    }

    /**
     * Sets the value of the substatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstatus(String value) {
        this.substatus = value;
    }

    /**
     * Gets the value of the agency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgency() {
        return agency;
    }

    /**
     * Sets the value of the agency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgency(String value) {
        this.agency = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplate(String value) {
        this.template = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMonth(Integer value) {
        this.month = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the follow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFollow() {
        return follow;
    }

    /**
     * Sets the value of the follow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFollow(String value) {
        this.follow = value;
    }

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStep(String value) {
        this.step = value;
    }

    /**
     * Gets the value of the submitting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitting() {
        return submitting;
    }

    /**
     * Sets the value of the submitting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitting(String value) {
        this.submitting = value;
    }

    /**
     * Gets the value of the top property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTop() {
        return top;
    }

    /**
     * Sets the value of the top property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTop(String value) {
        this.top = value;
    }

	public String getDossierNo() {
		return dossierNo;
	}

	public void setDossierNo(String dossierNo) {
		this.dossierNo = dossierNo;
	}

    /**
     * Gets the value of the soChungChi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoChungChi() {
        return soChungChi;
    }

    /**
     * Sets the value of the soChungChi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoChungChi(String value) {
        this.soChungChi = value;
    }

    /**
     * Gets the value of the fromReceiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromReceiveDate() {
        return fromReceiveDate;
    }

    /**
     * Sets the value of the fromReceiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromReceiveDate(String value) {
        this.fromReceiveDate = value;
    }

    /**
     * Gets the value of the toReceiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToReceiveDate() {
        return toReceiveDate;
    }

    /**
     * Sets the value of the toReceiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToReceiveDate(String value) {
        this.toReceiveDate = value;
    }

    /**
     * Gets the value of the tuNgayKyCc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTuNgayKyCc() {
        return tuNgayKyCc;
    }

    /**
     * Sets the value of the tuNgayKyCc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTuNgayKyCc(String value) {
        this.tuNgayKyCc = value;
    }

    /**
     * Gets the value of the denNgayKyCc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenNgayKyCc() {
        return denNgayKyCc;
    }

    /**
     * Sets the value of the denNgayKyCc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenNgayKyCc(String value) {
        this.denNgayKyCc = value;
    }

	public String getDossierIdCTN() {
		return dossierIdCTN;
	}

	public void setDossierIdCTN(String dossierIdCTN) {
		this.dossierIdCTN = dossierIdCTN;
	}

	public String getFromSubmitDate() {
		return fromSubmitDate;
	}

	public void setFromSubmitDate(String fromSubmitDate) {
		this.fromSubmitDate = fromSubmitDate;
	}

	public String getToSubmitDate() {
		return toSubmitDate;
	}

	public void setToSubmitDate(String toSubmitDate) {
		this.toSubmitDate = toSubmitDate;
	}

	public String getPendding() {
		return pendding;
	}

	public void setPendding(String pendding) {
		this.pendding = pendding;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getFromReleaseDate() {
		return fromReleaseDate;
	}

	public void setFromReleaseDate(String fromReleaseDate) {
		this.fromReleaseDate = fromReleaseDate;
	}

	public String getToReleaseDate() {
		return toReleaseDate;
	}

	public void setToReleaseDate(String toReleaseDate) {
		this.toReleaseDate = toReleaseDate;
	}

	public String getOriginality() {
		return originality;
	}

	public void setOriginality(String originality) {
		this.originality = originality;
	}

	public String getFromReceiveNotDoneDate() {
		return fromReceiveNotDoneDate;
	}

	public void setFromReceiveNotDoneDate(String fromReceiveNotDoneDate) {
		this.fromReceiveNotDoneDate = fromReceiveNotDoneDate;
	}

	public String getToReceiveNotDoneDate() {
		return toReceiveNotDoneDate;
	}

	public void setToReceiveNotDoneDate(String toReceiveNotDoneDate) {
		this.toReceiveNotDoneDate = toReceiveNotDoneDate;
	}

	public String getFromFinishDate() {
		return fromFinishDate;
	}

	public void setFromFinishDate(String fromFinishDate) {
		this.fromFinishDate = fromFinishDate;
	}

	public String getToFinishDate() {
		return toFinishDate;
	}

	public void setToFinishDate(String toFinishDate) {
		this.toFinishDate = toFinishDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String value) {
		this.paymentStatus = value;
	}

	public String getFromStatisticDate() {
		return fromStatisticDate;
	}

	public void setFromStatisticDate(String fromStatisticDate) {
		this.fromStatisticDate = fromStatisticDate;
	}

	public String getToStatisticDate() {
		return toStatisticDate;
	}

	public void setToStatisticDate(String toStatisticDate) {
		this.toStatisticDate = toStatisticDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String value) {
		this.origin = value;
	}

	public Integer getOriginDossierId() {
		return originDossierId;
	}

	public void setOriginDossierId(Integer originDossierId) {
		this.originDossierId = originDossierId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getRegister() {
		return register;
	}

	public void setRegister(String value) {
		this.register = value;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int value) {
		this.day = value;
	}

	public Long getGroupDossierId() {
		return groupDossierId;
	}

	public void setGroupDossierId(Long groupDossierId) {
		this.groupDossierId = groupDossierId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getToBacklogDate() {
		return toBacklogDate;
	}

	public void setToBacklogDate(String toBacklogDate) {
		this.toBacklogDate = toBacklogDate;
	}

	public int getBacklog() {
		return backlog;
	}

	public void setBacklog(int value) {
		this.backlog = value;
	}

	public String getAssignedUserIdSearch() {
		return assignedUserIdSearch;
	}

	public void setAssignedUserIdSearch(String assignedUserIdSearch) {
		this.assignedUserIdSearch = assignedUserIdSearch;
	}

}
