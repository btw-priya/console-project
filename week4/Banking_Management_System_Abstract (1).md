# Abstract - Banking Management System Week 4

The Banking Management System is a console-based Java application designed to demonstrate TreeMap storage. The application manages bank accounts and supports account creation, deposits, withdrawals, balance checking and sorted account viewing.

In Week 4, the storage structure is changed to `TreeMap<Integer, Account>`. The Account ID is used as the key. Unlike an ordinary HashMap, TreeMap maintains its keys in natural ascending order. Therefore, the sorted ledger can be displayed without a separate sorting algorithm.

The project also maintains separation between the Account model, DAO storage layer, service layer and console user interface. Duplicate Account IDs are prevented using `containsKey()`, while account retrieval uses `get()` for direct key-based access.

This implementation demonstrates Java Collections, object-oriented programming, data validation and sorted key-value storage.
