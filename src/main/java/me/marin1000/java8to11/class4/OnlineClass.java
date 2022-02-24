package me.marin1000.java8to11.class4;

import java.util.Optional;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress>  getProgress() {
//        return Optional.ofNullable(progress);   // ofNullable : 뒤에 들어오는것이 null 일수도 있을때 사용
        return Optional.empty(); // null리턴 하지말고 이렇게 사용
    }

}
