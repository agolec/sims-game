package entities;

import entities.needs.human.Needs;
import entities.personality.human.PersonalityTraits;

import java.util.HashMap;
import java.util.Map;

public abstract class Entity {
    private String name;
    private Map<PersonalityTraits,Integer> personality;
    private Map<Needs,Integer> currentMood;

    private final int MINIMUM_PERSONALITY_AND_MOOD_VALUE = 0;
    private final int MAXIMUM_PERSONALITY_AND_MOOD_VALUE = 10;


    public Entity(){
        personality = new HashMap<>();
        setDefaultPersonality();
        setDefaultNeeds();
    }

    /**
     * setDefaultPersonality will call setPersonalityTrait for each trait in the PersonalityTraits.values() method, and set them to the value 5, half-
     * way between 0 and 10.
     */
    private void setDefaultPersonality() {
        for(PersonalityTraits trait: PersonalityTraits.values()){
            setPersonalityTrait(trait,(MAXIMUM_PERSONALITY_AND_MOOD_VALUE / 2));
        }
    }

    /**
     *
     * @param trait - an enum from PersonalityTraits to be modified
     * @param value - The value from 0 to 10 inclusive that is desired for the PersonalityTrait being set.
     */
    public void setPersonalityTrait(PersonalityTraits trait, int value){
        if(value < MINIMUM_PERSONALITY_AND_MOOD_VALUE || value > MAXIMUM_PERSONALITY_AND_MOOD_VALUE){
            throw new IllegalArgumentException("Personality traits must have a value between 0 and 10.");
        }
        this.personality.put(trait,value);
    }
    public void reversePersonalityTraits(){
        for(Map.Entry<PersonalityTraits,Integer> entry: this.personality.entrySet()){
            PersonalityTraits trait = entry.getKey();
            int currentValueOfEntryTrait = entry.getValue();
            int reversedValueOfEntryTrait = 10 - currentValueOfEntryTrait;
            setPersonalityTrait(trait,reversedValueOfEntryTrait);
        }
    }
    private void setDefaultNeeds(){
        for(Needs needs : Needs.values()){
            setNeed(needs, MAXIMUM_PERSONALITY_AND_MOOD_VALUE);
        }
    }
    public void setNeed(Needs need, int value){
        if(value < MINIMUM_PERSONALITY_AND_MOOD_VALUE || value > MAXIMUM_PERSONALITY_AND_MOOD_VALUE){
            throw new IllegalArgumentException("Mood traits must have a value between 0 and 10.");
        }
        this.currentMood.put(need,value);
    }
    public Map<PersonalityTraits,Integer> getPersonalityTraits(){
        Map<PersonalityTraits,Integer> copy = new HashMap<>();
        for(Map.Entry<PersonalityTraits,Integer> entry: personality.entrySet()){
            copy.put(entry.getKey(),entry.getValue());
        }
        return copy;
    }
    public int getTraitScore(PersonalityTraits trait){
        if(!personality.containsKey(trait)){
            throw new IllegalArgumentException("Personality trait not found.");
        }
        return personality.get(trait);
    }


}
