import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User {
	private String name;
	private int id;
	public static int count=0;
	
	public User() {
		this.id = ++count;
	}
	public User(String name) {
		this();
		this.setName(name);
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@XmlAttribute
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
}
