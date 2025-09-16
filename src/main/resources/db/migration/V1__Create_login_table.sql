CREATE TABLE employee (
   id UUID NOT NULL,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(50) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE campbooking (
  id UUID NOT NULL,
  bookingname VARCHAR(100) NOT NULL,
  bookingdate DATE NOT NULL,
  bookinguser UUID NOT NULL,
  foodrequired BOOLEAN NOT NULL,
  drinksrequired BOOLEAN NOT NULL,
  bonfirerequired BOOLEAN NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (bookinguser) REFERENCES employee(id)
);

INSERT INTO employee (id, username, password)
VALUES ('c27daaa5-c209-4453-8380-b8670d149b25', 'bob', 'cancelled');

INSERT INTO campbooking (id, bookingname, bookingdate, bookinguser, foodRequired, drinksRequired, bonFireRequired)
VALUES
    (UUID(), 'Booking 1', '2023-11-01', 'c27daaa5-c209-4453-8380-b8670d149b25', true, false, true),
    (UUID(), 'Booking 2', '2023-12-01', 'c27daaa5-c209-4453-8380-b8670d149b25', false, true, false);
