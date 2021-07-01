package cn.acyco.atimelog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Acyco
 * @create 2021-07-01 03:11
 * @url https://acyco.cn
 */
public class EventLogBean {
    private long id;
    private String event; //事件
    private Date startTime; //开始时间
    private Date endTime; //结束时间
    private String type; //类别
    private String note; //注释 or 备注
    private String duration; //持续时间

    public EventLogBean(long id, String event, Date startTime, Date endTime, String type, String duration, String note) {
        this.id = id;
        this.event = event;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.type = note;
        this.duration = duration;
    }

    public EventLogBean(String event, Date startTime) {
        this.event = event;
        this.startTime = startTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartDate() {
        if (null == this.startTime) {
            return "StartDate";
        } else {
            return Canstant.DATEFORMAT.format(this.startTime);
        }
    }

    public String getStartTimes() {
        if (null == this.startTime) {
            return "StartTime";
        } else {
            return Canstant.TIMEFORMAT.format(this.startTime);
        }
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getEndDate() {
        if (null == this.endTime) {
            return "EndDate";
        } else {
            return Canstant.DATEFORMAT.format(this.endTime);
        }
    }

    public String getEndTimes() {
        if (null == this.endTime) {
            return "EndTime";
        } else {
            return Canstant.TIMEFORMAT.format(this.endTime);
        }
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDuration() {

        StringBuilder sb = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sb.append(dateFormat.format(this.startTime)); //

        if (null == this.endTime) { //如果没结束时间 持续时间就是开始时间

        } else {
            sb.append(diff(this.endTime, this.startTime)); //
        }
        this.duration = sb.toString();

        return this.duration;
    }

    private String diff(Date endTime, Date startTime) {
        long seconds;
        seconds = (endTime.getTime() - startTime.getTime()) / 1000;
        int hours = (int) seconds / (60 * 60);
        seconds = seconds - hours * 3600;
        int minute = (int) seconds / 60;
        StringBuilder dura = new StringBuilder();
        if (hours > 0) {
            dura.append(" " + hours + "hr ");
        }
        if (minute > 0) {
            dura.append(" " + minute + " min");
        }
        if (dura.length() == 0) {
            return " less than one minute"; //小于一分钟
        } else {
            return dura.toString();
        }

    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
