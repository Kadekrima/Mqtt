package com.wahyu.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;

import com.google.zxing.Result;

import java.security.acl.Permission;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static java.util.logging.Logger.global;

public class Scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        ScannerView.startCamera();          // Start camera on resume
    }


    @Override
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.d("TAG", rawResult.getText()); // Prints scan results
        Log.d("TAG", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
        ScannerView.resumeCameraPreview(this);

    }
}
