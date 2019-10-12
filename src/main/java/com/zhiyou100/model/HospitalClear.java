package com.zhiyou100.model;

import java.util.List;

public class HospitalClear {
    private Integer id;

    private String medical_record;

    private String clear_status;

    private Double total_cost;

    private String cash_pledge;

    private Double still_need_pay;

    private Double balance;

    private String clear_time;

    private Double medical_costs;

    private Double drug_cost;

    private Double amount_paid;
    
    private RegistrationInfor registrationInfor;
    
    private HospitalInfor hospitalInfor;
    
    private List<ChargeManager> chargeManager;
    
    public HospitalInfor getHospitalInfor() {
		return hospitalInfor;
	}

	public void setHospitalInfor(HospitalInfor hospitalInfor) {
		this.hospitalInfor = hospitalInfor;
	}

	public List<ChargeManager> getChargeManager() {
		return chargeManager;
	}

	public void setChargeManager(List<ChargeManager> chargeManager) {
		this.chargeManager = chargeManager;
	}

	private Drug drug ;

	public RegistrationInfor getRegistrationInfor() {
		return registrationInfor;
	}

	public void setRegistrationInfor(RegistrationInfor registrationInfor) {
		this.registrationInfor = registrationInfor;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public String getClear_status() {
		return clear_status;
	}

	public void setClear_status(String clear_status) {
		this.clear_status = clear_status;
	}

	public Double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}

	public String getCash_pledge() {
		return cash_pledge;
	}

	public void setCash_pledge(String cash_pledge) {
		this.cash_pledge = cash_pledge;
	}

	public Double getStill_need_pay() {
		return still_need_pay;
	}

	public void setStill_need_pay(Double still_need_pay) {
		this.still_need_pay = still_need_pay;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getClear_time() {
		return clear_time;
	}

	public void setClear_time(String clear_time) {
		this.clear_time = clear_time;
	}

	public Double getMedical_costs() {
		return medical_costs;
	}

	public void setMedical_costs(Double medical_costs) {
		this.medical_costs = medical_costs;
	}

	public Double getDrug_cost() {
		return drug_cost;
	}

	public void setDrug_cost(Double drug_cost) {
		this.drug_cost = drug_cost;
	}

	public Double getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(Double amount_paid) {
		this.amount_paid = amount_paid;
	}

	@Override
	public String toString() {
		return "HospitalClear [id=" + id + ", medical_record=" + medical_record + ", clear_status=" + clear_status
				+ ", total_cost=" + total_cost + ", cash_pledge=" + cash_pledge + ", still_need_pay=" + still_need_pay
				+ ", balance=" + balance + ", clear_time=" + clear_time + ", medical_costs=" + medical_costs
				+ ", drug_cost=" + drug_cost + ", amount_paid=" + amount_paid + ", registrationInfor="
				+ registrationInfor + ", hospitalInfor=" + hospitalInfor + ", chargeManager=" + chargeManager
				+ ", drug=" + drug + "]";
	}

    
}