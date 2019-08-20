package wahaha.po;

import java.util.Date;

public class Result {
    private int id;
    private int studentNo;
    private int subjectNo;
    private Date examDate;
    private int studentResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public int getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(int subjectNo) {
        this.subjectNo = subjectNo;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(int studentResult) {
        this.studentResult = studentResult;
    }
}
