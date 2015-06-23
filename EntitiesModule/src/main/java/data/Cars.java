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
@Table(name = "cars")
public class Cars implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CAR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "REG_NUMBER")
	private String regNumber;
	
	@Column(name = "CAR_CONDITION")
	private int condition;

	@Column (name="DEL")
	protected int del;
	
	@Version
	@Column (name="VERSION")
	protected long version;
	
	public int getId() {
		return id;
	}
	
	public Cars() {	
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
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
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + condition;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((regNumber == null) ? 0 : regNumber.hashCode());
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
		if (!(obj instanceof Cars)) {
			return false;
		}
		Cars other = (Cars) obj;
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (condition != other.condition) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (regNumber == null) {
			if (other.regNumber != null) {
				return false;
			}
		} else if (!regNumber.equals(other.regNumber)) {
			return false;
		}
		return true;
	}
	
    @Override
    public String toString() {
        return "Car : id: " + id + 
        		" Brand: " + brand + 
        		" Model: " + model + 
        		" RegNumber: " + regNumber + 
        		" Condition: " + condition;
    }
	

}
