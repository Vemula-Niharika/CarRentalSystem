package carrentalsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Booking  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	private int cid;
	private String uname;
	private String sdate;
	private String edate;
	public Booking(int cid, String uname, String sdate, String edate) {
		super();
		this.cid = cid;
		this.uname = uname;
		this.sdate = sdate;
		this.edate = edate;
	}
	public Booking() {
		super();
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	

}
