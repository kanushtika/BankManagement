use bankmanagement;
CREATE TABLE customer(
  `id` integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `customer_name` varchar (255) NOT NULL,
  `identity_card_no` varchar (255) NOT NULL,
  `email` varchar (255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT customer_unique UNIQUE(identity_card_no)
);

CREATE TABLE account(
  `id` integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `customer_id` integer NOT NULL,
  `account_number` varchar (255) NOT NULL,
  `account_type` varchar(50),
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT fk_account_customer_id FOREIGN KEY(customer_id) REFERENCES customer(id),
   CONSTRAINT account_unique UNIQUE(account_number)
);

CREATE TABLE bank_transaction(
  `id` integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `account_id` integer NOT NULL,
  `transaction_amount` double NOT NULL,
  `transaction_type` varchar(50) NOT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `balance` double NOT NULL,
   CONSTRAINT fk_bank_transaction_account_id FOREIGN KEY(account_id) REFERENCES account(id)
);