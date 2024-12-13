import java.util.ArrayList;
import java.util.List;

public class Main{
    public static class Human {
        private String name;
        private final String surname;
        private int age;
        private final char gender;

        public Human(String name, String surname, int age, char gender) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public char getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void older() {
            age++;
        }

        public void printFullInfo() {
            System.out.println("Фамилия:" + surname + "; Имя:" + name + "; Возраст:" + age + "; Пол:" + gender);
        }
    }

    public static class Worker extends Human {
        private double salary;

        public Worker(String name, String surname, int age, char gender, double salary) {
            super(name, surname, age, gender);
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public void raiseSalary() {
            salary += 10000;
        }

        @Override
        public void printFullInfo() {
            System.out.println("Фамилия:" + getSurname() + "; Имя:" + getName() + "; Возраст:" + getAge() + "; Пол:" + getGender() + "; Зарплата:" + salary);
        }
        public static class Meneger extends Worker{
            private List<Human> employee;
            public Meneger(String name, String surname, int age, char gender, double salary) {
                super(name, surname, age, gender, salary);
                this.employee = new ArrayList<>();
            }
            public List<Human> getHuman(){
                return this.employee;
            }
            public void addEmployee(Human human){
                this.employee.add(human);
            }

        }
    }

    public static void main(String[] args) {
        Human Makar = new Human("Макар","Сорокин",18,'M');
        System.out.println("Имя:"+Makar.getName());
        System.out.println("Фамилия:"+Makar.getSurname());
        System.out.println("Возраст:"+Makar.getAge());
        System.out.println("Пол:"+Makar.getGender());
        Makar.setName("Никита");
        Makar.older();
        Makar.printFullInfo();

        Worker makar = new Worker("Макар","Сорокин",18,'M', 32000);
        System.out.println("Имя:"+makar.getName());
        System.out.println("Фамилия:"+makar.getSurname());
        System.out.println("Возраст:"+makar.getAge());
        System.out.println("Пол:"+makar.getGender());
        System.out.println("Пол:"+makar.getSalary());
        makar.setName("Никита");
        makar.older();
        makar.raiseSalary();
        makar.printFullInfo();
    }
}
