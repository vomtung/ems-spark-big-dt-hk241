# nhóm BIG-DT-HK241

## setup project
1. 
2. install java11
2. install maven, install mysql
3. mvn clean install
4. mvn jetty:run

go to 
[http://localhost:8080/ems/](http://localhost:8080/ems/)
[http://localhost:8080/ems/index.jsp](http://localhost:8080/ems/index.jsp)

## table structure

table ems_master

| Column      | Column                                 | Column              | 
|-------------|----------------------------------------|---------------------|
| DEVICE_ID   | DEVICE_NAME                            | ENERGY_CONSUMPTION  |
| ----------- | --------------                         | ------------------- |
| INT         | VARCHAR(5000)                          | DECIMAL             | 
|-------------| -------------------------------------- |---------------------|



![Example Image](images/table_structure.png)

