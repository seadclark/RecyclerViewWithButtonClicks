package id.or.tauhid.myapplication;

public class ModelDoa {

    public static final int DOA_PAGI = 0;
    public static final int DOA_SORE = 1;
    public static final int DOA_MASJID = 2;
    public static final int DOA_BANGUNT = 3;
    public static final int DOA_MAU_TIDUR = 4;

    private String mName;
    private String bName;
    private int mType;

    private int read10 = 10;
    private int read7 = 7;

    public int getRead10() {
        return this.read10;
    }

    public void setRead10(int read10) {
        this.read10 = read10;
    }

    public int getRead7() {
        return this.read7;
    }

    public void setRead7(int read7) {
        this.read7 = read7;
    }

    
    public ModelDoa(String name, String butong, int type) {
        this.mName = name;
        this.bName = butong;
        this.mType = type;
        // Modified by Krishna Sharma
        String[] data = butong.split("\\s");
        if (data.length > 0) {
            String count = data[1].substring(0, data[1].length() - 1);
            read10 = Integer.parseInt(count);
        }
        //---------------
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }


    public int getType() {
        return mType;
    }

    public void setType(int type) { this.mType = type; }


    public String ambilName() {
        return bName;
    }

    public void setNama(String butonk) {
        this.bName = butonk;
    }

}
