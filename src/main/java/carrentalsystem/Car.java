package carrentalsystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
  @Id
  private int regCarId;
  
  private String regCarName;
	private String regCarModel;
	@Column(unique = true)
	private int regCarNumber;

	private String status="available";
	private String ownerName;
	public int getRegCarId() {
		return regCarId;
	}
	public void setRegCarId(int regCarId) {
		this.regCarId = regCarId;
	}
	public String getRegCarName() {
		return regCarName;
	}
	public void setRegCarName(String regCarName) {
		this.regCarName = regCarName;
	}
	public String getRegCarModel() {
		return regCarModel;
	}
	public void setRegCarModel(String regCarModel) {
		this.regCarModel = regCarModel;
	}
	public int getRegCarNumber() {
		return regCarNumber;
	}
	public void setRegCarNumber(int regCarNumber) {
		this.regCarNumber = regCarNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Car(int regCarId, String regCarName, String regCarModel, int regCarNumber, String status, String ownerName) {
		super();
		this.regCarId = regCarId;
		this.regCarName = regCarName;
		this.regCarModel = regCarModel;
		this.regCarNumber = regCarNumber;
		this.status = status;
		this.ownerName = ownerName;
	}
	public Car() {
		super();
	}
	
}
