/* Student Name : Cynthia Maroupas Student ID: 261119382 Class: CCCS 315-784 */
/**
 * A class that represents a worker with a name and salary.
 */
public class Worker {
    private String name;
    private double salary;

    /**
     * Constructor for creating a new Worker object with a given name and salary.
     * @param name the name of the worker.
     * @param salary the salary of the worker.
     */
    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Returns the name of the worker.
     * @return the name of the worker.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the salary of the worker.
     * @return the salary of the worker.
     */
    public double getSalary() {
        return salary;
    }
}