/**
 * @author xiaoming
 * @since 2.0
 */
public class StringTest {

    public void greet(String str) {
        str = "Hello World!";
        System.out.println(String.format("In method: %s.", str));
    }

    public void set(StringBuffer sb) {
        sb.delete(0, sb.length());
        sb.append("Hello World!");
        System.out.println(String.format("In method: %s.", sb.toString()));
    }


    public void set(int val) {
        val = ++val;
        System.out.println(String.format("In method: %d.", val));
    }

    public void set(User user) {
        user.setName("Java");

        System.out.println(String.format("In method: %s.", user.getName()));
    }

    public void create(User user) {
        user = new User("WTF");

        System.out.println(String.format("In method: %s.", user.getName()));
    }

    public static void main(String[] args) {
        StringTest test = new StringTest();

        StringBuffer sb = new StringBuffer("Ni Hao!");
        int val = 1;
        User u = new User("Hello");
        System.out.println(String.format("Original string: %s, original int: %d, user: %s.", sb.toString(), val, u.getName()));
        // test.greet(sb.toString());
        test.set(sb);
        test.set(val);
        test.create(u);
        System.out.println(String.format("Final string: %s, final int: %d, final user: %s.", sb.toString(), val, u.getName()));

        System.out.println("123456".indexOf("null"));


    }


    static class User {

        String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
