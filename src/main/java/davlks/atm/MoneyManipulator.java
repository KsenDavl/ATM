package davlks.atm;

import lombok.Getter;

@Getter
public class MoneyManipulator {

    private int fiftyRubNotes;
    private int hundredRubNotes;
    private int fiveHundredRubNotes;
    private int thousandRubNotes;
    private int fiveThousandRubNotes;

    public MoneyManipulator(int fiftyRubNotes, int hundredRubNotes, int fiveHundredRubNotes, int thousandRubNotes, int fiveThousandRubNotes) {
        this.fiftyRubNotes = fiftyRubNotes;
        this.hundredRubNotes = hundredRubNotes;
        this.fiveHundredRubNotes = fiveHundredRubNotes;
        this.thousandRubNotes = thousandRubNotes;
        this.fiveThousandRubNotes = fiveThousandRubNotes;
    }

    public int getBalance() {
        int fifties = fiftyRubNotes * 50;
        int hundreds = hundredRubNotes * 100;
        int fiveHundreds = fiveHundredRubNotes * 500;
        int thousands = thousandRubNotes * 1000;
        int fiveThousands = fiveThousandRubNotes * 5000;
        return fifties + hundreds + fiveHundreds + thousands + fiveThousands;
    }

    public void addMoney(NotesCounter notesCounter) {
        this.fiftyRubNotes = this.fiftyRubNotes + notesCounter.getFiftyRubNotes();
        this.hundredRubNotes = this.hundredRubNotes + getHundredRubNotes();
        this.fiveHundredRubNotes = this.fiveThousandRubNotes + notesCounter.getFiveHundredRubNotes();
        this.thousandRubNotes = this.thousandRubNotes + notesCounter.getThousandRubNotes();
        this.fiveThousandRubNotes = this.fiveThousandRubNotes + notesCounter.getFiveThousandRubNotes();
    }

    public void withdrawMoney(NotesCounter notesCounter) {
        this.fiftyRubNotes = this.fiftyRubNotes - notesCounter.getFiftyRubNotes();
        this.hundredRubNotes = this.hundredRubNotes - getHundredRubNotes();
        this.fiveHundredRubNotes = this.fiveThousandRubNotes - notesCounter.getFiveHundredRubNotes();
        this.thousandRubNotes = this.thousandRubNotes - notesCounter.getThousandRubNotes();
        this.fiveThousandRubNotes = this.fiveThousandRubNotes - notesCounter.getFiveThousandRubNotes();
    }

}
