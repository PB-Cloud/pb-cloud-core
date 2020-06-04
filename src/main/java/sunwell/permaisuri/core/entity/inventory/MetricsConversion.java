//package sunwell.permaisuri.core.entity.inventory;
//
//
//
////Source file: C:\\Documents and Settings\\root\\My Documents\\LT_Corporation\\Projects\\OnGoing\\Permaisuri Ban\\Program\\demeter\\src\\demeter\\inventory\\MetricsConversion.java
//
//
//import java.io.Serializable;
//
//import java.sql.*;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
///**
// * Konversi nilai antara satuan. Misal dari Gram ke Kilogram, maka factor-nya
// * adalah 1000.
// * 
// * @version 1.0 - 2007 ; initial version.
// * @version 1.2 - Jun 27, 2015 ; revisi method getConversion() agar mencari dari
// *                  arah sebaliknya jika tidak ditemukan konversi dari parameter _to dan _from
// *                  yang diberikan user.
// *
// * @author Irfin A
// */
//@Entity
//@Table(name="metricsconversion")
//@IdClass(MetricsConversionPK.class)
//public class MetricsConversion 
//{
//    /** No rounding */
//    public static final int ROUND_OFF = 0;
//    /** Round up */
//    public static final int ROUND_UP = 1;
//    /** Round down */
//    public static final int ROUND_DOWN = 2;
//    
//    @NotNull(message="{error_no_first_metric}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "frommetrics")
//    private Metrics fromMetrics;
//    
//    @NotNull(message="{error_no_second_metric}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "tometrics")
//    private Metrics toMetrics;
//    
//    @Column( name = "factor" )
//    private double factor;
//    
//    
//    /** Nilai disesuaikan dengan konstanta ROUND_XXX */
//    @Column( name = "rounding" )
//    private Integer rounding = ROUND_OFF;
//    
//    
//    /**
//     * @roseuid 460F572800FA
//     */
//    public MetricsConversion ()
//    {
//        rounding = ROUND_OFF;
//        factor = 1;
//        
//        fromMetrics = null;
//        toMetrics = null;
//    }
//    
//    public Metrics getFromMetrics ()
//    { 
//        return fromMetrics; 
//    }
//    
//    public void setFromMetrics (Metrics m_fromMetrics)
//    {
//        this.fromMetrics = m_fromMetrics;
//    }
//    
//    public Metrics getToMetrics ()
//    { 
//        return toMetrics; 
//    }
//    
//    public void setToMetrics (Metrics m_toMetrics)
//    {
//        this.toMetrics = m_toMetrics;
//    }
//    
//    public Double getFactor ()
//    { 
//        return factor; 
//    }
//    
//    /**
//     *<pre>
//     * I.S : Nilai parameter _factor tidak boleh nol.
//     *</pre>
//     */
//    public void setFactor (Double _factor)
//    {
//        this.factor = _factor;
//    }
//    
//    /**
//     * @see latifolia.exerphi.app.inventory.MetricsConversion#ROUND_OFF
//     * @see latifolia.exerphi.app.inventory.MetricsConversion#ROUND_UP
//     * @see latifolia.exerphi.app.inventory.MetricsConversion#ROUND_DOWN
//     */
//    public Integer getRounding ()
//    { 
//        return rounding; 
//    }
//    
//    /**
//     *<pre>
//     * I.S: Nilai _rounding HARUS salah satu dari {@link latifolia.exerphi.app.inventory.MetricsConversion#ROUND_OFF},
//     *      {@link latifolia.exerphi.app.inventory.MetricsConversion#ROUND_UP}, atau
//     *      {@link latifolia.exerphi.app.inventory.MetricsConversion#ROUND_DOWN}.
//     *      Jika tidak, maka dianggap ROUND_OFF.
//     *</pre>
//     */
//    public void setRounding (Integer _rounding)
//    {
//        if ((_rounding != ROUND_DOWN) && (_rounding != ROUND_UP) && (_rounding != ROUND_OFF))
//            this.rounding = ROUND_OFF;
//        else
//            this.rounding = _rounding;
//    }  
//    
//    @Override
//    public boolean equals (Object _m)
//    {
//    	if(_m == null)
//    		return false;
//        if (!(_m instanceof MetricsConversion)) {
//            return false;
//        }
//        
//        MetricsConversion other = (MetricsConversion) _m;
//        if ((this.fromMetrics == null && other.fromMetrics != null) || 
//            (this.fromMetrics != null && !this.fromMetrics.equals(other.fromMetrics))) {
//            return false;
//        }
//        if ((this.toMetrics == null && other.toMetrics != null) || 
//            (this.toMetrics != null && !this.toMetrics.equals(other.toMetrics))) {
//            return false;
//        }
//        return true;
//    }
//    
//    @Override
//    public int hashCode() {
//    	int hash = 0;
//    	hash += fromMetrics != null ? fromMetrics.hashCode() : 0;
//    	hash += toMetrics != null ? toMetrics.hashCode() : 0;
//    	return hash;
//    }  
//}
