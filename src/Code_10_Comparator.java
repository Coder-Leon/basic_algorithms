import java.util.Arrays;
import java.util.Comparator;

public class Code_10_Comparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        // 如果要按照升序排序， 则o1小于o2，返回负数，相等返回0，o1大于o2返回正数
        // Java中排序默认实现为升序
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {
        // 如果要按照降序排序， 则o1小于o2，返回正数，相等返回0，o1大于o2返回负数
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void printStudent(Student[] students) {
        for (Student student : students) {
            System.out.println("Id: " + student.id + " Name: " + student.name + " Age:" + student.age);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[]{student3, student1, student2};
        printStudent(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudent(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudent(students);
    }


}
