package com.revature.pojo;

//import com.sun.jmx.snmp.Timestamp;
import java.sql.Timestamp;

//import oracle.sql.BLOB;
import oracle.sql.TIMESTAMP;

public class ReimbursementPojo {
	private int rId;
	private double rAmount;
	private String rDescription;
	//private BLOB rReceipt;
	private String rReceipt;
	//private TIMESTAMP rSubmitted;
	//private TIMESTAMP rResolved;
	private Timestamp rSubmitted;
	private Timestamp rResolved;
	private int u_idAuthor;
	private int u_idResolver;
	private int rtType;
	private int rtStatus;
	
	public ReimbursementPojo() {}

	public ReimbursementPojo(int rId, double rAmount, String rDescription, String rReceipt, Timestamp rSubmitted,
			Timestamp rResolved, int u_idAuthor, int u_idResolver, int rtType, int rtStatus) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rSubmitted = rSubmitted;
		this.rResolved = rResolved;
		this.u_idAuthor = u_idAuthor;
		this.u_idResolver = u_idResolver;
		this.rtType = rtType;
		this.rtStatus = rtStatus;
	}
	
	public ReimbursementPojo( double rAmount, String rDescription, String rReceipt, Timestamp rSubmitted,
			 int u_idAuthor, int rtType) {
		super();
		
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rSubmitted = rSubmitted;
		//this.rResolved = rResolved;
		this.u_idAuthor = u_idAuthor;
		//this.u_idResolver = u_idResolver;
		this.rtType = rtType;
	
	}
	
	

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public double getrAmount() {
		return rAmount;
	}

	public void setrAmount(int rAmount) {
		this.rAmount = rAmount;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public String getrReceipt() {
		return rReceipt;
	}

	public void setrReceipt(String rReceipt) {
		this.rReceipt = rReceipt;
	}

	public Timestamp getrSubmitted() {
		return rSubmitted;
	}

	public void setrSubmitted(Timestamp rSubmitted) {
		this.rSubmitted = rSubmitted;
	}

	public Timestamp getrResolved() {
		return rResolved;
	}

	public void setrResolved(Timestamp rResolved) {
		this.rResolved = rResolved;
	}

	public int getU_idAuthor() {
		return u_idAuthor;
	}

	public void setU_idAuthor(int u_idAuthor) {
		this.u_idAuthor = u_idAuthor;
	}

	public int getU_idResolver() {
		return u_idResolver;
	}

	public void setU_idResolver(int u_idResolver) {
		this.u_idResolver = u_idResolver;
	}

	public int getRtType() {
		return rtType;
	}

	public void setRtType(int rtType) {
		this.rtType = rtType;
	}

	public int getRtStatus() {
		return rtStatus;
	}

	public void setRtStatus(int rtStatus) {
		this.rtStatus = rtStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementPojo [rId=" + rId + ", rAmount=" + rAmount + ", rDescription=" + rDescription
				+ ", rReceipt=" + rReceipt + ", rSubmitted=" + rSubmitted + ", rResolved=" + rResolved + ", u_idAuthor="
				+ u_idAuthor + ", u_idResolver=" + u_idResolver + ", rtType=" + rtType + ", rtStatus=" + rtStatus + "]";
	};
	
	
	

}
