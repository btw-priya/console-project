# Abstract - Banking Management System Week 5

The Banking Management System is a console-based Java application designed to demonstrate **Text File storage**. The application manages bank accounts and supports account creation, deposits, withdrawals, and balance checking, with persistence across program restarts.

In Week 5, the storage structure is changed from in-memory collections to **file-based storage** using `BufferedReader` and `BufferedWriter`. Account data is saved in a human-readable `.txt` file with delimiter-based parsing (e.g., `AccountID|Name|Balance`). This ensures that account details remain available even after the program terminates.

The project maintains separation between the Account model, DAO storage layer, service layer, and console user interface. Duplicate Account IDs are prevented by checking existing records before writing to the file. Retrieval operations parse the text file back into `Account` objects.

This implementation demonstrates Java File I/O, persistence, exception handling, and structured text-based storage.
