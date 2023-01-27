# bus_mgmt by Aditya R

Sequence of Tasks performed:

1. Finalising Architecture of the project
2. Defining Controller, Service, Dao Layer.
--> User can view single bus, view all buses, add bus, delete bus, update bus. ( Same operations on routes, passenegers, buses).
--> Tables: bus, route, passenger, ticket.
3. Initial implementation on JPA then on JDBC.
--> Database - MySQL
4. Adding ticket booking functionality. 
-->Checks if bus is available, if so then checks if seats are available in bus, then books ticket. availlable seats in bus is updated and a new ticket is booked.
5. Error Handling (Not Null, Record does not exist).
5. Use of Cache (Redis)
6. Use of Scheduler
