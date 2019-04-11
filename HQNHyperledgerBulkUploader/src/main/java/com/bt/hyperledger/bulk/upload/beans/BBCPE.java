/**
 * 
 */
package com.bt.hyperledger.bulk.upload.beans;

/**
 * @author asubramanian
 *
 */
public class BBCPE {

	private String dn;
	private String poId;
	private String foId;
	private String orderType;
	private String productOrderType;
	private String status;
	private String productSKU;
	private String quantity;
	private String supplierId;
	private String serialNumber;
	private String macAddress;
	private String reason;
	private String jiffyBagSKU;
	private String orderDate;
	private String completionDate;

	/**
	 * @return the dn
	 */
	public String getDn() {
		return dn;
	}

	/**
	 * @param dn
	 *            the dn to set
	 */
	public void setDn(String dn) {
		this.dn = dn;
	}

	/**
	 * @return the poId
	 */
	public String getPoId() {
		return poId;
	}

	/**
	 * @param poId
	 *            the poId to set
	 */
	public void setPoId(String poId) {
		this.poId = poId;
	}

	/**
	 * @return the foId
	 */
	public String getFoId() {
		return foId;
	}

	/**
	 * @param foId
	 *            the foId to set
	 */
	public void setFoId(String foId) {
		this.foId = foId;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the productOrderType
	 */
	public String getProductOrderType() {
		return productOrderType;
	}

	/**
	 * @param productOrderType
	 *            the productOrderType to set
	 */
	public void setProductOrderType(String productOrderType) {
		this.productOrderType = productOrderType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the productSKU
	 */
	public String getProductSKU() {
		return productSKU;
	}

	/**
	 * @param productSKU
	 *            the productSKU to set
	 */
	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the supplierId
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId
	 *            the supplierId to set
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress
	 *            the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the jiffyBagSKU
	 */
	public String getJiffyBagSKU() {
		return jiffyBagSKU;
	}

	/**
	 * @param jiffyBagSKU
	 *            the jiffyBagSKU to set
	 */
	public void setJiffyBagSKU(String jiffyBagSKU) {
		this.jiffyBagSKU = jiffyBagSKU;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the completionDate
	 */
	public String getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate
	 *            the completionDate to set
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BBCPE [dn=" + dn + ", poId=" + poId + ", foId=" + foId
				+ ", orderType=" + orderType + ", productOrderType="
				+ productOrderType + ", status=" + status + ", productSKU="
				+ productSKU + ", quantity=" + quantity + ", supplierId="
				+ supplierId + ", serialNumber=" + serialNumber
				+ ", macAddress=" + macAddress + ", reason=" + reason
				+ ", jiffyBagSKU=" + jiffyBagSKU + ", orderDate=" + orderDate
				+ ", completionDate=" + completionDate + "]";
	}

}
