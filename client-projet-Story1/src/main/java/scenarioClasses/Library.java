package scenarioClasses;

public class Library {
	
	private int rcr;
	private String shortname;
	private float latitude;
	private float longitude;
	
	
	//Constructors
	public Library(){
		
	}
	
	
	public Library(int crc, String shortname, float latitude, float longitude){	
		this.rcr = crc;
		this.shortname = shortname;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	//Getters and setters
	public int getRcR() {
		return rcr;
	}


	public void setRcR(int crc) {
		this.rcr = crc;
	}


	public String getShortname() {
		return shortname;
	}


	public void setShortname(String shortname) {
		this.shortname = shortname;
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
