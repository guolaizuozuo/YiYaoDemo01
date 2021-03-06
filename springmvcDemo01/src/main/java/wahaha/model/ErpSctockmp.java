package wahaha.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 分店销售订单模型
 * @author ouyang
 * @data 2017年11月23日13:40:27
 */
public class ErpSctockmp {
    private String saleId;				//主键ID
    private String staffId;				//员工ID
    private String annexId;				//分店ID
    private String memberId;			//会员ID
    private Integer saleNum;			//销售总数量
    private Date saleDate;				//订单时间
    private BigDecimal saleMoney;		//原金额
    private BigDecimal saleDiscount;	//折扣
    private BigDecimal saleMoney1;		//应付金额
    private BigDecimal saleMoney2;		//实付金额
    private BigDecimal saleMoney3;		//找零
    private Integer saleIfWholesale;	//是否批发
    private Integer saleWholesaleState;	//批发状态
    private String creater;				//创建人
    private Date createtime;			//创建时间
    private String remark;				//备注
    
   
	/**
     * 是否批发 
     * @return
     */
    public Integer getSaleIfWholesale() {
		return saleIfWholesale;
	}
    /**
     * 是否批发
     * @param saleIfWholesale
     */
	public void setSaleIfWholesale(Integer saleIfWholesale) {
		this.saleIfWholesale = saleIfWholesale;
	}
	/**
	 * 批发状态
	 * @return
	 */
	public Integer getSaleWholesaleState() {
		return saleWholesaleState;
	}
	/**
	 * 批发状态
	 * @param saleWholesaleState
	 */
	public void setSaleWholesaleState(Integer saleWholesaleState) {
		this.saleWholesaleState = saleWholesaleState;
	}
	/**
     * 原金额
     * @return
     */
    public BigDecimal getSaleMoney() {
		return saleMoney;
	}
    /**
     * 原金额
     * @param saleMoney
     */
	public void setSaleMoney(BigDecimal saleMoney) {
		this.saleMoney = saleMoney;
	}
	/**
	 * 折扣
	 * @return
	 */
	public BigDecimal getSaleDiscount() {
		return saleDiscount;
	}
	/**
	 * 折扣
	 * @param saleDiscount
	 */
	public void setSaleDiscount(BigDecimal saleDiscount) {
		this.saleDiscount = saleDiscount;
	}
	/**
     * 主键ID 
     * @return
     */
    public String getSaleId() {
        return saleId;
    }
    /**
     * 主键ID
     * @param saleId
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }
    /**
     * 员工ID
     * @return
     */
    public String getStaffId() {
        return staffId;
    }
    /**
     * 员工ID
     * @param staffId
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
    /**
     * 分店ID
     * @return
     */
    public String getAnnexId() {
        return annexId;
    }
    /**
     * 分店ID
     * @param annexId
     */
    public void setAnnexId(String annexId) {
        this.annexId = annexId == null ? null : annexId.trim();
    }
    /**
     * 会员ID
     * @return
     */
    public String getMemberId() {
        return memberId;
    }
    /**
     * 会员ID
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }
    /**
     * 销售总数量
     * @return
     */
    public Integer getSaleNum() {
        return saleNum;
    }
    /**
     * 销售总数量
     * @param saleNum
     */
    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }
    /**
     * 订单时间
     * @return
     */
    public Date getSaleDate() {
        return saleDate;
    }
    /**
     * 订单时间
     * @param saleDate
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    /**
     * 应付金额
     * @return
     */
    public BigDecimal getSaleMoney1() {
        return saleMoney1;
    }
    /**
     * 应付金额
     * @param saleMoney
     */
    public void setSaleMoney1(BigDecimal saleMoney1) {
        this.saleMoney1 = saleMoney1;
    }
    /**
     * 实付金额
     * @return
     */
    public BigDecimal getSaleMoney2() {
        return saleMoney2;
    }
    /**
     * 实付金额
     * @param saleMoney2
     */
    public void setSaleMoney2(BigDecimal saleMoney2) {
        this.saleMoney2 = saleMoney2;
    }
    /**
     * 找零
     * @return
     */
    public BigDecimal getSaleMoney3() {
        return saleMoney3;
    }
    /**
     * 找零
     * @param saleMoney3
     */
    public void setSaleMoney3(BigDecimal saleMoney3) {
        this.saleMoney3 = saleMoney3;
    }
    /**
     * 创建人
     * @return
     */
    public String getCreater() {
        return creater;
    }
    /**
     * 创建人
     * @param creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }
    /**
     * 创建时间
     * @return
     */
    public Date getCreatetime() {
        return createtime;
    }
    /**
     * 创建时间
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    /**
     * 备注
     * @return
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}