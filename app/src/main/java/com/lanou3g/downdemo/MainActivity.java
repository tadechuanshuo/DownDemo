package com.lanou3g.downdemo;

import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button downloadBtn1, downloadBtn2, downloadBtn3;
    private Button cancelBtn1, cancelBtn2, cancelBtn3;
    private ProgressBar progress1, progress2, progress3;
    private TextView txt1, txt2, txt3;
    private String url1 = "http://cdn.ali.vcinema.com.cn/newEncode201611/b33d30da2201ee804c32a1bd5a4b5a81/b33d30da2201ee804c32a1bd5a4b5a81_D_L_E.mp4";
    private String url2 = "http://cdn.ali.vcinema.com.cn/newEncode201611/244d4e574bdf334a57eaefaeaf3c4b95/244d4e574bdf334a57eaefaeaf3c4b95_D_L_E.mp4";
    private String url3 = "http://cdn.ali.vcinema.com.cn/newEncode201612/f26003f90f38648aeb275883b9fc69b2/f26003f90f38648aeb275883b9fc69b2_D_L_E.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBtn1 = bindView(R.id.main_btn_down1);
        downloadBtn2 = bindView(R.id.main_btn_down2);
        downloadBtn3 = bindView(R.id.main_btn_down3);

        cancelBtn1 = bindView(R.id.main_btn_cancel1);
        cancelBtn2 = bindView(R.id.main_btn_cancel2);
        cancelBtn3 = bindView(R.id.main_btn_cancel3);

        progress1 = bindView(R.id.main_progress1);
        progress2 = bindView(R.id.main_progress2);
        progress3 = bindView(R.id.main_progress3);

        txt1 = bindView(R.id.txt1);
        txt2 = bindView(R.id.txt2);
        txt3 = bindView(R.id.txt3);

        downloadBtn1.setOnClickListener(this);
        downloadBtn2.setOnClickListener(this);
        downloadBtn3.setOnClickListener(this);

        cancelBtn1.setOnClickListener(this);
        cancelBtn2.setOnClickListener(this);
        cancelBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_down1:
                DownloadManager.getInstance().download(url1, new DownLoadObserver() {
                    @Override
                    public void onNext(DownloadInfo value) {
                        super.onNext(value);
                        progress1.setMax((int) value.getTotal());
                        progress1.setProgress((int) value.getProgress());
                        txt1.setText(value.getProgress()+"");
                    }

                    @Override
                    public void onComplete() {
                        if(downloadInfo != null){
                            Toast.makeText(MainActivity.this,
                                    downloadInfo.getFileName() + "-DownloadComplete",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.main_btn_down2:
                DownloadManager.getInstance().download(url2, new DownLoadObserver() {
                    @Override
                    public void onNext(DownloadInfo value) {
                        super.onNext(value);
                        progress2.setMax((int) value.getTotal());
                        progress2.setProgress((int) value.getProgress());
                        txt2.setText(value.getProgress()+"");
                    }

                    @Override
                    public void onComplete() {
                        if(downloadInfo != null){
                            Toast.makeText(MainActivity.this,
                                    downloadInfo.getFileName() + Uri.encode("下载完成"),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.main_btn_down3:
                DownloadManager.getInstance().download(url3, new DownLoadObserver() {
                    @Override
                    public void onNext(DownloadInfo value) {
                        super.onNext(value);
                        progress3.setMax((int) value.getTotal());
                        progress3.setProgress((int) value.getProgress());
                        txt3.setText(value.getProgress()+"");
                    }

                    @Override
                    public void onComplete() {
                        if(downloadInfo != null){
                            Toast.makeText(MainActivity.this,
                                    downloadInfo.getFileName(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.main_btn_cancel1:
                DownloadManager.getInstance().cancel(url1);
                break;
            case R.id.main_btn_cancel2:
                DownloadManager.getInstance().cancel(url2);
                break;
            case R.id.main_btn_cancel3:
                DownloadManager.getInstance().cancel(url3);
                break;
        }
    }
    
    private <T extends View> T bindView(@IdRes int id){
        View viewById = findViewById(id);
        return (T) viewById;
    }
}
