# Creating a database using the generated .sql file
##Using the MySQL (technically MariaDB) server on the IMCE VM
1. SSH to the IMCE VM
2. Get the .sql file onto the server (git checkout, SCP, etc.)
3. Run `mysql -u root -p`
4. Enter the MySQL root password (be careful!) `imcedev` (LDAP authentication will be implemented at some point)
5. Run `source <filename>.sql`
6. This will essentially run the lines in the .sql file in order
7. Any errors will be displayed as they occur. Note that valid lines will be executed, even if invalid lines appear later in the file. For example, as long as the `CREATE SCHEMA` line is valid, the database will be created, even if some of the table definitions have errors.
8. To start from scratch, run `DROP DATABASE OML`. Since this is the root account, be very careful not to delete any other databases. 