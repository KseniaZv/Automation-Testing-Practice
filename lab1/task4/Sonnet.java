package task4;

public class Sonnet {
    private String sonnetName;
    private String sonnetText;

    public Sonnet(String sonnetName, String sonnetText) {
        this.sonnetName = sonnetName;
        this.sonnetText = sonnetText;
    }

    public String getSonnetName() {
        return sonnetName;
    }

    public void setSonnetName(String sonnetName) {
        this.sonnetName = sonnetName;
    }

    public String getSonnetText() {
        return sonnetText;
    }

    public void setSonnetText(String sonnetText) {
        this.sonnetText = sonnetText;
    }

    @Override
    public String toString() {
        return sonnetName + "\n" + sonnetText;
    }
}
