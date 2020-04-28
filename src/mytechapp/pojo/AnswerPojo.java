/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytechapp.pojo;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class AnswerPojo {
    private String examid;
    private String subject;
    private int qno;
    private String chosenanswer;
    private String correctanswer;
    
    public AnswerPojo(){}

    public AnswerPojo(String examid, String subject, int qno, String chosenanswer, String correctanswer) {
        this.examid = examid;
        this.subject = subject;
        this.qno = qno;
        this.chosenanswer = chosenanswer;
        this.correctanswer = correctanswer;
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public String getChosenanswer() {
        return chosenanswer;
    }

    public void setChosenanswer(String chosenanswer) {
        this.chosenanswer = chosenanswer;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    @Override
    public String toString() {
        return "AnswerPojo{" + "examid=" + examid + ", subject=" + subject + ", qno=" + qno + ", chosenanswer=" + chosenanswer + ", correctanswer=" + correctanswer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnswerPojo other = (AnswerPojo) obj;
        if (this.qno != other.qno) {
            return false;
        }
        if (!Objects.equals(this.examid, other.examid)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.chosenanswer, other.chosenanswer)) {
            return false;
        }
        if (!Objects.equals(this.correctanswer, other.correctanswer)) {
            return false;
        }
        return true;
    }
    
}
