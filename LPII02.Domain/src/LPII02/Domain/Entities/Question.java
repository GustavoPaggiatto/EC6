/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Domain.Entities;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Gustavo
 */
public class Question extends BaseEntity {

    private Difficulty difficulty;
    private Matter matter;
    private String fileGuid;
    private String enunciated;
    private byte[] image;
    private String answer;
    private Date insertDate;
    private Set<Alternative> alternatives;

    public Set<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Set<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public String getFileGuid() {
        return fileGuid;
    }

    public void setFileGuid(String fileGuid) {
        this.fileGuid = fileGuid;
    }

    public String getEnunciated() {
        return enunciated;
    }

    public void setEnunciated(String enunciated) {
        this.enunciated = enunciated;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
