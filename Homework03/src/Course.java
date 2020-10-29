import java.io.*;

public class Course implements Serializable {
    private String courseName;
    private String[] students = new String[100];
    private int numberofStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberofStudents] = student;
        numberofStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberofStudents() {
        return numberofStudents;
    }

    public void dropStudent(String student) {

    }

    public Course clone() {
        ByteArrayOutputStream bo = null;
        ObjectOutputStream oo = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            bi = new ByteArrayInputStream(bo.toByteArray());
            oi = new ObjectInputStream(bi);
            Course course = (Course) oi.readObject();
            return course;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(oo != null) {
                try {
                    oo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(oi != null) {
                try {
                    oi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
