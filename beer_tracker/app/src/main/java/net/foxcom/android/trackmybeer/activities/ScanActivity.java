package net.foxcom.android.trackmybeer.activities;

import android.app.Activity;
import net.foxcom.android.trackmybeer.classes.ScanResult;
import android.content.Intent;
import android.os.Bundle;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;
import timber.log.Timber;

public class ScanActivity extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    public void handleResult(Result rawResult) {
        String ean = rawResult.getBarcodeFormat().getName().toString();

        ScanResult result = new ScanResult();
        result.setEan(ean);
        result.setPayload(rawResult.getContents());

        Timber.d(rawResult.getContents()); // Prints scan results
        Timber.d(rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        Bundle extras = new Bundle();
        extras.putSerializable("result", result);

        Intent intent = new Intent(ScanActivity.this, ResultActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtras(extras);

        this.startActivity(intent);
    }

}
