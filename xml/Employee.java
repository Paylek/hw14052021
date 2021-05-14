package xml;

public class Employee {
    private String name;
    private String position;
    private String  branch;
    private String  experience;

    public Employee(String name, String position, String branch, String experience) {
        this.name = name;
        this.position = position;
        this.branch = branch;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getBranch() {
        return branch;
    }

    public String  getExperience() {
        return experience;
    }


}
