# Banking Management System - Week 5

## Topic
File Storage (Text File)

## Objective
Upgrade the banking application to use **Text File storage** so that account data persists even after the program restarts.

## Core Features
- Create a new bank account
- Deposit money
- Withdraw money
- Check account balance
- Prevent duplicate Account IDs
- Maintain clean separation between account data and banking operations

## Technical Focus
- Use `BufferedReader` and `BufferedWriter` for file I/O.
- Store data in a `.txt` file with delimiter-based parsing (e.g., `AccountID|Name|Balance`).
- Implement proper exception handling (`IOException`, `FileNotFoundException`).
- DAO layer handles all file operations (save/load).
- Ensure file remains human-readable and structured.

## Week 5 Acceptance Criteria
1. Data persists after program restart.
2. File contains readable structured text (e.g., `101|Priya|5000`).
3. No corruption or duplication of records.
4. Deposit and withdrawal operate on the correct account.
5. Balance cannot become negative.
6. Evaluators can open the `.txt` file and verify account details directly.

## Example
If accounts are created:

```text
101|Priya|5000
102|Arun|12000
103|Meena|7500
