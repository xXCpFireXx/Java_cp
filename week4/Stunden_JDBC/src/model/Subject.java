package model;

public class Subject {
    private int idSubject;
    private String nameSubject;
    private double grade;

    public Subject() {
    }

    public Subject(int idSubject, String nameSubject, double grade) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.grade = grade;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}