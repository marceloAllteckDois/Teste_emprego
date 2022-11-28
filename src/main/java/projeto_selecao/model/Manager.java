package projeto_selecao.model;

public class Manager extends Employe{

	public Manager(String name,int hireMonth, int hireYear) {
		super(name, hireMonth, hireYear);
		this.setSalary(20000);
		this.setAdjust(3000);
	}
	
}
