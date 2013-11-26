/**
 * 
 */
package simbio.se.shiva.examples;

/**
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 4:19:23 AM
 */
public class Foo {

	private String fooStringPrivate;
	private int fooIntNumberPrivate;
	private long fooLongNumberPrivate;
	private float fooFloatNumberPrivate;
	private double fooDoubleNumberPrivate;
	private boolean fooBooleanPrivate;
	private char fooCharPrivate;
	private byte fooBytePrivate;

	public String fooStringPublic;
	public int fooIntNumberPublic;
	public long fooLongNumberPublic;
	public float fooFloatNumberPublic;
	public double fooDoubleNumberPublic;
	public boolean fooBooleanPublic;
	public char fooCharPublic;
	public byte fooBytePublic;

	protected String fooStringProtected;
	protected int fooIntNumberProtected;
	protected long fooLongNumberProtected;
	protected float fooFloatNumberProtected;
	protected double fooDoubleNumberProtected;
	protected boolean fooBooleanProtected;
	protected char fooCharProtected;
	protected byte fooByteProtected;

	String fooStringPackage;
	int fooIntNumberPackage;
	long fooLongNumberPackage;
	float fooFloatNumberPackage;
	double fooDoubleNumberPackage;
	boolean fooBooleanPackage;
	char fooCharPackage;
	byte fooBytePackage;

	public Foo() {
		this("fooStringPrivate", 1, 2l, 3.4f, 5.6d, true, 'a', (byte) 255, "fooStringPublic", 7, 8l, 9.10f, 11.12d, false, 'b', (byte) 128, "fooStringProtected", 13, 14l, 15.16f, 17.18d, true, 'c', (byte) 64, "fooStringPackage", 19, 20l, 21.22f, 23.24d,
				false, 'd', (byte) 32);
	}

	public Foo(String fooStringPrivate, int fooIntNumberPrivate, long fooLongNumberPrivate, float fooFloatNumberPrivate, double fooDoubleNumberPrivate, boolean fooBooleanPrivate, char fooCharPrivate, byte fooBytePrivate, String fooStringPublic,
			int fooIntNumberPublic, long fooLongNumberPublic, float fooFloatNumberPublic, double fooDoubleNumberPublic, boolean fooBooleanPublic, char fooCharPublic, byte fooBytePublic, String fooStringProtected, int fooIntNumberProtected,
			long fooLongNumberProtected, float fooFloatNumberProtected, double fooDoubleNumberProtected, boolean fooBooleanProtected, char fooCharProtected, byte fooByteProtected, String fooStringPackage, int fooIntNumberPackage,
			long fooLongNumberPackage, float fooFloatNumberPackage, double fooDoubleNumberPackage, boolean fooBooleanPackage, char fooCharPackage, byte fooBytePackage) {
		super();
		this.fooStringPrivate = fooStringPrivate;
		this.fooIntNumberPrivate = fooIntNumberPrivate;
		this.fooLongNumberPrivate = fooLongNumberPrivate;
		this.fooFloatNumberPrivate = fooFloatNumberPrivate;
		this.fooDoubleNumberPrivate = fooDoubleNumberPrivate;
		this.fooBooleanPrivate = fooBooleanPrivate;
		this.fooCharPrivate = fooCharPrivate;
		this.fooBytePrivate = fooBytePrivate;
		this.fooStringPublic = fooStringPublic;
		this.fooIntNumberPublic = fooIntNumberPublic;
		this.fooLongNumberPublic = fooLongNumberPublic;
		this.fooFloatNumberPublic = fooFloatNumberPublic;
		this.fooDoubleNumberPublic = fooDoubleNumberPublic;
		this.fooBooleanPublic = fooBooleanPublic;
		this.fooCharPublic = fooCharPublic;
		this.fooBytePublic = fooBytePublic;
		this.fooStringProtected = fooStringProtected;
		this.fooIntNumberProtected = fooIntNumberProtected;
		this.fooLongNumberProtected = fooLongNumberProtected;
		this.fooFloatNumberProtected = fooFloatNumberProtected;
		this.fooDoubleNumberProtected = fooDoubleNumberProtected;
		this.fooBooleanProtected = fooBooleanProtected;
		this.fooCharProtected = fooCharProtected;
		this.fooByteProtected = fooByteProtected;
		this.fooStringPackage = fooStringPackage;
		this.fooIntNumberPackage = fooIntNumberPackage;
		this.fooLongNumberPackage = fooLongNumberPackage;
		this.fooFloatNumberPackage = fooFloatNumberPackage;
		this.fooDoubleNumberPackage = fooDoubleNumberPackage;
		this.fooBooleanPackage = fooBooleanPackage;
		this.fooCharPackage = fooCharPackage;
		this.fooBytePackage = fooBytePackage;
	}

