package se.lexikon.team_workshop;

public class BankAccountSequencer {
    static int counter = 0;

    public static int nextBankAccountId(){
        return ++counter;
    }

    public static int getBankAccountId(){
        return counter;
    }

    public static void resetBankAccountId(){
        counter = 0;
    }
}
