/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytechapp.pojo;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class QuestionStore {
    ArrayList<QuestionPojo> questionlist=new ArrayList<>();
    public QuestionStore()
    {
    questionlist=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "QuestionStore{" + "questionlist=" + questionlist + '}';
    }
    public void addQuestion(QuestionPojo q){
    questionlist.add(q);
    }
    public void removeQuestion(int pos){
    questionlist.remove(pos);
    }
    public QuestionPojo getQuestion(int pos){
    return questionlist.get(pos);
    }
    public void setQuestionAt(int pos,QuestionPojo q){
    questionlist.add(pos,q);
    }
    public ArrayList<QuestionPojo> getAllQuestions(){
    return questionlist;
    }
    public int getCount(){
    return questionlist.size();
    }
    
}
