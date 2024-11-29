# nhóm BIG-DT-HK241

## setup project
1. install java11
2. install maven, install mysql
3. mvn clean install
4. mvn jetty:run

user can access application via link
[http://localhost:8080/ems/](http://localhost:8080/ems/)
[http://localhost:8080/ems/index.jsp](http://localhost:8080/ems/index.jsp)

## table structure
schema big_dt_hk241

table ems_master

| Column      | Column                                 | Column                | column            |
|-------------|----------------------------------------|-----------------------|-------------------|
| DEVICE_ID   | DEVICE_NAME                            | ENERGY_CONSUMPTION    | DATE_CREATED      |
| ----------- | --------------                         | -------------------   | ----------------  |
| INT         | VARCHAR(5000)                          | DOUBLE                | DATETIME          |
|-------------| -------------------------------------- | --------------------- | ------------------ |


Table structure

![Example Image](images/table_structure.png)

Data sample

![Example Image](images/ems_master_data_sample.png)
