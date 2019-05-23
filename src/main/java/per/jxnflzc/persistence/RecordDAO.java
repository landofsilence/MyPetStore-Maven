package per.jxnflzc.persistence;

import per.jxnflzc.domain.Record;

import java.util.List;

public interface RecordDAO {
    boolean InsertRecord(Record record);
    Record getRecord(String recordId);
    List<Record> getRecordList(String userId);

}
