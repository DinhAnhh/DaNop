
public class Person {

    private Wallet wallet;

    /**
     * Constructs a new Person object with an empty wallet.
     */
    public Person() {
        wallet = new Wallet();
    }

    /**
     * Retrieves the wallet object associated with the person.
     * @return the wallet object
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * Sets the wallet object for the person.
     * @param wallet the wallet object to set
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
