# Week 3 – LinkedHashMap Storage

## Algorithm

1. Start the program.

2. Create a `LinkedHashMap<Integer, Account>` to store account details.

3. Display the main menu:
   - Create Account
   - Deposit
   - Withdraw
   - Balance Check
   - View All Accounts
   - Exit

4. If the user selects **Create Account**:
   - Read Account ID, name, and initial balance.
   - Check whether the Account ID already exists using `containsKey()`.
   - If it exists, display an error message.
   - Otherwise, add the account to the `LinkedHashMap`.

5. If the user selects **Deposit**:
   - Read the Account ID.
   - Retrieve the account using `get(accountId)`.
   - If the account exists, add the deposit amount to the balance.
   - Otherwise, display "Account not found."

6. If the user selects **Withdraw**:
   - Read the Account ID.
   - Retrieve the account using `get(accountId)`.
   - Check whether sufficient balance is available.
   - If sufficient, subtract the withdrawal amount.
   - Otherwise, display "Insufficient balance."

7. If the user selects **Balance Check**:
   - Read the Account ID.
   - Retrieve the account using `get(accountId)`.
   - Display the account balance.

8. If the user selects **View All Accounts**:
   - Traverse the `LinkedHashMap`.
   - Display all accounts in their insertion order.

9. If the user selects **Exit**:
   - Terminate the program.

10. Repeat the menu until the user chooses Exit.

11. Stop the program.