package UseString;

public class UseString {

    private String s;

    private int length;

    public enum StringFormat {
        INTEGER,
        DECIMAL,
        NUMBER,
    }

    public UseString() {
        this.s = "";
        this.length = 0;
    }

    public String getS() {
        return s;
    }

    public int getLength() {
        return length;
    }

    public void bind(StringFormat format, int length) {
        this.length = length;
        switch (format) {
            case INTEGER -> {
                this.s = this.generateInteger(this.length);
            }
            case DECIMAL -> {
                this.s = this.generateDecimal(this.length);
            }
            case NUMBER -> {
                double t = Math.random();
                if(t > 0.5) {
                    this.s = this.generateDecimal(this.length);
                } else {
                    this.s = this.generateInteger(this.length);
                }
            }
            default -> {
                this.s = "";
            }
        }
    }

    public void bind(String s) {
        this.s = s;
        this.length = s.length();
    }

    private String generateInteger(int length) {
        int i = 0;
        char randomDigit;
        StringBuilder s = new StringBuilder();
        while(i++ < length) {
            randomDigit = (char) ((int) ((Math.random() * 10) % 10) + 48);
            s.append(randomDigit);
        }
        return s.toString();
    }

    private String generateDecimal(int length) {
        int i = 0;
        char randomDigit;
        StringBuilder s = new StringBuilder();
        while(i++ < length) {
            randomDigit = (char) ((int) ((Math.random() * 10) % 10) + 48);
            s.append(randomDigit);
        }
        int pos = (int)Math.floor(Math.random() * length) % length;
        return s.replace(pos, pos + 1, ".").toString();
    }
}