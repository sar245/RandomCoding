/**
 * 
 */
package com.bt.hyperledger.bulk.upload.beans;

/**
 * @author asubramanian
 *
 */
public class UniqueIDVO {
	private long customerId;
	private long productOrderId;
	private long fulfilmentOrderId;
	private long cpeId;

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the productOrderId
	 */
	public long getProductOrderId() {
		return productOrderId;
	}

	/**
	 * @param productOrderId
	 *            the productOrderId to set
	 */
	public void setProductOrderId(long productOrderId) {
		this.productOrderId = productOrderId;
	}

	/**
	 * @return the fulfilmentOrderId
	 */
	public long getFulfilmentOrderId() {
		return fulfilmentOrderId;
	}

	/**
	 * @param fulfilmentOrderId
	 *            the fulfilmentOrderId to set
	 */
	public void setFulfilmentOrderId(long fulfilmentOrderId) {
		this.fulfilmentOrderId = fulfilmentOrderId;
	}

	/**
	 * @return the cpeId
	 */
	public long getCpeId() {
		return cpeId;
	}

	/**
	 * @param cpeId the cpeId to set
	 */
	public void setCpeId(long cpeId) {
		this.cpeId = cpeId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UniqueIDVO [customerId=" + customerId + ", productOrderId="
				+ productOrderId + ", fulfilmentOrderId=" + fulfilmentOrderId
				+ ", cpeId=" + cpeId + "]";
	}

}
