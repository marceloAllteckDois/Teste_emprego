package projeto_selecao.model;

import java.util.Calendar;

public class SellRegister {
	private Calendar mouthSells;
	private double mouthProfit;
	
	public SellRegister(int month, int year, double mouthProfit) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		this.mouthSells = calendar;
		this.mouthProfit = mouthProfit;
	}
	public Calendar getMouthSells() {
		return mouthSells;
	}
	public void setMouthSells(Calendar mouthSells) {
		this.mouthSells = mouthSells;
	}
	public double getMouthProfit() {
		return mouthProfit;
	}
	public void setMouthProfit(double mouthProfit) {
		this.mouthProfit = mouthProfit;
	}
	
}
