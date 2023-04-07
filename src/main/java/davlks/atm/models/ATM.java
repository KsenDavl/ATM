package davlks.atm.models;

import davlks.atm.exceptions.IncorrectAmountException;
import davlks.atm.exceptions.NotEnoughMoneyException;

public class ATM {

    private final MoneyCounter moneyCounter;

    public ATM(MoneyCounter moneyCounter) {
        this.moneyCounter = moneyCounter;
    }

    public void receiveMoney(int fiftyRubNotes, int hundredRubNotes, int fiveHundredRubNotes,
                             int thousandRubNotes, int fiveThousandRubNotes) {

        moneyCounter.addMoney(new NotesCounter(fiftyRubNotes, hundredRubNotes, fiveHundredRubNotes,
                thousandRubNotes, fiveThousandRubNotes));
    }

    public void withdrawMoney(int amount) {
        if (amount > moneyCounter.getBalance()) {
            throw new NotEnoughMoneyException();
        }
        if (amount % 100 != 0) {
            throw new IncorrectAmountException();
        }

        NotesCounter notesCounter = getNotesToWithdraw(amount);
        moneyCounter.withdrawMoney(notesCounter);
    }

    public int getBalance() {
         return moneyCounter.getBalance();
    }

    private NotesCounter getNotesToWithdraw(int amount) {

        int fiveThousandsToWithdraw = amount / 5000;
        int availableFiveThousands = moneyCounter.getFiveThousandRubNotes();
        int fiveThousands = Math.min(availableFiveThousands, fiveThousandsToWithdraw);
        amount -= fiveThousands * 5000;

        int thousandsToWithdraw = amount / 1000;
        int availableThousands = moneyCounter.getThousandRubNotes();
        int thousands = Math.min(availableThousands, thousandsToWithdraw);
        amount -= thousands * 1000;

        int fiveHundredsToWithdraw = amount / 500;
        int availableFiveHundreds = moneyCounter.getFiveHundredRubNotes();
        int fiveHundreds = Math.min(availableFiveHundreds, fiveHundredsToWithdraw);
        amount -= fiveHundreds * 500;

        int hundredsToWithdraw = amount / 100;
        int availableHundreds = moneyCounter.getHundredRubNotes();
        int hundreds = Math.min(availableHundreds, hundredsToWithdraw);
        amount -= hundreds * 100;

        int fifties = amount / 50;

        return new NotesCounter(fiveThousands, thousands, fiveHundreds, hundreds, fifties);

    }
}
