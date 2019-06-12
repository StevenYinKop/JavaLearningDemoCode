package week3._3;
public class Actor implements Movie, Sing, Teleplay{

	private String name;
	public Actor(String name) {
		super();
		this.name = name;
	}
	@Override
	public void teleplay() {
		System.out.println("我会演电视剧!");
	}

	@Override
	public void sing() {
		System.out.println("我会唱歌!我的滑板鞋");
	}

	@Override
	public void movie() {
		System.out.println("我会演电影!");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Actor peppa = new Actor("佩奇");
		System.out.println("我是" + peppa.getName());
		peppa.movie();
		peppa.teleplay();
		peppa.sing();
	}
}
