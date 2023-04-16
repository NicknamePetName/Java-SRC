package se.design_philosophy.srp;

public class Course {
    private String name;
    private int score;
    private String courseName;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }

    public String getCourseName() {
        return courseName;
    }
}
