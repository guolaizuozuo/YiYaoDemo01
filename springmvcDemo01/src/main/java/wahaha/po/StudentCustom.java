package wahaha.po;

import java.util.List;

public class StudentCustom extends  Student {
    private  Grade grade;
    private List<ResultCustom> resultCustomList;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<ResultCustom> getResultCustomList() {
        return resultCustomList;
    }

    public void setResultCustomList(List<ResultCustom> resultCustomList) {
        this.resultCustomList = resultCustomList;
    }
}
