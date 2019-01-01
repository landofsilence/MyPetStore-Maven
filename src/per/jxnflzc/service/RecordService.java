package per.jxnflzc.service;

import per.jxnflzc.domain.Record;
import per.jxnflzc.persistence.RecordDAO;
import per.jxnflzc.persistence.impl.RecordDAOImpl;

import java.util.List;

public class RecordService {
    private  RecordDAO recordDAO;
    public  RecordService(){
        recordDAO = new RecordDAOImpl();
    }



    public boolean InsertRecord(Record record){
        return  recordDAO.InsertRecord(record);
    }
    public Record getRecord(String recordId){
        return recordDAO.getRecord(recordId);
    }
    public List<Record> getRecordList(String userId){
        return recordDAO.getRecordList(userId);
    }
}
