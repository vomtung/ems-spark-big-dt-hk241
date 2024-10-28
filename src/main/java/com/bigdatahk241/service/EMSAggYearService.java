package com.bigdatahk241.service;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

/**
 * EMSAggYearService
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 */
public class EMSAggYearService {


    public static void consumedEnergyByYear() {
        SparkSession spark = SparkSession.builder()
                .appName("Salary By Year")
                .master("local")
                .getOrCreate();

        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String table = "employees";
        String user = "your_username";
        String password = "your_password";

        // Đọc dữ liệu từ MySQL
        Dataset<Row> df = spark.read()
                .format("jdbc")
                .option("url", jdbcUrl)
                .option("dbtable", table)
                .option("user", user)
                .option("password", password)
                .option("driver", "com.mysql.cj.jdbc.Driver")
                .load();

        // Thêm cột `year` chỉ chứa phần năm từ cột `DATETIME`
        Dataset<Row> yearDf = df.withColumn("year", functions.year(df.col("year_column")));

        // Chuyển đổi dữ liệu sang RDD<Tuple2<Integer, Double>>: (year, salary)
        JavaRDD<Tuple2<Integer, Double>> yearSalaryRDD = yearDf.select("year", "salary")
                .javaRDD()
                .map(row -> new Tuple2<>(row.getInt(0), row.getDouble(1)));

        // Nhóm theo year và tính tổng salary
        JavaPairRDD<Integer, Double> totalSalaryByYear = yearSalaryRDD
                .mapToPair(tuple -> new Tuple2<>(tuple._1, tuple._2))
                .reduceByKey(Double::sum);

        // Hiển thị kết quả
        totalSalaryByYear.collect().forEach(tuple ->
                System.out.println("Year: " + tuple._1 + ", Total Salary: " + tuple._2));

        spark.stop();
    }

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
