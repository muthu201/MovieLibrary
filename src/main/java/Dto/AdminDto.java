package Dto;
public class AdminDto {
	
	private int aId;
	private String aName;
	private Long aContact;
	private String aEmail;
	private String aPassword;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public Long getaContact() {
		return aContact;
	}
	public void setaContact(Long aContact) {
		this.aContact = aContact;
	}
	public String getaEmail() {
		return aEmail;
	}
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	@Override
	public String toString() {
		return "AdminDto [aId=" + aId + ", aName=" + aName + ", aContact=" + aContact + ", aEmail=" + aEmail
				+ ", aPassword=" + aPassword + "]";
	}
	
	
}

