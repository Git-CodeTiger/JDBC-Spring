package studio.codeocean.models.domain;

public class Student {
	private String name;
	private String sex;
	private int age;
	private String school;
	private String major;
	private String clazz;

	public Student(String name, String sex, int age, String school, String major, String clazz) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.school = school;
		this.major = major;
		this.clazz = clazz;
	
	}

	public Student() {
	
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public String getSchool() {
		return school;
	}

	public String getMajor() {
		return major;
	}

	public String getClazz() {
		return clazz;
	}

}	

