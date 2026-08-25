# Banking Management System - Week 5 Algorithm

## 1. Create Account
1. Read Account ID, holder name, and opening balance.
2. Validate the input.
3. Load existing accounts from `accounts.txt`.
4. Check if Account ID already exists.
5. If duplicate, reject the account.
6. Otherwise create an `Account` object.
7. Append it to the file.
8. Display success.

## 2. Deposit
1. Read Account ID and amount.
2. Load accounts from file.
3. If account does not exist, reject the operation.
4. Validate that amount is positive.
5. Add the amount to the account balance.
6. Save updated accounts back to file.

## 3. Withdraw
1. Read Account ID and amount.
2. Load accounts from file.
3. Validate that amount is positive.
4. Check sufficient balance.
5. Subtract the amount.
6. Save updated accounts back to file.
7. Display result.

## 4. Check Balance
1. Read Account ID.
2. Load accounts from file.
3. If found, display account details and balance.
4. Otherwise display Account Not Found.

## 5. Persistence
1. All operations update `accounts.txt` immediately.
2. On program restart, accounts are reloaded from file.

## Key Data Structure

```text
Text File (accounts.txt)
Format: AccountID|Name|Balance
