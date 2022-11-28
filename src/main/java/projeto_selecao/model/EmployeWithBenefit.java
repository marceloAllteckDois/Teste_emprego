package projeto_selecao.model;

public abstract class EmployeWithBenefit extends Employe{
	
	private double benefitValue;
	private double benefitPercent;

	public EmployeWithBenefit(String name, int hireMonth, int hireYear) {
		super(name, hireMonth, hireYear);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getBenefit(int month, int year) {
		this.benefitValue = this.getSalaryPerMonth(month, year) * this.benefitPercent;
		return this.benefitValue;
	}

	public double getBenefitValue() {
		return benefitValue;
	}

	public void setBenefitValue(double benefitValue) {
		this.benefitValue = benefitValue;
	}

	public double getBenefitPercent() {
		return benefitPercent;
	}

	public void setBenefitPercent(double benefitPercent) {
		this.benefitPercent = benefitPercent;
	}
	
}
