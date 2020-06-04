///**
// * SalesPackage.java
// *
// * Created on Apr 10, 2015, 1:10:36 PM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
///**
// *
// * @author Benny
// * @author Daisy
// */
//
//import java.sql.*;
//import java.util.*;
//import javax.persistence.*;
//
//
//@Entity
//@Table( name = "salespackage")
//public class SalesPackage extends Product
//{  
//    @OneToMany( mappedBy = "m_salesPackage", cascade = CascadeType.ALL )
//    private List<SalesPackageItem> m_arrPackage ;
//    
//    @OneToMany( mappedBy = "m_salesPackage", cascade = CascadeType.ALL )
//    private List<SalesPackageService> m_arrService ;
//    
//    @OneToMany( mappedBy = "m_salesPackage", cascade = CascadeType.ALL )
//    private List<SalesPackageBonusItem> m_arrBonus ;
////    private int m_id ;
//    
//    
//    private boolean m_populatedFromDB = false;
//    
//    
//    /**
//     * @roseuid 45C9A40001F4
//     */
//    public SalesPackage ()
//    {
//        this (-1);
//    }
//
//    public SalesPackage (int _id)
//    {
//        super (_id);
//        m_arrPackage = null;
//        m_arrService = null ;
//        m_arrBonus = null ;
//    }
//    
////    public int getID () { return m_id ; }
////        
////    public void setID (int _id)
////    {
////        m_id = _id ;
////    }    
//    
//    public List<SalesPackageItem> getItems () { return m_arrPackage ; }
//        
//    public List<SalesPackageService> getServices () { return m_arrService ; }
//
//    public List<SalesPackageBonusItem> getBonuses () { return m_arrBonus ; }
//    
//    
//    public void setItems (SalesPackageItem[] _arrItem)
//    {
//        m_arrPackage = Arrays.asList (_arrItem) ;
//        for( int i = 0 ; i < m_arrPackage.size () ; i++ )
//        {
//            m_arrPackage.get (i).setSalesPackage (this);
//        }
//    }
//    
//    public void setServices (SalesPackageService[] _arrServices)
//    {
//       m_arrService = Arrays.asList (_arrServices) ; 
//       for( int i = 0 ; i < m_arrService.size () ; i++ )
//       {
//          m_arrService.get (i).setSalesPackage (this);
//       }
//    }
//    
//    public void setBonuses (SalesPackageBonusItem[] _arrBonuses)
//    {
//       m_arrBonus = Arrays.asList (_arrBonuses) ; 
//       for( int i = 0 ; i < m_arrBonus.size () ; i++ )
//       {
//          m_arrBonus.get (i).setSalesPackage (this);
//       }
//    }
//    
////
////    @Override
////    public boolean isPopulatedFromDB ()
////    {
////        return m_populatedFromDB;
////    }
////
////    @Override
////    public void resetAttributes ()
////    {
////        super.resetAttributes ();
////        m_populatedFromDB = false;
////        
////        m_arrPackage = null;
////        m_arrService = null;
////        m_arrBonus = null ;
////    }
////
////    @Override
////    public boolean populateAttributes () throws SQLException
////    {
////        Statement stmt = null;
////        StringBuilder sql;
////        ResultSet rs;
////        
////        SalesPackageItem[] arrPackage = SalesPackageItem.getAllBySalesPackageID (this.getID ());
////        SalesPackageService[] arrService = SalesPackageService.getAllBySalesPackageID(this.getID ());
////        SalesPackageBonusItem[] arrBonus = SalesPackageBonusItem.getAllBySalesPackageID (this.getID ()) ;
////        
////        if( arrPackage != null )
////            m_arrPackage = Arrays.asList (arrPackage) ;
////        
////        if( arrService != null )
////            m_arrService = Arrays.asList (arrService) ;
////        
////        if( arrBonus != null )
////            m_arrBonus = Arrays.asList (arrBonus) ;
////        
////        super.populateAttributes ();
////        m_populatedFromDB = true;
////        return true ;
////    }
////    
//// 
////  
////
////    @Override
////    public boolean insertToDB () throws SQLException
////    {
////        PreparedStatement ps = null;
////        StringBuilder sql = new StringBuilder (256);
////        boolean bool2 = false ; 
////        int n = 0 ;
////
////        try {
////            // insert ke base-class
////            boolean bool = super.insertToDB ();
////            if (! bool)
////                return false;
////            
////            sql.append ("INSERT INTO salespackage( id_sp) VALUES (" + this.getID () +")");
////            
////
////            ps = MainAppRuntime.getDBConnection ().getConnection ().prepareStatement (sql.toString ());
////            
////            n = ps.executeUpdate ();
////            
////            for( int i = 0 ; i < m_arrPackage.size () ; i++ )
////                m_arrPackage.get (i).insertToDB () ;
////            
////            for( int i = 0 ; i < m_arrService.size () ; i++ )
////                m_arrService.get (i).insertToDB () ;
////            
////            for( int i = 0 ; i < m_arrBonus.size () ; i++ )
////                m_arrBonus.get (i).insertToDB () ;
////            
////
////            return (bool && (n > 0)  );
////        }
////        catch (SQLException e) {
////            MainAppRuntime.getDBConnection ().getConnection ().rollback ();
////            throw e;
////        }
////        finally {
////            if (ps != null)
////                try { ps.close (); } catch (SQLException t) { }
////        }
////    }
////
////    @Override
////    public boolean updateToDB () throws SQLException
////    {
////        
////        try {
////            // #1.
////            System.out.println ("The ID is: " + this.getID ());
////            SalesPackageItem.deleteAllBySalesPackage (this.getID ()) ;
////            SalesPackageService.deleteAllBySalesPackage (this.getID () );
////            SalesPackageBonusItem.deleteAllBySalesPackage (this.getID () );
////            
////            for( int i = 0 ; i < m_arrPackage.size () ; i++ )
////                m_arrPackage.get (i).insertToDB () ;
////            
////            for( int i = 0 ; i < m_arrService.size () ; i++ )
////                m_arrService.get (i).insertToDB () ;
////            
////            for( int i = 0 ; i < m_arrBonus.size () ; i++ )
////                m_arrBonus.get (i).insertToDB () ;
////            
////           return super.updateToDB () ;
////        }
////        catch (SQLException x) {
////            MainAppRuntime.getDBConnection ().getConnection ().rollback ();
////            throw x;
////        }
////        finally {
////            
////        }
////    }
////
////    /**
////     * Sama dengan method {@link Product#isProductNameExistsInDB(String _name)}
////     * 
////     * @param _itemName
////     * @return
////     * @throws SQLException
////     * @see Product#isProductNameExistsInDB(String _name)
////     */
//// 
////    @Override
////    public boolean deleteFromDB() throws SQLException
////    {
////        Statement stmt = null;
////        String sql;
////
////        try {
////            SalesPackageItem.deleteAllBySalesPackage (this.getID ()) ;
////            SalesPackageService.deleteAllBySalesPackage (this.getID () );
////            SalesPackageBonusItem.deleteAllBySalesPackage (this.getID () );
////            
////            sql = "DELETE FROM salespackage WHERE id_sp = " + this.getID ();
////            stmt = MainAppRuntime.getDBConnection ().getConnection ().createStatement ();
////            stmt.executeUpdate (sql);
////            super.deleteFromDB ();
////
////            return true;
////        }
////        catch (SQLException x) {
////            MainAppRuntime.getDBConnection ().getConnection ().rollback ();
////            throw x;
////        }
////        finally {
////            if (stmt != null)
////                try { stmt.close (); } catch (SQLException w) { }
////        }
////    }
////    
////    @Override
////    public boolean isExistsInDB() throws SQLException
////    {
////        Statement stmt = null;
////        String sql = "SELECT id_sp FROM salespackage WHERE id_sp = " + this.getID ();
////        ResultSet rs;
////
////        try {
////            stmt = MainAppRuntime.getDBConnection ().getConnection ().createStatement (ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
////            rs = stmt.executeQuery (sql);
////            
////            if (! rs.next ())
////                return false;
////            else
////                return true;
////        }
////        catch (SQLException x) {
////            MainAppRuntime.getDBConnection ().getConnection ().rollback ();
////            throw x;
////        }
////        finally {
////            if (stmt != null)
////                try { stmt.close (); } catch (SQLException w) { }
////        }
////    }
//
//    @Override
//    public boolean equals (Object obj)
//    {
//        if(obj instanceof SalesPackage)
//        {
//            if (((SalesPackage) obj).getSystemId () == this.getSystemId ())
//            {
//                return true;
//            }
//        }
//        return false;
//    } 
//
//    @Override
//    public String toString ()
//    {
//        return getName () ;
//    }
//}
