package com.liveamonth.liveamonth.entity.vo;

public class ScheduleVO {

    //should add more city
    public enum Place {SEOUL, JEJU}

    ;

    private int scheduleNO;
    private String scheduleSubject;
    private int scheduleLikeCount;
    private boolean scheduleStatus;
    private int userNO;
    private Place place;


    public Place getPlace() {
        return place;
    }


    public void setPlace(Place place) {
        this.place = place;
    }


    public int getScheduleNO() {
        return scheduleNO;
    }


    public void setScheduleNO(int scheduleNO) {
        this.scheduleNO = scheduleNO;
    }


    public String getScheduleSubject() {
        return scheduleSubject;
    }

    public void setScheduleSubject(String scheduleSubject) {
        this.scheduleSubject = scheduleSubject;
    }

    public int getScheduleLikeCount() {
        return scheduleLikeCount;
    }

    public void setScheduleLikeCount(int scheduleLikeCount) {
        this.scheduleLikeCount = scheduleLikeCount;
    }

    public boolean isScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(boolean scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public int getUserNO() {
        return userNO;
    }

    public void setUserNO(int userNO) {
        this.userNO = userNO;
    }

    public ScheduleVO() {
        this.scheduleNO = 0;
        this.scheduleSubject = null;
        this.scheduleLikeCount = 0;
        this.scheduleStatus = false;
        this.userNO = 0;
        this.place = Place.SEOUL;
    }

}
