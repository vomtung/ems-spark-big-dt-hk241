package com.bigdatahk241.service;

import com.bigdatahk241.dto.ConsumedEnergyMonthDto;
import com.bigdatahk241.dto.ConsumedEnergyYearDto;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 * EMSAggMonthFactory
 *
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 30.Nov.2024
 */
public class EMSAggMonthFactory {


    public static List<ConsumedEnergyMonthDto> consumedEnergyByMonth() {
        SparkSession spark = SparkSession.builder()
                .appName("Energy Consumption By Year")
                .master("local")
                .getOrCreate();

        String jdbcUrl = "jdbc:mysql://localhost:3306/big_dt_hk241";
        String table = "ems_master";
        String user = "root";
        String password = "123456";

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
        Dataset<Row> monthDf = df.withColumn("month", functions.month(df.col("DATE_CREATED")));

        // Chuyển đổi dữ liệu sang RDD<Tuple2<Integer, Double>>: (year, salary)
        JavaRDD<Tuple2<Integer, Double>> yearSalaryRDD = monthDf.select("month", "ENERGY_CONSUMPTION")
                .javaRDD()
                .map(row -> new Tuple2<>(row.getInt(0), row.getDouble(1)));

        // Nhóm theo year và tính tổng salary
        JavaPairRDD<Integer, Double> totalSalaryByYear = yearSalaryRDD
                .mapToPair(tuple -> new Tuple2<>(tuple._1, tuple._2))
                .reduceByKey(Double::sum);

        // Hiển thị kết quả
        List<ConsumedEnergyMonthDto> consumedEnergyYearDtos = new ArrayList<>();
        totalSalaryByYear.collect().forEach(tuple -> {
            ConsumedEnergyMonthDto dto = new ConsumedEnergyMonthDto(tuple._1, tuple._2);
            consumedEnergyYearDtos.add(dto);
        });

        spark.stop();

        return consumedEnergyYearDtos;
    }

}
