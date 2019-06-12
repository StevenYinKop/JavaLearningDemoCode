package week5._1;
/**
 * 定义一个老鼠类，该类有属性名字，爱好，年龄。创建老鼠对象，并初始化，然后把这些老鼠对象添加到一个集合中。
 */
public class Rat implements Comparable<Rat>{
	private String name;
	private String hobby;
	private Integer age;
	public Rat(String name, String hobby, Integer age) {
		super();
		this.name = name;
		this.hobby = hobby;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int compareTo(Rat o) {
		return o.age - this.age;
	}
	@Override
	public String toString() {
		return "Rat [name=" + name + ", hobby=" + hobby + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rat other = (Rat) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	 
}
