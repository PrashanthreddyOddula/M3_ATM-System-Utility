# Test Plan and Test Ouput

| *Test ID* | *HLT ID* | *Description*                                              | *Exp IN* | *Exp OUT* | *Actual Out* |*PASS/FAIL*  |    
|-------------|-----|--------------------------------------------------------------|------------|-------------|----------------|------------------|
|  T_01|H_01|Enter your choice |Enter 2 for customer registration|Enter your customer number| Enter your customer number| PASS |
|  T_02|H_01|pin generation|Enter pin to be registered|your account is successfully registered|your account is successfully registered| PASS |
|  T_03|H_02|Enter your choice|Enter 1 for login|Enter customer number | Enter customer number | PASS |
|  T_04|H_02|pin confirmation|Enter your pin|Select the account you want to access|Select the account you want to access| PASS |
|  T_05|H_03|Selecting type of account| enter choice |Current Account,Savings Account,Exit |Current Account,Savings Account,Exit| PASS |
|  T_06|H_04|Checkings Account |Enter choice|View Balance,Cash Withdrawl,Deposit Funds,Transfer Funds,Exit|View Balance,Cash Withdrawl,Deposit Funds,Transfer Funds,Exit| PASS |
|  T_07|H_03|Checking account balence|Enter Choice|Current checking account balance|Current checking account balance| PASS |
|  T_08|H_03|Exit the Atm console|Enter choice|Thank you for using this ATM|Thank you for using this ATM|PASS|
|  T_09|H_05|If your pin or customer number is incorrect|enter customer number and pin|Wrong customer number or pin |Wrong customer number or pin|PASS |
