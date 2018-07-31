package com.ty.lambda;

import java.util.Comparator;

/**
 * 长度比较器
 *
 * @author tianyi
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
