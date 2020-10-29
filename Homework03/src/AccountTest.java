public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122,20000);
        account.setAnnualInterestRate(4.5);
        System.out.println(account);
        account.withDraw(2000);
        account.deposit(3000);
        System.out.println(account);
    }
}
