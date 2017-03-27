package scenarioClasses;

public class UserInformation {
	
	private String adressePostale;
	private float latitude;
	private float longitude;

	
	//Constructors
	public UserInformation(String adressePostale, float latitude, float longitude){	
		this.adressePostale = adressePostale;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public UserInformation(){
		
	}
	
	//Getters and setters
	public String getAdressePostale() {
		return adressePostale;
	}
	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
