package DataObjects;

public enum Account {
    USERNAME("ccc@gmail.com"),
    PASSWORD("11111111");
    public final String account;

    Account(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }
}
