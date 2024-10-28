package com.bigdatahk241.dto;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseDto
 * @author vmtung.sdh231@hcmut.edu.vn, vomtung@gmail.com
 * @since 28.Otc.2024
 * @param <T>
 */

public class  BaseDto <T> {

    private List<T> data;

    public BaseDto(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
