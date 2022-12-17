package enums;

import java.util.Arrays;
public enum CardValue{
	two("2"), 
	three("3"), 
	four("4"), 
	five("5"), 
	six("6"), 
	seven("7"), 
	height("8"), 
	nine("9"), 
	ten("T"), 
	Jack("J"), 
	Queen("Q"), 
	King("K"), 
	Ace("A");
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;

	private CardValue(String value) {
		this.value = value;
	}

	
	public static CardValue getEnum(String value) {
	    return Arrays.stream(CardValue.values()).filter(m -> m.value.equals(value)).findAny().orElse(null);
	}

}
