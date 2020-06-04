//package sunwell.permaisuri.core.entity.inventory;
//
//import java.io.Serializable;
//
//public class MetricsConversionPK implements Serializable {
//	private String fromMetrics;
//	private String toMetrics;
//	public String getFromMetrics() {
//		return fromMetrics;
//	}
//	public void setFromMetrics(String _fromMetrics) {
//		this.fromMetrics = _fromMetrics;
//	}
//	public String getToMetrics() {
//		return toMetrics;
//	}
//	public void setToMetrics(String _toMetrics) {
//		this.toMetrics = _toMetrics;
//	}
//	
//	@Override
//    public int hashCode ()
//    {
//    	int hash = 0;
//        hash += fromMetrics != null ? fromMetrics.hashCode() : 0;
//        hash += toMetrics != null ? toMetrics.hashCode () : 0;
//        return hash;
//    }
//	
//	@Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof MetricsConversionPK)) {
//            return false;
//        }
//        MetricsConversionPK other = (MetricsConversionPK) object;
////        if (this.fromMetrics.equals(other.fromMetrics))
////            return false;
////        if (this.toMetrics.equals(other.toMetrics))
////            return false;
//        
//        if(fromMetrics != null)
//        	if(!fromMetrics.equals(other.fromMetrics))
//        		return false;
//        else 
//	    	if(other.fromMetrics != null)
//	    		return false;
//        
//        
//        if(toMetrics != null)
//        	if(!toMetrics.equals(other.toMetrics))
//        		return false;
//        else
//        	if(other.toMetrics != null)
//        		return false;
//        
//        return true;
//    }
//}
