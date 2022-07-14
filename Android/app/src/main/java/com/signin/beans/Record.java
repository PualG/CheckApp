package com.signin.beans;

public class Record {
    private String date_time;
    private String name;
    private String temp;
    private String temp1;
    private String temp2;
    private String temp3;
    private String temp4;
    private String temp8;
    private String temp5;
    private String location;
    private String temp6;
    private String temp9;
    private String temp7;

    public Record() {

    }

    public Record(String date_time, String name, String temp, String temp1, String temp2, String temp3, String temp4, String temp8, String temp5,String location, String temp6, String temp9, String temp7) {
        this.date_time = date_time;
        this.name = name;
        this.temp = temp;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
        this.temp8 = temp8;
        this.temp5 = temp5;
        this.location = location;
        this.temp6 = temp6;
        this.temp9 = temp9;
        this.temp7 = temp7;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }
    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp1() {
        return temp1;
    }
    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp2() {
        return temp2;
    }
    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    public String getTemp3() {
        return temp3;
    }
    public void setTemp4(String temp4) {this.temp4 = temp4;}

    public String getTemp4() {
        return temp4;
    }
    public void setTemp8(String temp8) {this.temp8 = temp8;}

    public String getTemp8() {
        return temp8;
    }
    public void setTemp5(String temp5) {
        this.temp5 = temp5;
    }

    public String getTemp5() {
        return temp5;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
    public void setTemp6(String temp6) {
        this.temp6 = temp6;
    }

    public String getTemp6() {
        return temp6;
    }
    public void setTemp9(String temp9) {
        this.temp9 = temp9;
    }

    public String getTemp9() {
        return temp9;
    }
    public void setTemp7(String temp7) {
        this.temp7 = temp7;
    }

    public String getTemp7() {
        return temp7;
    }
}
