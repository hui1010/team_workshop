package se.lexikon.team_workshop;

public class CustomerSequencer {
    static int counter = 0;

    public static int nextCustomerId(){

        return ++counter;
    }

    public static int getCustomerId(){
        return counter;
    }

    public static void resetCustomerId(){
        counter = 0;
    }
}
