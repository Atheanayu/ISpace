package Ispace01.service;

import Ispace01.pojo.Relation;

import java.util.List;

public interface SQLRelationRelavent {
    public Relation addRelation(Relation relation);
    public Relation searchRelationID(Long id);
    public Relation searchRelationUPID(Long userID, Long projectID);
    public List<Relation> searchRelationUserID(Long userID);
    public List<Relation> searchRelationProjectID(Long projectID);
    public int deleteRelation(Long id);
    public Relation modifyRelation(Relation relation);
}
