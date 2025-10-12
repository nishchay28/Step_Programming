public class PP4_JavaBeanStandards {
    private String name;
    private int age;
    private boolean active;

    public PP4_JavaBeanStandards() {
        name = "";
        age = 0;
        active = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static void main(String[] args) {
        PP4_JavaBeanStandards bean = new PP4_JavaBeanStandards();
        bean.setName("Nishchay");
        bean.setAge(21);
        bean.setActive(true);

        System.out.println("Name: " + bean.getName());
        System.out.println("Age: " + bean.getAge());
        System.out.println("Active: " + bean.isActive());
    }
}