package jaxb;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")

@XmlType(propOrder = {"name", "position", "branch", "experience"})

public class Employee {
    private String name;
    private String position;
    private String  branch;
    private String  experience;

    public Employee() {}

    public Employee(String name, String position, String branch, String experience) {
        this.name = name;
        this.position = position;
        this.branch = branch;
        this.experience = experience;
    }

    @XmlAttribute
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", branch='" + branch + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
