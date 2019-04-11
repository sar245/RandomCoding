package com.bt.hyperledger.bulk.upload.beans;

public class BBCPEAsset {

	private String customerId;

	private BBCPE bbcpe;

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the bbcpe
	 */
	public BBCPE getBbcpe() {
		return bbcpe;
	}

	/**
	 * @param bbcpe
	 *            the bbcpe to set
	 */
	public void setBbcpe(BBCPE bbcpe) {
		this.bbcpe = bbcpe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BBCPEAsset [customerId=" + customerId + ", bbcpe=" + bbcpe
				+ "]";
	}

}
