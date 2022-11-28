package projeto_selecao.model;

import java.util.Calendar;

public class Secretary extends EmployeWithBenefit{

	public Secretary(String name, int hireMonth, int hireYear) {
		super(name, hireMonth, hireYear);
		this.setSalary(7000);
		this.setAdjust(1000);
		this.setBenefitPercent(0.2);
	}

}
