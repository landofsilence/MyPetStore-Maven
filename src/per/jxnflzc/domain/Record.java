package per.jxnflzc.domain;

import java.util.Date;

public class Record {
    private int recordId;
    private String userId;
    private int actionType;
    //type1=viewCategory,2=viewProduct,3=viewItem,4=addTocart,5=generateOrder
    private Date date;
    private  String id;
    private int count;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String generateDescription(){
        //type1=viewCategory,2=viewProduct,3=viewItem,4=addTocart,5=generateOrder
        String basic = "";
        switch (actionType){
            case 1:basic = "view Category <a href=\"viewCategory?categoryId=" + this.id + "\">"+this.id+ "</a>";break;
            case 2:basic = "view Product <a href=\"viewProduct?productId=" + this.id + "\">"+this.id+ "</a>";break;
            case 3:basic = "view Item <a href=\"viewItem?itemId=" + this.id + "\">"+this.id+ "</a>";break;
            case 4:basic = "add "+ " <a href=\"viewItem?itemId=" + this.id + "\">"+this.id+ "</a> to the Cart";break;
            case 5:basic = "place the order <a href=\"viewOrder?orderId=" + this.id + "\">"+this.id+ "</a> Succesfully";break;
        }
        description = basic;
        return basic;

    }
}
