import java.io.Serializable;

public class Student implements Serializable {

    public String name;
    public int group;
    public int money;
    public boolean isHungry;

    // 64 32 32 1

    public Student(String name, int group, int money, boolean isHungry) {
        this.name = name;
        this.group = group;
        this.money = money;
        this.isHungry = isHungry;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", money=" + money +
                ", isHungry=" + isHungry +
                '}';
    }
}
