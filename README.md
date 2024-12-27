This is a sample project to understand Spring boot's transaction management.

Different transaction logics are implemented in different branches.

Branch name - simple_transaction_rollback

Inside the UserService the ongoing Transaction is rolled back.
The updated username is not commited to the database because the changes are implemented in a transaction and the transaction rolls back because of the RuntimeException.
The database changes are hence not commited.
