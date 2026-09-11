package edu.hbuas.campustodo.model;

import java.util.Date;

/**
 * 任务实体类
 */
public class Task {
    private Long id;
    private String title;
    private String content;
    private Date createTime;
    private Date deadline;
    private Boolean finished;
    // 新增优先级字段
    private Priority priority;

    // 无参构造
    public Task() {
    }

    // 全参构造（包含priority）
    public Task(Long id, String title, String content, Date createTime, Date deadline, Boolean finished, Priority priority) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.deadline = deadline;
        this.finished = finished;
        this.priority = priority;
    }

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    // toString，包含priority
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", finished=" + finished +
                ", priority=" + priority +
                '}';
    }
}
