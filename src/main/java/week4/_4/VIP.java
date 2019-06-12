package week4._4;

public class VIP implements Comparable<VIP>{
	private int id;
	private String name;
	private int score;
	
	public VIP() {
		super();
	}
	public VIP(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(VIP vip) {
		return this.id - vip.getId();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
