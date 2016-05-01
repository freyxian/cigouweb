package CigouDAO.cigoudb;
// Generated 2016-4-16 23:41:32 by Hibernate Tools 4.3.1.Final

/**
 * WhOrderItemsId generated by hbm2java
 */
public class WhOrderItemsId implements java.io.Serializable {

	private String orderId;
	private String goodId;

	public WhOrderItemsId() {
	}

	public WhOrderItemsId(String orderId, String goodId) {
		this.orderId = orderId;
		this.goodId = goodId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodId() {
		return this.goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WhOrderItemsId))
			return false;
		WhOrderItemsId castOther = (WhOrderItemsId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this.getOrderId() != null
				&& castOther.getOrderId() != null && this.getOrderId().equals(castOther.getOrderId())))
				&& ((this.getGoodId() == castOther.getGoodId()) || (this.getGoodId() != null
						&& castOther.getGoodId() != null && this.getGoodId().equals(castOther.getGoodId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result + (getGoodId() == null ? 0 : this.getGoodId().hashCode());
		return result;
	}

}
