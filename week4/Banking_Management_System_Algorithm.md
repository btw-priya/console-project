# Banking Management System - Week 4 Algorithm

## 1. Create Account
1. Read Account ID, holder name and opening balance.
2. Validate the input.
3. Check `TreeMap.containsKey(accountId)`.
4. If the ID already exists, reject the account.
5. Otherwise create an `Account` object.
6. Store it using `accounts.put(accountId, account)`.
7. Display success.

## 2. Deposit
1. Read Account ID and amount.
2. Use `TreeMap.get(accountId)`.
3. If the account does not exist, reject the operation.
4. Validate that amount is positive.
5. Add the amount to the account balance.

## 3. Withdraw
1. Read Account ID and amount.
2. Retrieve the account using `get()`.
3. Check that the amount is positive.
4. Check that sufficient balance is available.
5. Subtract the amount.
6. Display the result.

## 4. Check Balance
1. Read Account ID.
2. Retrieve the account using `get()`.
3. If found, display account details and balance.
4. Otherwise display Account Not Found.

## 5. View Sorted Ledger
1. Retrieve `accounts.values()`.
2. Iterate through the collection.
3. Because `TreeMap` sorts integer keys naturally, accounts appear in ascending Account ID order.
4. Display each account.

## Key Data Structure

```text
TreeMap<Integer, Account>
```

TreeMap provides sorted key-based storage and direct lookup.