	public String getFooStringPrivate() {
		return fooStringPrivate;
	}

	public void setFooStringPrivate(String fooStringPrivate) {
		this.fooStringPrivate = fooStringPrivate;
	}

	public int getFooIntNumberPrivate() {
		return fooIntNumberPrivate;
	}

	public void setFooIntNumberPrivate(int fooIntNumberPrivate) {
		this.fooIntNumberPrivate = fooIntNumberPrivate;
	}

	public long getFooLongNumberPrivate() {
		return fooLongNumberPrivate;
	}

	public void setFooLongNumberPrivate(long fooLongNumberPrivate) {
		this.fooLongNumberPrivate = fooLongNumberPrivate;
	}

	public float getFooFloatNumberPrivate() {
		return fooFloatNumberPrivate;
	}

	public void setFooFloatNumberPrivate(float fooFloatNumberPrivate) {
		this.fooFloatNumberPrivate = fooFloatNumberPrivate;
	}

	public double getFooDoubleNumberPrivate() {
		return fooDoubleNumberPrivate;
	}

	public void setFooDoubleNumberPrivate(double fooDoubleNumberPrivate) {
		this.fooDoubleNumberPrivate = fooDoubleNumberPrivate;
	}

	public boolean isFooBooleanPrivate() {
		return fooBooleanPrivate;
	}

	public void setFooBooleanPrivate(boolean fooBooleanPrivate) {
		this.fooBooleanPrivate = fooBooleanPrivate;
	}

	public char getFooCharPrivate() {
		return fooCharPrivate;
	}

	public void setFooCharPrivate(char fooCharPrivate) {
		this.fooCharPrivate = fooCharPrivate;
	}

	public byte getFooBytePrivate() {
		return fooBytePrivate;
	}

	public void setFooBytePrivate(byte fooBytePrivate) {
		this.fooBytePrivate = fooBytePrivate;
	}

	public String getFooStringPublic() {
		return fooStringPublic;
	}

	public void setFooStringPublic(String fooStringPublic) {
		this.fooStringPublic = fooStringPublic;
	}

	public int getFooIntNumberPublic() {
		return fooIntNumberPublic;
	}

	public void setFooIntNumberPublic(int fooIntNumberPublic) {
		this.fooIntNumberPublic = fooIntNumberPublic;
	}

	public long getFooLongNumberPublic() {
		return fooLongNumberPublic;
	}

	public void setFooLongNumberPublic(long fooLongNumberPublic) {
		this.fooLongNumberPublic = fooLongNumberPublic;
	}

	public float getFooFloatNumberPublic() {
		return fooFloatNumberPublic;
	}

	public void setFooFloatNumberPublic(float fooFloatNumberPublic) {
		this.fooFloatNumberPublic = fooFloatNumberPublic;
	}

	public double getFooDoubleNumberPublic() {
		return fooDoubleNumberPublic;
	}

	public void setFooDoubleNumberPublic(double fooDoubleNumberPublic) {
		this.fooDoubleNumberPublic = fooDoubleNumberPublic;
	}

	public boolean isFooBooleanPublic() {
		return fooBooleanPublic;
	}

