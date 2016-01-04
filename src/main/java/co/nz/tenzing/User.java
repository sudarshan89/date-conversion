package co.nz.tenzing;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;


public class User {

	@JsonSerialize(using = co.nz.tenzing.JsonDateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
	private Date dateOfBirth;

	
	
	public User(Date dateOfBirth) {
		super();
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
