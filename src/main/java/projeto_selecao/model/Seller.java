package projeto_selecao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Seller extends EmployeWithBenefit{
	
	private List<SellRegister> sellRegisterList = new ArrayList<SellRegister>();
	
	public Seller(String name, int hireMonth, int hireYear, List<SellRegister> sellRegisterList) {
		super(name, hireMonth, hireYear);
		this.setSalary(12000);
		this.setAdjust(1800);
		this.setBenefitPercent(0.3);
		this.sellRegisterList = sellRegisterList;
	}
	
	@Override
	public double getBenefit(int month, int year) {
		List<SellRegister> sellRegisterList = this.sellRegisterList.stream()
				.filter(sr -> sr.getMouthSells().get(Calendar.MONTH) == month && sr.getMouthSells().get(Calendar.YEAR) == year)
				.collect(Collectors.toList());
		if (sellRegisterList != null && !sellRegisterList.isEmpty()) {
			SellRegister sellRegister = sellRegisterList.get(0);
			this.setBenefitValue(sellRegister.getMouthProfit() * this.getBenefitPercent());
			return this.getBenefitValue();
		} else {
			return 0;
		}
		
	}
	
	public List<SellRegister> getSellRegisterList() {
		return sellRegisterList;
	}

	public void setSellRegisterList(List<SellRegister> sellRegisterList) {
		this.sellRegisterList = sellRegisterList;
	}

}
