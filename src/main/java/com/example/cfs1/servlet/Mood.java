package com.example.cfs1.servlet;

import java.io.Serializable;

public class Mood implements Serializable {
	/** java bean del Mood
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int moodId;
    private String mood;
    public Mood() {}

    public Mood(int moodId, String mood) {
        this.moodId = moodId;
        this.mood = mood;
    }

    // Getter e Setter per moodId
    public int getMoodId() {
        return moodId;
    }

    public void setMoodId(int moodId) {
        this.moodId = moodId;
    }

    // Getter e Setter per mood
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

  
    @Override
    public String toString() {
        return "Mood [moodId=" + moodId + ", mood=" + mood + "]";
    }
}