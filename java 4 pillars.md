1.Encapsulation
Encapsulation is the bundling of data and methods that operate on that data within a class, and restricting direct access to some of the object's components. 
It is achieved by declaring the variables of a class as private, and providing public methods to access and modify them.



class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}


2. Inheritance
Inheritance allows a class (subclass) to inherit properties and methods from another class (superclass). 
It promotes code reusability and establishes a hierarchical relationship between classes


class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println("Woof!");
    }
}


3. Polymorphism
Polymorphism allows objects of different classes to be treated as objects of a common type.
It enables a single action to be performed in different ways. It is achieved through method overriding and method overloading



class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}



4. Abstraction
Abstraction involves hiding complex implementation details and showing only essential information to the user. 
It can be achieved through abstract classes and interfaces.



interface Drawable {
    void draw();
}

class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
