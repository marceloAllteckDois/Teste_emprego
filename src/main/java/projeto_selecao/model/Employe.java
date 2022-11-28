package projeto_selecao.model;

import java.util.Calendar;

public abstract class Employe implements IEmploye{
	private double salary;
	private double adjust;
	private Calendar hireDate;
	private String name;
	
	public Employe(String name, int hireMonth, int hireYear) {
		this.name = name;
		this.hireDate = setCalendarInstance(hireMonth, hireYear);
	}
	
	private Calendar setCalendarInstance(int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		return calendar;
	}
	
	public double getSalaryPerMonth(int month, int year) {
		int employeYears = year - hireDate.get(Calendar.YEAR);
		if (employeYears < 0) employeYears = 0;
		return salary + (adjust * employeYears);
	}
	public double getBenefit(int month, int year) {
		return 0;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAdjust() {
		return adjust;
	}

	public void setAdjust(double adjust) {
		this.adjust = adjust;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
