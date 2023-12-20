package gacha_program;

public class Hero extends Character implements Display {
	private String grade;
	
	public Hero(String name, Integer power, String grade) {
		super(name, power);
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void display(Integer counter) {
		System.out.println(String.format(
			"| %-2d | Name: %-15s | Power: %-5d | Grade: %-5s |\n",
			counter, super.getName(), super.getPower(), this.getGrade()
		));
	}
	
}
