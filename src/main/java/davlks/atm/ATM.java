package davlks.atm;

public class ATM {

    private final MoneyManipulator moneyManipulator;

    public ATM(MoneyManipulator moneyManipulator) {
        this.moneyManipulator = moneyManipulator;
    }

    public void receiveMoney(int fiftyRubNotes, int hundredRubNotes, int fiveHundredRubNotes,
                             int thousandRubNotes, int fiveThousandRubNotes) {

        moneyManipulator.addMoney(new NotesCounter(fiftyRubNotes, hundredRubNotes, fiveHundredRubNotes,
                thousandRubNotes, fiveThousandRubNotes));
    }

    public void withdrawMoney(int amount) {

    }

    public int getBalance() {
         return moneyManipulator.getBalance();
    }

    private void getNotesToWithdraw() {

    }
}
