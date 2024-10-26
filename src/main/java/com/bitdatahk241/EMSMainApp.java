package com.bitdatahk241;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class EMSMainApp {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf()
                .setAppName("Read MySQL Data")
                .setMaster("local")
                .set("spark.driver.extraJavaOptions", "--add-opens java.base/sun.nio.ch=ALL-UNNAMED")
                .set("spark.executor.extraJavaOptions", "--add-opens java.base/sun.nio.ch=ALL-UNNAMED");


        SparkSession spark = SparkSession.builder()
                .appName("Read MySQL Data")
                .master("local")
                .config(conf)
                .getOrCreate();

        // Cấu hình kết nối JDBC URL, tên bảng, username và password
        String jdbcUrl = "jdbc:mysql://localhost:3306/big_dt_hk241";
        String table = "ems_master";
        String user = "root";
        String password = "123456";

        // Đọc dữ liệu từ MySQL bằng JDBC
        Dataset<Row> df = spark.read()
                .format("jdbc")
                .option("url", jdbcUrl)
                .option("dbtable", table)
                .option("user", user)
                .option("password", password)
                .option("driver", "com.mysql.cj.jdbc.Driver")
                .load();

        // Hiển thị dữ liệu
        df.show();

        // Dừng SparkSession sau khi hoàn thành
        spark.stop();
    }
}
