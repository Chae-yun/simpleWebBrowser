package kr.hs.emirim.ycy6685.simplewebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editUrl;
    Button butMove, butPrev;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrl=(EditText)findViewById(R.id.edit_url);
        butMove=(Button)findViewById(R.id.but_move);
        butPrev=(Button)findViewById(R.id.but_prev);
        web=(WebView)findViewById(R.id.web); //이것만 한다고 나오는 것 아님?
        butMove.setOnClickListener(this);
        butPrev.setOnClickListener(this);
        web.setWebViewClient(new WebViewClient()); //웹뷰 클라이언트 설정 이거 안하면 페이지 안열림
        WebSettings webSet=web.getSettings();
        webSet.setBuiltInZoomControls(true); //줌 가능하게
        webSet.setJavaScriptEnabled(true); //자바스크립트가 가능하도록 설정
        //이 위 네줄 (줌은 빼고..)이 밑에 기능의 준비!! 이거 없으면 실행 안됨
        web.loadUrl("http://www.naver.com");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) { //v는 이벤트가 발생된 객체의 참조값을 가지고 있음 이걸로 무슨 버튼인지 알아냄 id 비교해서

        String url=null;

        switch(v.getId()) {
            case R.id.but_move:
                url=editUrl.getText().toString();
                if(!url.contains("http://")){
                    url="http://"+url;
                }
                web.loadUrl(url);
                break;
            case R.id.but_prev:
                web.goBack();
                break;
        }

    }
}
