# Banking Management System - Week 4

## Topic
TreeMap Storage

## Objective
Upgrade the banking application to use `TreeMap<Integer, Account>` so accounts are stored and displayed in sorted order by Account ID.

## Core Features
- Create a new bank account
- Deposit money
- Withdraw money
- Check account balance
- Prevent duplicate Account IDs
- View all accounts
- View sorted ledger
- Maintain clean separation between account data and banking operations

## Technical Focus
- Use `TreeMap<Integer, Account>` as the main storage structure.
- Use Account ID as the key.
- Use `get()` for direct account lookup.
- Use `containsKey()` to prevent duplicate IDs.
- Use `entrySet()` / `values()` for displaying accounts.
- TreeMap automatically keeps keys sorted in ascending order.

## Week 4 Acceptance Criteria
1. View Sorted Ledger always displays accounts sorted by Account ID.
2. Output remains sorted regardless of insertion order.
3. Duplicate Account IDs are rejected.
4. Deposit and withdrawal operate on the correct account.
5. Balance cannot become negative.
6. Application runs without external database/persistence.

## Example
If accounts are created in this order:

```text
1003
1001
1002
```

Sorted Ledger:

```text
1001
1002
1003
```

## How to Run

### Compile
```bash
javac -d out src/*.java
```

### Run
```bash
java -cp out BankingManagementSystem
```

### Java version
Java 17 or later is recommended.
