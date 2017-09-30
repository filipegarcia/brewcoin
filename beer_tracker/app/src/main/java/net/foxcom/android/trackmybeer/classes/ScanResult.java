package net.foxcom.android.trackmybeer.classes;

import java.io.Serializable;

public class ScanResult implements Serializable {
    private String ean;

    private String payload;

    public void ScanResult() {
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getEan() {
        return this.ean;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
