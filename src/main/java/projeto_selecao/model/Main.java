package projeto_selecao.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		SellRegister[] anaSilviaRegister = {
			new SellRegister(12, 2021, 5200),
			new SellRegister(01, 2022, 4000),
			new SellRegister(02, 2022, 4200),
			new SellRegister(03, 2022, 5850),
			new SellRegister(04, 2022, 7000)
		};
		
		SellRegister[] joaoMendes = {
			new SellRegister(12, 2021, 3400),
			new SellRegister(01, 2022, 7700),
			new SellRegister(02, 2022, 5000),
			new SellRegister(03, 2022, 5900),
			new SellRegister(04, 2022, 6500)
		};
		Employe[] arrayEmploye = {
			new Secretary("Jorge Carvalho", 1,2018),
			new Secretary("Maria Souza", 12, 2015),
			new Seller("Ana Silva", 12, 2021, Arrays.asList(anaSilviaRegister)),
			new Seller("João Mendes", 12, 2021, Arrays.asList(joaoMendes)),
			new Manager("Juliana Alvez", 7, 2017),
			new Manager("Bento Albino", 3, 2014)
		};
		
		List<IEmploye> listEmployes = Arrays.asList(arrayEmploye);
		List<EmployeWithBenefit> listEmployesWithBenefit = new ArrayList<>();
		List<Seller> listSellers = new ArrayList<>();
		listEmployes.stream().filter(employe -> employe instanceof EmployeWithBenefit).forEach(e -> listEmployesWithBenefit.add((EmployeWithBenefit) e));
		listEmployesWithBenefit.stream().filter(employeWithBenefit -> employeWithBenefit instanceof Seller).forEach(s -> listSellers.add((Seller) s));;
		
		System.out.println(getAllGrossInTheMonthForEmploye(listEmployes, 10, 2021));
		System.out.println(getAllSalaryInTheMonthForEmploye(listEmployes, 10, 2021));
		System.out.println(getAllBeneftInTheMonthForEmploye(listEmployesWithBenefit, 10, 2021));
		System.out.println(getMostSalary(listEmployes, 10, 2021));
		System.out.println(getMostBenefitedEmployeName(listEmployesWithBenefit, 10, 2021));
		System.out.println(getBestSeller(listSellers));

	}
	
	public static double getAllGrossInTheMonthForEmploye(List<IEmploye> listEmploye, int month, int year) {
		double gross = 0;
		for (IEmploye employe: listEmploye) {
			gross += employe.getSalaryPerMonth(month, year) + employe.getBenefit(month, year) ;
		}
		return gross;
	}
	
	public static double getAllSalaryInTheMonthForEmploye(List<IEmploye> listEmploye, int month, int year) {
		double gross = 0;
		for (IEmploye employe: listEmploye) {
			gross += employe.getSalaryPerMonth(month, year);
		}
		return gross;
	}
	
	public static double getAllBeneftInTheMonthForEmploye(List<EmployeWithBenefit> listEmploye, int month, int year) {
		double gross = 0;
		for (IEmploye employe: listEmploye) {
			gross += employe.getBenefit(month, year) ;
		}
		return gross;
	}
	
	public static IEmploye getMostSalary(List<IEmploye> listEmploye, int month, int year) {
		IEmploye mostPayedEmploye = null;
		double mostGross = 0;
		for (IEmploye employe: listEmploye) {
			if (mostGross < employe.getSalaryPerMonth(month, year) + employe.getBenefit(month, year)) {
				mostGross = employe.getSalaryPerMonth(month, year) + employe.getBenefit(month, year);
				mostPayedEmploye = employe;
			}
		}
		return mostPayedEmploye;
	}
	
	public static String getMostBenefitedEmployeName(List<EmployeWithBenefit> listEmploye, int month, int year) {
		EmployeWithBenefit mostPayedEmploye = null;
		double mostGross = 0;
		for (EmployeWithBenefit employe: listEmploye) {
			if (mostGross < employe.getBenefit(month, year)) {
				mostGross = employe.getBenefit(month, year);
				mostPayedEmploye = employe;
			}
		}
		if (mostPayedEmploye == null) {
			return "";
		} else {
			return mostPayedEmploye.getName();
		}
	}
	
	public static Seller getBestSeller(List<Seller> listSeller) {
		Seller seller = null;
		SellRegister sellRegister = new SellRegister(1, 1900, 0);
		for (Seller s: listSeller) {
			List<SellRegister> sellRegisterList = s.getSellRegisterList();
			for (SellRegister sr: sellRegisterList) {
				if (sellRegister.getMouthProfit() < sr.getMouthProfit()) {
					sellRegister = sr;
					seller = s;
				}
			}
		}
		return seller;
	}

}
