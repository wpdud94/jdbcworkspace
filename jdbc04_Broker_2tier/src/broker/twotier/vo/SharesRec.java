package broker.twotier.vo;
/**
 * 
 * @author Playdata
 *
 *
 * 누가
 * 어떤 주식을
 * 얼마만큼 보유하고 있는지의 정보를 담고 있는 클래스
 * Shares 테이블의 정보
 */
public class SharesRec {
	private String ssn;
	private String symbol;
	// 얘만의 고유 특성(매우 중요)
	private int quantitiy;
	
	public SharesRec() {
	}
	public SharesRec(String ssn, String symbol, int quantitiy) {
		super();
		this.ssn = ssn;
		this.symbol = symbol;
		this.quantitiy = quantitiy;
	}
	public SharesRec(String symbol, int quantitiy) {
		this(null, symbol, quantitiy);
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}
	
	@Override
	public String toString() {
		return "SharesRec [ssn=" + ssn + ", symbol=" + symbol + ", quantitiy=" + quantitiy + "]";
	}
	
	
	

}