	public void setFooBooleanPublic(boolean fooBooleanPublic) {
		this.fooBooleanPublic = fooBooleanPublic;
	}

	public char getFooCharPublic() {
		return fooCharPublic;
	}

	public void setFooCharPublic(char fooCharPublic) {
		this.fooCharPublic = fooCharPublic;
	}

	public byte getFooBytePublic() {
		return fooBytePublic;
	}

	public void setFooBytePublic(byte fooBytePublic) {
		this.fooBytePublic = fooBytePublic;
	}

	public String getFooStringProtected() {
		return fooStringProtected;
	}

	public void setFooStringProtected(String fooStringProtected) {
		this.fooStringProtected = fooStringProtected;
	}

	public int getFooIntNumberProtected() {
		return fooIntNumberProtected;
	}

	public void setFooIntNumberProtected(int fooIntNumberProtected) {
		this.fooIntNumberProtected = fooIntNumberProtected;
	}

	public long getFooLongNumberProtected() {
		return fooLongNumberProtected;
	}

	public void setFooLongNumberProtected(long fooLongNumberProtected) {
		this.fooLongNumberProtected = fooLongNumberProtected;
	}

	public float getFooFloatNumberProtected() {
		return fooFloatNumberProtected;
	}

	public void setFooFloatNumberProtected(float fooFloatNumberProtected) {
		this.fooFloatNumberProtected = fooFloatNumberProtected;
	}

	public double getFooDoubleNumberProtected() {
		return fooDoubleNumberProtected;
	}

	public void setFooDoubleNumberProtected(double fooDoubleNumberProtected) {
		this.fooDoubleNumberProtected = fooDoubleNumberProtected;
	}

	public boolean isFooBooleanProtected() {
		return fooBooleanProtected;
	}

	public void setFooBooleanProtected(boolean fooBooleanProtected) {
		this.fooBooleanProtected = fooBooleanProtected;
	}

	public char getFooCharProtected() {
		return fooCharProtected;
	}

	public void setFooCharProtected(char fooCharProtected) {
		this.fooCharProtected = fooCharProtected;
	}

	public byte getFooByteProtected() {
		return fooByteProtected;
	}

	public void setFooByteProtected(byte fooByteProtected) {
		this.fooByteProtected = fooByteProtected;
	}

	public String getFooStringPackage() {
		return fooStringPackage;
	}

	public void setFooStringPackage(String fooStringPackage) {
		this.fooStringPackage = fooStringPackage;
	}

	public int getFooIntNumberPackage() {
		return fooIntNumberPackage;
	}

	public void setFooIntNumberPackage(int fooIntNumberPackage) {
		this.fooIntNumberPackage = fooIntNumberPackage;
	}

	public long getFooLongNumberPackage() {
		return fooLongNumberPackage;
	}

	public void setFooLongNumberPackage(long fooLongNumberPackage) {
		this.fooLongNumberPackage = fooLongNumberPackage;
	}

	public float getFooFloatNumberPackage() {
		return fooFloatNumberPackage;
	}

	public void setFooFloatNumberPackage(float fooFloatNumberPackage) {
		this.fooFloatNumberPackage = fooFloatNumberPackage;
	}

	public double getFooDoubleNumberPackage() {
		return fooDoubleNumberPackage;
	}

	public void setFooDoubleNumberPackage(double fooDoubleNumberPackage) {
		this.fooDoubleNumberPackage = fooDoubleNumberPackage;
	}

	public boolean isFooBooleanPackage() {
		return fooBooleanPackage;
	}

	public void setFooBooleanPackage(boolean fooBooleanPackage) {
		this.fooBooleanPackage = fooBooleanPackage;
	}

	public char getFooCharPackage() {
		return fooCharPackage;
	}

	public void setFooCharPackage(char fooCharPackage) {
		this.fooCharPackage = fooCharPackage;
	}

	public byte getFooBytePackage() {
		return fooBytePackage;
	}

	public void setFooBytePackage(byte fooBytePackage) {
		this.fooBytePackage = fooBytePackage;
	}

}
