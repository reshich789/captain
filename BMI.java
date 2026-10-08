public class BMI {
    private String name;
    private int age;
    private double weight; // pounds
    private double height; // inches

    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height); // default age 20
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    public double getHeight() { return height; }

    public double getBMI() {
        return weight * 703 / (height * height);
    }

    public String getStatus() {
        double bmi = getBMI();
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        BMI b = new BMI("Ali", 25, 150, 65);
        System.out.printf("%s: BMI = %.2f (%s)%n", b.getName(), b.getBMI(), b.getStatus());
    }
}
