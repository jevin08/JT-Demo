package entities;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {
	@Id
	private int playerId;
	private String playerName;
	private Date dateOfBirth;
	private String address;
	private long phoneNo;
	@ManyToOne(cascade = CascadeType.ALL)
//	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lockerId", unique = true)
	private Locker locker;

	public Player(int playerId, String playerName, Date dateOfBirth, String address, long phoneNo) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Player() {
		super();
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

}


