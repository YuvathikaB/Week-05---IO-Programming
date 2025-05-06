package Exercise;
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
public class OverrideEg {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}

