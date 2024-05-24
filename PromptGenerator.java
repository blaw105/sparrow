//package com.sparrow;
import java.util.*;

public class PromptGenerator {
    private String  mood;
    private ArrayList<String> Happy=new ArrayList<String>();
    private ArrayList<String> Surprised=new ArrayList<String>();
    private ArrayList<String> Satisfied=new ArrayList<String>();
    private ArrayList<String> Loved=new ArrayList<String>();
    private ArrayList<String> Angry=new ArrayList<String>();
    private ArrayList<String> Sad=new ArrayList<String>();
    private ArrayList<String> Stressed=new ArrayList<String>();
    

    public PromptGenerator(JournalEntry a){
        mood=a.getMood();
    }

    public void start(){
        Happy.add("What are you most happy about today, and why?");
        Happy.add("Where do you feel happiness in your body? How does joy show up physically for you?");
        Happy.add("Are there any other emotions aside from happiness that you’re feeling? List them out and describe how they make you feel.");
        Happy.add("What are five goals (big or small!) that you accomplished recently? ");
        Happy.add("When was the last time you were proud of yourself? How can you find that same (or similar) pride soon if you haven’t felt it for a while?");
        Happy.add("Are there any aspects of your life that you’re unhappy with? Why, and what might you be able to do to change those things?");
        Happy.add("What do you need when you’re feeling most burnt out? What helps you when you’re super overwhelmed?");
        Happy.add("How do you talk to yourself when you’re happy? How do you talk to yourself when you’re unhappy? Do you notice any similarities or differences?");
        Happy.add("List out five of your greatest strengths and five things you can work on."); 
        Happy.add("Who are the people who make you happiest? How are your relationships with those people right now? Is there anything you want to do differently in those relationships?");

        Angry.add("Reflect on a recent situation where you felt angry. What triggered this emotion?");
        Angry.add("Describe how you typically manage anger. Are there healthier strategies you could employ?");
        Angry.add("Write about a time when someone else's anger affected you. How did you respond?");
        Angry.add("Explore the connection between your anger and your physical health. How does anger impact your body?");
        Angry.add("List five anger journaling prompts you find helpful in processing negative emotions.");
        Angry.add("Recall a moment when you felt intensely angry. How did it influence your self-esteem?");
        Angry.add("Analyze any recurring negative thoughts associated with your anger. How can you challenge or change them?");
        Angry.add("Consider a time when your anger worsened a situation. What could you have done differently?");
        Angry.add("Reflect on how your anger has affected your personal and professional life. Are there areas you'd like to improve?");
        Angry.add("Write about the positive aspects of anger. How might it catalyze change?");
        Angry.add("Use journaling as a tool for self-discovery. What have you learned about yourself through exploring your rage?");

        Sad.add("Where is this sadness coming from? What is it about? (If you don’t know, just free write about how you’re feeling.)");
        Sad.add("Are there certain people, places, or situations that are making you sad?");
        Sad.add("Where do you feel sadness in your body? What physical sensations come up for you?");
        Sad.add("Within that sadness, is there someone or something that you’ve lost? How are you dealing with that loss?");
        Sad.add("Have you experienced similar sadness before? How did you cope last time, and how might you want to cope differently or similarly this time?");
        Sad.add( "How long have you been feeling this sadness? Does it come and go in waves, or is it constant? Describe if there are any patterns of triggers and/or timing of your sad feelings.");
        Sad.add( "What makes you feel the happiest, and how can you move toward that happiness right now?");
        Sad.add( "If you took a break from your sadness, what would you want that break to look like? (BTW, it doesn’t have to be a happy break. It can be neutral or angry or any type of break you want.)");
        Sad.add( "What would your sadness look like if it were a painting or drawing? You don’t actually have to sketch it out, but describe what the colors, shapes, and images would look like.");
        Sad.add( "Who gives you the most comfort when you’re feeling sad? Why and how do they bring you this comfort?");

        Stressed.add("What is currently causing me stress?");
        Stressed.add("How is this stress impacting my daily life?");
        Stressed.add("What emotional, physical, or financial need can I connect to this stress?");
        Stressed.add( "Where do I feel stress feel in my body?");
        Stressed.add( "What are some small, manageable steps I can take today towards resolving a primary source of my stress?");
        Stressed.add(  "What is one thing I can let go of (a task, a worry, an obligation) to reduce my stress?");
        Stressed.add(  "If I could give this stressful situation a title like a chapter in a book, what would it be?");
        Stressed.add(  "What can I do to take care of myself today?");
        Stressed.add(  "What is a positive affirmation I can tell myself during this stressful time?");
        Stressed.add(  "Who can I reach out to for support?");

        Surprised.add("What was the last thing that genuinely surprised me? Describe the situation and my initial reaction.");
        Surprised.add("Reflect on a recent surprise encounter or event. How did it make me feel? Did it challenge any assumptions or beliefs I held?");
        Surprised.add("How do I typically react to surprises? Do I embrace them with curiosity, or do I feel anxious or unsettled?");
        Surprised.add("Think about a time when a surprise turned out to be a positive experience. What did I learn from it?");
        Surprised.add("Consider a surprise that initially seemed negative or challenging. How did I cope with it, and what lessons did I take away from the experience?");
        Surprised.add(" Reflect on surprises in the context of personal growth. How can unexpected events or revelations contribute to my development and understanding of myself?");
        Surprised.add("Explore any recurring patterns or themes in the surprises I encounter. Are there aspects of my life or mindset that may attract certain types of surprises?");
        Surprised.add("Write about a surprise encounter with someone else. How did their reaction differ from mine, and what insights can I gain from their perspective?");
        Surprised.add("Imagine a future scenario where I intentionally seek out surprises. What activities or experiences could I pursue to cultivate a sense of wonder and discovery?");
        Surprised.add("Reflect on the role of uncertainty in life. How can surprises remind me to embrace the unknown and appreciate the unexpected twists and turns?");

        Satisfied.add("Think of a recent achievement or accomplishment that left me feeling deeply satisfied. What did I do to reach this goal, and how do I feel looking back on it now?");
        Satisfied.add("Reflect on a specific moment today when I felt truly content and fulfilled. What were the circumstances surrounding this feeling, and what made it so gratifying?");
        Satisfied.add("Consider a long-term aspiration or dream that I've recently made progress towards. How does this progress contribute to my overall sense of satisfaction and fulfillment?");
        Satisfied.add("Write about a recent act of kindness or generosity that brought me joy. How did it feel to make a positive impact on someone else's life?");
        Satisfied.add("Reflect on the aspects of my life that bring me the most satisfaction and fulfillment. How can I nurture and prioritize these elements to cultivate a greater sense of overall well-being?");
        Satisfied.add("Explore the connection between gratitude and satisfaction. What am I grateful for in this moment, and how does this gratitude contribute to my overall satisfaction with life?");
        Satisfied.add("Write about a recent moment of self-care or relaxation that left me feeling rejuvenated and content. How can I incorporate more of these moments into my daily routine?");
        Satisfied.add("Consider the people in my life who contribute to my sense of satisfaction and happiness. How can I express my appreciation for their presence and support?");
        Satisfied.add("Reflect on the alignment between my values and my actions. How do my daily choices reflect what truly matters to me, and how does this alignment contribute to my overall satisfaction with life?");
        Satisfied.add("Imagine my ideal future self, living a life filled with satisfaction and fulfillment. What steps can I take today to move closer to this vision?");

        Loved.add("Reflect on a specific moment today when I felt deeply loved. What were the circumstances surrounding this feeling, and how did it manifest?");
        Loved.add("Write about the people in my life who make me feel loved and cherished. What qualities do they possess that make their love so meaningful to me?");
        Loved.add("Consider the ways in which I express love to others. How do I demonstrate my affection, care, and appreciation for the people I love?");
        Loved.add("Explore the different love languages that resonate with me. How do I prefer to give and receive love, and how can I communicate my needs and preferences to my loved ones?");
        Loved.add("Write a letter to someone I love dearly, expressing my gratitude and affection for them. What do I appreciate most about our relationship, and how does their love enrich my life?");
        Loved.add("Reflect on the impact that love has had on my overall well-being and sense of belonging. How does feeling loved contribute to my happiness and fulfillment?");
        Loved.add("Consider the ways in which I show love and kindness to myself. How do I practice self-compassion and self-care, and how does this self-love enhance my relationships with others?");
        Loved.add("Write about a memorable experience or gesture of love that deeply touched my heart. How did it make me feel, and what lasting impact did it have on me?");
        Loved.add("Explore any challenges or obstacles that may arise in my relationships with loved ones. How can I navigate these challenges with empathy, understanding, and a commitment to maintaining strong connections?");
        Loved.add("Imagine a future filled with love, joy, and deep connections with the people who matter most to me. What steps can I take today to nurture and strengthen these relationships?");
    }
    public String random(ArrayList<String> a){  //just helper method
        return a.get((int)(Math.random()*(a.size()+1)));
    }
    public void addPrompt(String prom, String pmood){
        if(pmood=="happy"){
            Happy.add(prom);
        }
        else if(pmood=="surprised"){
            Surprised.add(prom);
        }
        else if(pmood=="satisfied"){
            Satisfied.add(prom);
        }
        else if(pmood=="loved"){
            Loved.add(prom);
        }
        else if(pmood=="angry"){
            Angry.add(prom);
        }
        else if(pmood=="sad"){
            Sad.add(prom);
        }
        else if(pmood=="stressed"){
            Stressed.add(prom);
        }
        else{
            System.out.println("The mood doesn't exist in our system.");
        }
    }
    public String getPrompt(){
        if(mood=="happy"){
            return random(Happy);
        }
        else if(mood=="surprised"){
            return random(Surprised);
        }
        else if(mood=="satisfied"){
            return random(Satisfied);
        }
        else if(mood=="loved"){
            return random(Loved);
        }
        else if(mood=="angry"){
            return random(Angry);
        }
        else if(mood=="sad"){
            return random(Sad);
        }
        else if(mood=="stressed"){
            return random(Stressed);
        }
        else{
            System.out.println("The mood doesn't exist in our system.");
            return "";
        }
    }
}
