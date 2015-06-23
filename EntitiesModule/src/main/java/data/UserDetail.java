package data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "user_detail")
public class UserDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_SURNAME")
	private String surname;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Users users;
	
	@Column (name="DEL")
	protected int del;
	
	@Version
	@Column (name="VERSION")
	protected long version;
	

	
	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public int getId() {
		return id;
	}

	
	public UserDetail() {	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}


	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (!(obj instanceof UserDetail)) {
			return false;
		}
		UserDetail other = (UserDetail) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}


	@Override
    public String toString() {
        return "UserDetail : id: " + id + 
        		" Name: " + name + 
        		" Surname: " + surname;
    }
	

}
