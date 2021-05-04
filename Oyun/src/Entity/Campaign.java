package Entity;

public class Campaign {
	private int id;
	private String campaingName;
	public Campaign(int id, String campaingName) {
		super();
		this.id = id;
		this.campaingName = campaingName;
	}
	public Campaign() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCampaingName() {
		return campaingName;
	}
	public void setCampaingName(String campaingName) {
		this.campaingName = campaingName;
	}

}
