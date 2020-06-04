///**
// * ItemshipmentInfo.java
// * 
// * created on September 30 2014
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.io.Serializable;
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
////import sunwell.permaisuri.core.entity.cred.UserGroup;
//
///**
// *
// * @author Benny
// */
//@Entity
//@Table( name = "itemshipmentinfo" )
//public class ItemShipmentInfo 
//{
//    @Id
//    @Column( name = "systemid" )
//    private int  systemId ;
//    
//    @NotNull(message="{error_no_name}")
//    @Column( name ="shipment_name" )
//    private String name ;
//    
//    @Column( name = "memo" )
//    private String memo ;
//        
//    public ItemShipmentInfo()
//    {
//        
//    }
//    
//    public ItemShipmentInfo(int _id)
//    {
//        systemId = _id;
//    }
//    
//    public ItemShipmentInfo(String _name)
//    {
//        name = _name;
//    }
//    
//    
//    public void setSystemId( int _id )
//    {
//        systemId = _id ;
//    }
//    
//    public int getSystemId()
//    {
//        return systemId ;
//    }
//    
//    public void setName( String _name )
//    {
//        name = _name ;
//    }
//    
//    public String getName()
//    {
//        return name ;
//    }
//    
//    public void setMemo( String _memo )
//    {
//        memo = _memo ;
//    }
//    
//    public String getMemo()
//    {
//        return memo ;
//    }
//    
//    
//    @Override
//    public String toString()
//    {
//        return name ;
//    }
//    
//
//    public int hashCode() {
////    	return systemId != null ? systemId.hashCode() : 0;
//    	return systemId;
//    }
//
//    @Override
//    public boolean equals (Object obj)
//    {
//    	if(obj == null)
//    		return false;
//        if (!(obj instanceof ItemShipmentInfo)) {
//            return false;
//        }
//        
//        ItemShipmentInfo other = (ItemShipmentInfo) obj;
////        if ((this.systemId == null && other.systemId != null) || 
////            (this.systemId != null && !this.systemId.equals(other.systemId))) {
////            return false;
////        }
////        return true;
//        return systemId == other.systemId;
//    }
//}
