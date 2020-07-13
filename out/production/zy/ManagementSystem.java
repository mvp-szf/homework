package lagou.test3;


import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hunter
 * @date 2020/7/13
 **/

public class ManagementSystem {

    private List<Student> studentList;

    private ManagementSystem(){}

    //必须使用有参的构造函数
    public ManagementSystem(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * 学生系统的方法
     * 分别有添加学生、删除学生、修改学生信息和查找学生信息
     */


    public boolean addStudent(Student student){
        return studentList.add(student);
    }

    public boolean revise(Student student){
        if (student != null) {
            Iterator<Student> iterator = studentList.iterator();
            while (iterator.hasNext()) {
                Student next = iterator.next();
                if (next.getStudentId() == student.getStudentId()) {
                    next.setName(student.getName());
                    next.setAge(student.getAge());
                    return true;
                }
            }
        }
        return false;
    }

    public Student getStudentInfo(int studentId){
        if (studentId > 0) {
            List<Student> collect = studentList.stream().filter(student -> student.getStudentId() == studentId).collect(Collectors.toList());
            if (collect != null && collect.size() > 0) {
                return collect.get(0);
            }
        }
        return null;
    }

    public boolean deleteStudent(int studentId){
        if (studentId > 0) {
            Iterator<Student> iterator = studentList.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getStudentId() == studentId) {
                    return studentList.remove(student);
                }
            }
        }
        return false;
    }

}
