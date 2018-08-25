
package web.app;
public class Customer 
{
    int id;
    String name;
    String gender;
    int age;
    String addr;
    int mtype;
    int salary;
    String username;
    String password;

    public Customer(int id, String name, String gender, int age, String addr, int mtype, int salary, String username, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.addr = addr;
        this.mtype = mtype;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + id + "," + name + "," + gender + "," + age + "," + addr + "," + mtype + "," + salary + "," + username + "," + password + '}';
    }

    
    
}
