package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locker")
public class Locker {
	@Id
	private int lockerId;
	private String lockerType;
	private Double rent;

	public Locker() {
		super();
	}

	public Locker(int lockerId, String lockerType, Double rent) {
		super();
		this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerType() {
		return lockerType;
	}

	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

}
