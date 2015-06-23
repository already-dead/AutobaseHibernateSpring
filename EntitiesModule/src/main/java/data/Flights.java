package data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "flights")
public class Flights implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FLIGHT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "DATE")
	private String date;
	
	@Column(name = "ADRESS")
	private String adress;
	
	@Column(name = "DRIVER")
	private int driver;
	
	@Column(name = "CAR")
	private int car;
	
	@Column(name = "FLIGHT_STATUS")
	private int status;
	
	@Column(name = "CAR_CONDITION_AFTER")
	private int condition;
	
	@Column (name="DEL")
	protected int del;
	
	@Version
	@Column (name="VERSION")
	protected long version;
	
	public int getId() {
		return id;
	}
	
	public Flights() {	
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + car;
		result = prime * result + condition;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + driver;
		result = prime * result + id;
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Flights)) {
			return false;
		}
		Flights other = (Flights) obj;
		if (adress == null) {
			if (other.adress != null) {
				return false;
			}
		} else if (!adress.equals(other.adress)) {
			return false;
		}
		if (car != other.car) {
			return false;
		}
		if (condition != other.condition) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (driver != other.driver) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}
	
    @Override
    public String toString() {
        return "Flight : id: " + id + 
        		" Date: " + date + 
        		" Adress: " + adress + 
        		" Driver_ID: " + driver + 
        		" Car_ID: " + car +
        		" Status: " + status +
        		" Car_condition: " + condition;
    }
	
}
