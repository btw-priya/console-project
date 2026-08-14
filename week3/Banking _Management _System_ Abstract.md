# Week 3 – LinkedHashMap Storage

## Abstract

The Bank Management System is a Java-based application used to manage customer bank accounts. In Week 3, the system uses a `LinkedHashMap<Integer, Account>` to store account information. The account ID is used as the key, allowing accounts to be accessed directly without manual searching loops.

Unlike `HashMap`, `LinkedHashMap` maintains the insertion order of records. The system provides operations such as creating an account, depositing money, withdrawing money, checking balance, and viewing all accounts. The application also separates data storage logic into an `AccountDAO` class for better organization and maintainability.