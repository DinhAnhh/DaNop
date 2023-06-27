
public class Wallet {

    private int amount;

    /**
     * Constructs a new Wallet object with an initial amount of 0.
     */
    public Wallet() {
        amount = 0;
    }

    /**
     * Retrieves the current amount in the wallet.
     * @return the amount in the wallet
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount in the wallet.
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
