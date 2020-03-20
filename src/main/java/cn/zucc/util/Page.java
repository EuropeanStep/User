package cn.zucc.util;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private List<T> page;

    private boolean hasNext;

    private boolean hasPre;

    private int pageCount;

    private int pageNo;
}
