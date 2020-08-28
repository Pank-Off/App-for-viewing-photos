package com.popularlibrary.viewingphotos.test;

import java.util.ArrayList;
import java.util.List;

class TestModel {
    List<String> list = new ArrayList<>();

    List<String> getList(){
        list.add("AAAA");
        list.add("BBBB");
        list.add("CCCC");
        list.add("DDDD");
        return list;
    }
}
